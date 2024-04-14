import java.util.Scanner;

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

    // Méthode toString pour obtenir les détails du livre en fonction de l'ISBN
    public String toString(String ISBN) {
         // On cherche si l'ISBN correspond à celui d'un livre dans la liste 
        if (this.getISBN().equals(ISBN)) {
            return "Livre " + ISBN + " :\n" +
                    "titre='" + this.getTitre() + "'\n" +
                    "auteur='" + this.getAuteur() + "'\n" +
                    "anneePublication=" + this.getAnneePublication() + "\n" +
                    "ISBN='" + this.getISBN() + "'";
        } else {
             // Si le livre n'est pas trouvé
            return "Aucun livre avec l'ISBN: " + ISBN;
        }
    }

    // Méthode utilisant toString pour obtenir les détails du livre en fonction de l'ISBN
    public void afficherDetails() {
        Scanner scanner = new Scanner(System.in);
        // On demande à l'utilisateur l'ISBN du livre dont il souhaite avoir les détails
        System.out.print("ISBN à afficher les détails : ");
        String ISBN = scanner.nextLine();
        // Application de la méthode toString
        System.out.println(this.toString(ISBN));
        scanner.close();
    }

}
