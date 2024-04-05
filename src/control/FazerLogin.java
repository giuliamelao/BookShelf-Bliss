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
import control.LerArquivo;
import control.AcharUsuario;

public class FazerLogin {
    public boolean fazerLogin(String emailOrUsername, String password) {
        LerArquivo ler = new LerArquivo();
        AcharUsuario achar = new AcharUsuario ();
        boolean user = achar.acharUsuario("user_data.txt", emailOrUsername, password);
        return user;
    }
}
