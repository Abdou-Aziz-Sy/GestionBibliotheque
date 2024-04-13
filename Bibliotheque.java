import java.util.ArrayList;
import java.util.HashMap;

public class Bibliotheque {
    private ArrayList<Livre> livres;
    private HashMap<Utilisateur, ArrayList<Livre>> livresEmpruntés;

    public Bibliotheque() {
        this.livres = new ArrayList<>();
        this.livresEmpruntés = new HashMap<>();
    }

    public void ajouterLivre(Livre livre) {
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
//ca marche pas
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
