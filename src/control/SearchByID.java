/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;
import control.LerArquivo;
import java.util.ArrayList;
import model.Livro;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author giuli
 */
public class SearchByID extends CadastrarLivro{
    public void deletarLivro(String id) {
        LerArquivo ler = new LerArquivo();
        List<String[]> livroList = ler.lerArquivo("book_data.txt");

        boolean livroEncontrado = false;

        for (String[] livroData : livroList) {
            if (livroData[0].equals(id)) {
                int confirmacao = JOptionPane.showConfirmDialog(null, "Você tem certeza que deseja deletar o livro ID " + id + "?", "Confirmation", JOptionPane.YES_NO_OPTION);
                if (confirmacao == JOptionPane.YES_OPTION) {
                    livroList.remove(livroData);
                    livroEncontrado = true;
                    break;
                } else {
                    return;
                }
            }
        }

        if (livroEncontrado) {
            writeToFile("book_data.txt", livroList);
            System.out.println("Book with ID " + id + " deleted successfully.");
            JOptionPane.showMessageDialog(null, "Livro deletado com sucesso! Volte para a página principal e atualize a página para visualizar", "Delete Succesfull", JOptionPane.INFORMATION_MESSAGE);

        } else {
            System.out.println("Livro not found for ID: " + id);
            JOptionPane.showMessageDialog(null, "ID não encontrado!", "ID NOT FOUND", JOptionPane.ERROR_MESSAGE);

        }
    }

    
    public void procurar(String id, String livroNovo, String autorNovo, String generoNovo, String anoNovo, String ratingNovo, String reviewNovo) {
        LerArquivo ler = new LerArquivo();
        List<String[]> livroList = ler.lerArquivo("book_data.txt");

        Livro livro = searchByID(id, livroList);

        if (livro != null) {
            livro.setTitle(livroNovo);
            livro.setAuthor(autorNovo);
            livro.setGenre(generoNovo);
            livro.setYearPublished(Integer.parseInt(anoNovo));
            livro.setRating(Integer.parseInt(ratingNovo));
            livro.setReview(reviewNovo);

            for (String[] livroData : livroList) {
                if (livroData[0].equals(id)) {
                    livroData[1] = livro.getTitle();
                    livroData[2] = livro.getAuthor();
                    livroData[3] = livro.getGenre();
                    livroData[4] = String.valueOf(livro.getYearPublished());
                    livroData[5] = String.valueOf(livro.getRating());
                    livroData[6] = livro.getReview();
                    break;
                }
            }

            writeToFile("book_data.txt", livroList);
            System.out.println("Book with ID " + id + " updated successfully.");
        } else {
            System.out.println("Livro not found for ID: " + id);
        }
    }
    
    public Livro procurar(String id) {
        LerArquivo ler = new LerArquivo();

        List<String[]> livroList;

        livroList = ler.lerArquivo("book_data.txt");

        Livro livro = searchByID(id, livroList);

     
        return livro;
    }
    
    
    
    public static Livro searchByID(String id, List<String[]> livroList) {
        for (String[] livroData : livroList) {
            if (livroData[0].equals(id)) {
                Livro livro = new Livro();
                livro.setId(Integer.parseInt(livroData[0]));
                livro.setTitle(livroData[1]);
                livro.setAuthor(livroData[2]);
                livro.setGenre(livroData[3]);
                livro.setYearPublished(Integer.parseInt(livroData[4]));
                livro.setRating(Integer.parseInt(livroData[5]));
                livro.setReview(livroData[6]);
                return livro;
            }
        }
        JOptionPane.showMessageDialog(null, "ID não encontrado!", "ID NOT FOUND", JOptionPane.ERROR_MESSAGE);
        return null;
    }

    private void writeToFile(String filename, List<String[]> livroList) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (String[] livroData : livroList) {
                String line = String.join(";", livroData);
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
    

    
