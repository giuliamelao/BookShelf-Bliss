
package control;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
/**
 * Classe para cadastro de dados
 * @author Giulia de Paula Melao // RA 2267861
 */
public class CadastrarLivro {
    
    /**
     * Método para cadastro
     * @param title
     * @param author
     * @param genre
     * @param yearPublished
     * @param rating
     * @param review 
     */
    public void cadastrarLivro(String title, String author, String genre, String yearPublished, String rating, String review) {
        //aqui eu precisava de um método para criar o ID iterativamente
        int lastId = getLastIdFromFile();
        //por algum motivo lastId + 1 funciona mas lastId++ não funciona, fica aqui se souber a explicação
        int nextId = lastId + 1;
        
        String data = nextId + ";" + title + ";" + author + ";" + genre + ";" + yearPublished + ";" + rating + ";" + review + "\n";

        String filepath = "book_data.txt";
        
        try {
            FileWriter writer = new FileWriter(filepath, true);//true para iterar o arquivo ao inves de sobrescrever

            writer.write(data);
            writer.close();
                        
            JOptionPane.showMessageDialog(null, "Livro cadastrado com sucesso!", "Cadastro com Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
    /**
     * Método para buscar o ultimo id
     * @return o valor do ultimo ID encontrado
     */
    private int getLastIdFromFile() {
        int lastId = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("book_data.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                lastId = Integer.parseInt(parts[0]);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo.");
            e.printStackTrace();
        }
        return lastId;
    }
}
