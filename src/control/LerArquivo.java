/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

/**
 *
 * @author giuli
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LerArquivo {
    public List<String[]> lerArquivo(String filePath) {
        List<String[]> lista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(";");
                lista.add(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String[] data : lista) {
            for (String data2 : data) {
                System.out.print(data2 + " ");
            }
            System.out.println();
        }
        return lista;
    }
    
    
    
}