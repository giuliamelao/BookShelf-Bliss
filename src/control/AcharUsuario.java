/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;
import control.LerArquivo;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Giulia de Paula Melao // RA 2267861
 */
public class AcharUsuario {
    public boolean acharUsuario(String pathfile, String emailOrUsername, String password) {
        LerArquivo ler = new LerArquivo();
        List<String[]> userList = new ArrayList<>();

        userList = ler.lerArquivo(pathfile);
        
        for (String[] userData : userList) {
            String username = userData[1]; // Index 1 is the username
            String email = userData[2];    // Index 2 is the email
            String storedPassword = userData[3]; // Index 3 is the password
            
            // Check if the email or username matches and if the password matches
            if ((emailOrUsername.equals(email) || emailOrUsername.equals(username)) && password.equals(storedPassword)) {
                System.out.println("true");
                return true; 
            }
        }
        System.out.println("false");
        return false;
    }
    
}
