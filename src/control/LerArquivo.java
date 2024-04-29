
package control;

/**
 * Classe de leitura de arquivo
 * @author Giulia de Paula Melao // RA 2267861
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LerArquivo {
    /**
     * Método que lê um arquivo txt e transforma em um arraylist
     * @param filePath
     * @return arraylist de dados
     */
    public List<String[]> lerArquivo(String filePath) {
        List<String[]> lista = new ArrayList<>();

        
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
                System.out.println("Arquivo: " + filePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
       
        
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");
                lista.add(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        
        //print só para conferir no console se está funcionando
        for (String[] data : lista) {
            for (String data2 : data) {
                System.out.print(data2 + " ");
            }
            System.out.println();
        }
        return lista;
    }
    
    
    
}