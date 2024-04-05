/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
/**
 *
 * @author Giulia de Paula Melao // RA 2267861
 */
public class CadastrarLivro {
    
    public void cadastrarLivro(String title, String author, String genre, String yearPublished, String rating, String review) {
        int lastId = getLastIdFromFile();
        int nextId = lastId + 1;
        
        String data = nextId + ";" + title + ";" + author + ";" + genre + ";" + yearPublished + ";" + rating + ";" + review + "\n";

        String filepath = "book_data.txt";
        
        try {
            FileWriter writer = new FileWriter(filepath, true);

            writer.write(data);
            writer.close();
                        
            JOptionPane.showMessageDialog(null, "Livro cadastrado com sucesso!", "Cadastro com Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (IOException e) {
            System.out.println("Erro ao salvar. Tente novamente.");
            e.printStackTrace();
        }
    }
    
    private int getLastIdFromFile() {
        int lastId = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("book_data.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                lastId = Integer.parseInt(parts[0]); // Assuming ID is the first part of each line
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo.");
            e.printStackTrace();
        }
        return lastId;
    }
}
