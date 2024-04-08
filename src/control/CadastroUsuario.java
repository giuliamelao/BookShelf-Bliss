
package control;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 * Classe para cadastro de usuarios
 * @author Giulia de Paula Melao // RA 2267861
 */
public class CadastroUsuario {
    /**
     * Método para cadastrar o usuario no txt
     * @param nomeCad
     * @param usernameCad
     * @param emailCad
     * @param passwordCad 
     */
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
    
    /**
     * método para conferir se email ou username ja existem, o programa nao permite valores iguais
     * @param email
     * @param username
     * @return se existe o username/email ou nao
     */
    public boolean usuarioJaExiste(String email, String username) {
        LerArquivo ler = new LerArquivo();
        List<String[]> userList = new ArrayList<>();

        userList = ler.lerArquivo("user_data.txt");
        
        for (String[] userData : userList) {
            String usernameTxt = userData[1]; // Index 1 username
            String emailTxt = userData[2];    // Index 2 email
            
            if ((email.equals(emailTxt) || username.equals(usernameTxt))) {
                System.out.println("Username ou email já existe");
                return true; 
            }
        }
        System.out.println("false");
        return false;
    }
    
}
