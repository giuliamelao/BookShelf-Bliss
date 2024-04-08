/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;
import control.LerArquivo;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe utilizada para fazer o login, encontrar o usuario
 * @author Giulia de Paula Melao // RA 2267861
 * @version 1.0
 */
public class AcharUsuario {
    /**
     * Método que busca o usuario no txt
     * @param pathfile
     * @param emailOrUsername
     * @param password
     * @return se o usuario está cadastrado e a senha está correta
     */
    public boolean acharUsuario(String pathfile, String emailOrUsername, String password) {
        
        LerArquivo ler = new LerArquivo();
        List<String[]> userList = new ArrayList<>();

        userList = ler.lerArquivo(pathfile);
        
        for (String[] userData : userList) {
            String username = userData[1]; // Index 1 username
            String email = userData[2];    // Index 2 email
            String storedPassword = userData[3]; // Index 3 password
            
            
            //aqui vai conferir se email||username existem no txt e conferir a senha retirnando true||false
            if ((emailOrUsername.equals(email) || emailOrUsername.equals(username)) && password.equals(storedPassword)) {
                return true; 
            }
        }
        return false;
    }
    
    
    
}
