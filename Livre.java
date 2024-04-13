import java.util.Scanner;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;


public class Livre {
    // Attributs
    private String titre;
    private String auteur;
    private int anneePublication;
    private String ISBN;
    
    // Constructeur
    public Livre(String titre, String auteur, int anneePublication, String ISBN) {
        this.titre = titre;
        this.auteur = auteur;
        this.anneePublication = anneePublication;
        this.ISBN = ISBN;
    }
    
    // Getters et setters
    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public int getAnneePublication() {
        return anneePublication;
    }

    public void setAnneePublication(int anneePublication) {
        this.anneePublication = anneePublication;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }
    
    // Méthode toString()
    @Override
    public String toString() {
        return "Livre{" +
                "titre='" + titre + '\'' +
                ", auteur='" + auteur + '\'' +
                ", anneePublication=" + anneePublication +
                ", ISBN='" + ISBN + '\'' +
                '}';
    }

    public static Livre saisirLivre(Scanner scanner) {
        System.out.println("Veuillez saisir les détails du livre :");
        System.out.print("Titre : ");
        String titre = scanner.nextLine();
        
        System.out.print("Auteur : ");
        String auteur = scanner.nextLine();
        
        System.out.print("Année de publication : ");
        int anneePublication = scanner.nextInt();
        scanner.nextLine(); // Pour consommer le retour à la ligne après nextInt()
        
        System.out.print("ISBN : ");
        String ISBN = scanner.nextLine();
        
        // Création et retour du livre saisi
        return new Livre(titre, auteur, anneePublication, ISBN);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Appel de la fonction pour saisir un livre
        Livre livre = saisirLivre(scanner);
        
        // Affichage des détails du livre
        System.out.println("Détails du livre :");
        System.out.println(livre);
        
        scanner.close();
        Connection conn = null;
        String dbURL = "jdbc:mysql://localhost:3306/bibliotheque";
String username = "root";
String password = "root@123";
 
try {
 
    conn = DriverManager.getConnection(dbURL, username, password);
 
    if (conn != null) {
        System.out.println("Connected");
    }
} catch (SQLException ex) {
    ex.printStackTrace();
}
    }
    }
    

