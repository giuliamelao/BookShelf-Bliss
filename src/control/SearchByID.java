
package control;
import model.Livro;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 * Classe de tratamento de informações e dados
 * Possui métodos de edição, exclusao e visualização
 * @author Giulia de Paula Melao // RA 2267861
 */
public class SearchByID extends CadastrarLivro{
    
    /**
     * Deleta o livro conforme o ID é dado pelo usuario
     * @param id 
     */
    public void deletarLivro(String id) {
        LerArquivo ler = new LerArquivo();
        List<String[]> livroList = ler.lerArquivo("book_data.txt");

        boolean livroEncontrado = false;

        for (String[] livroData : livroList) {
            if (livroData[0].equals(id)) {
                //caixa de popup para confirmação para deletar
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
            JOptionPane.showMessageDialog(null, "Livro deletado com sucesso! Volte para a página principal e atualize a página para visualizar", "Delete Succesfull", JOptionPane.INFORMATION_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(null, "ID não encontrado!", "ID NOT FOUND", JOptionPane.ERROR_MESSAGE);

        }
    }

    /**
     * Aqui nos próximos 2 métodos temos uma das pilares da orientação a objetos, os dois métodos possuem a mesma assinatura porém parametros diferentes
     * o primeiro método é mais complexo, para edição e salvar o arquivo
     * @param id
     * @param livroNovo
     * @param autorNovo
     * @param generoNovo
     * @param anoNovo
     * @param ratingNovo
     * @param reviewNovo 
     */
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

    /**
     * Este segundo método apenas para procurar o livro no arquivo
     * @param id
     * @return o valor do Objeto Livro
     */
    public Livro procurar(String id) {
        LerArquivo ler = new LerArquivo();

        List<String[]> livroList;

        livroList = ler.lerArquivo("book_data.txt");

        Livro livro = searchByID(id, livroList);

     
        return livro;
    }
    
    
   
    /**
     * método base para a classe
     * aqui ele procura no txt a linha correta do livro
     * @param id
     * @param livroList
     * @return objeto Livro
     */
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

    
    /**
     * método para edição e do arquivo, chamado em procurar()
     * @param filename
     * @param livroList 
     */
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
    

    
