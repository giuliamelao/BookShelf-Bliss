/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;
import control.LerArquivo;
import java.util.ArrayList;
import model.Livro;
import java.util.List;
/**
 *
 * @author giuli
 */
public class SearchByID {
    public Livro procurar(String id) {
        LerArquivo ler = new LerArquivo();

        List<String[]> livroList;

        livroList = ler.lerArquivo("book_data.txt");

        Livro livro = searchByID(id, livroList);

        // Now you can use the Livro object as needed
        if (livro != null) {
            System.out.println("Name: " + livro.getTitle());
            System.out.println("Author: " + livro.getAuthor());
            System.out.println("Genre: " + livro.getGenre());
            System.out.println("Year: " + livro.getYearPublished());
            System.out.println("Rating: " + livro.getRating());
            System.out.println("Review: " + livro.getReview());
        } else {
            System.out.println("Livro not found for ID: " + id);
        }
        return livro;
    }
    
    public static Livro searchByID(String id, List<String[]> livroList) {
        for (String[] livroData : livroList) {
            // Check if the ID matches the ID entered by the user
            if (livroData[0].equals(id)) {
                Livro livro = new Livro();
                livro.setId(Integer.parseInt(livroData[0]));
                livro.setTitle(livroData[1]);
                livro.setAuthor(livroData[2]);
                livro.setGenre(livroData[3]);
                livro.setYearPublished(Integer.parseInt(livroData[4]));
                livro.setRating(Integer.parseInt(livroData[5]));
                livro.setReview(livroData[6]);
                return livro;
            }
        }
        // If no match is found, return null or handle it as needed
        return null;
    }


}
    

    
