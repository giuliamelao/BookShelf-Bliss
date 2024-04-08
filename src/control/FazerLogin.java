
package control;

/**
 * Classe para facilitar a chamada dos métodos de Login
 * @author Giulia de Paula Melao // RA 2267861
 */

import control.LerArquivo;
import control.AcharUsuario;

public class FazerLogin {
    /**
     * Método que faz ou nao o login
     * @param emailOrUsername
     * @param password
     * @return se o usuario está pronto para fazer login ou não
     */
    public boolean fazerLogin(String emailOrUsername, String password) {
        LerArquivo ler = new LerArquivo();
        AcharUsuario achar = new AcharUsuario ();
        boolean user = achar.acharUsuario("user_data.txt", emailOrUsername, password);
        return user;
    }
}
