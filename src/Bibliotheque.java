import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Bibliotheque {
    private ArrayList<Livre> livres;
    private HashMap<Utilisateur, ArrayList<Livre>> livresEmpruntés;

    public Bibliotheque() {
        this.livres = new ArrayList<>();
        this.livresEmpruntés = new HashMap<>();
    }
    Scanner scanner = new Scanner(System.in);

    public void ajouterLivre() {
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
        Livre livre = new Livre(titre, auteur, anneePublication, ISBN);
        livres.add(livre);
    }

    public void supprimerLivre(Livre livre) {
        livres.remove(livre);
    }

    public Livre rechercherLivreParTitre(String titre) {
        for (Livre livre : livres) {
            if (livre.getTitre().equals(titre)) {
                return livre;
            }
        }
        return null; // Livre non trouvé
    }

    public Livre rechercherLivreParAuteur(String auteur) {
        for (Livre livre : livres) {
            if (livre.getAuteur().equals(auteur)) {
                return livre;
            }
        }
        return null; // Livre non trouvé
    }

    public Livre rechercherLivreParISBN(String ISBN) {
        for (Livre livre : livres) {
            if (livre.getISBN().equals(ISBN)) {
                return livre;
            }
        }
        return null; // Livre non trouvé
    }

    public void emprunterLivre(Utilisateur utilisateur, Livre livre) {
        if (!livresEmpruntés.containsKey(utilisateur)) {
            livresEmpruntés.put(utilisateur, new ArrayList<>());
        }
        livresEmpruntés.get(utilisateur).add(livre);
    }

    public void retournerLivre(Utilisateur utilisateur, Livre livre) {
        livresEmpruntés.get(utilisateur).remove(livre);
    }

    public void afficherStatistiquesBibliothèque() {
        System.out.println("Statistiques de la bibliothèque :");
        System.out.println("Nombre total de livres : " + livres.size());
        System.out.println("Nombre de livres empruntés : " + livresEmpruntés.size());
    }
}
