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
public class CadastroUsuario {
    
    public void cadastrar(String nomeCad, String usernameCad, String emailCad, String passwordCad) {
        String data = nomeCad + ";" + usernameCad + ";" + emailCad + ";" + passwordCad + "\n";

        String filepath = "user_data.txt";
        
        try {
            FileWriter writer = new FileWriter(filepath, true);

            writer.write(data);
            writer.close();
                        
            JOptionPane.showMessageDialog(null, "Cadastro feito com Sucesso! Faça o Login.", "Cadastro com Sucesso", JOptionPane.INFORMATION_MESSAGE);

        } catch (IOException e) {
            System.out.println("Erro ao salvar. Tente novamente.");
            e.printStackTrace();
        }
    }
    
}
