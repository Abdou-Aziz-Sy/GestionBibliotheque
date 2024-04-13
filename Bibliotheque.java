import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Bibliotheque {
    private ArrayList<Livre> livres;
    private HashMap<Utilisateur, ArrayList<Livre>> livresEmpruntes;

    public Bibliotheque() {
        this.livres = new ArrayList<>();
        this.livresEmpruntes = new HashMap<>();
    }

    public void ajouterLivre() {
        Scanner scanner = new Scanner(System.in);
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
        scanner.close();
    }
    // Méthode permettant de supprimer un livre à partir de son ISBN
    public void supprimerLivre() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez l'ISBN du livre à supprimer : ");
        String ISBN = scanner.nextLine();
    
        Livre livreASupprimer = null;
        for (Livre livre : livres) {
            if (livre.getISBN().equals(ISBN)) {
                livreASupprimer = livre;
                break;
            }
        }
    
        if (livreASupprimer != null) {
            livres.remove(livreASupprimer);
            System.out.println("Le livre a été supprimé avec succès.");
        } else {
            System.out.println("Livre non trouvé.");
        }
        scanner.close();
    }

    public Livre rechercherLivreParTitre(String titre) {
        for (Livre livre : livres) {
            if (livre.getTitre().equals(titre)) {
                return livre;
            }
        }
        System.out.println("Aucun livre du nom " + titre);
        return null; // Livre non trouvé
    }

    public Livre rechercherLivreParAuteur(String auteur) {
        for (Livre livre : livres) {
            if (livre.getAuteur().equals(auteur)) {
                return livre;
            }
        }
        System.out.println("Livre non trouvé pour l'auteur " + auteur);
        return null; // Livre non trouvé
    }

    public Livre rechercherLivreParISBN(String ISBN) {
        for (Livre livre : livres) {
            if (livre.getISBN().equals(ISBN)) {
                return livre;
            }
        }
        System.out.println("Aucun livre ne correspond à l'ISBN : " + ISBN);
        return null; // Livre non trouvé
    }
    public boolean verifierEligibiliteEmprunt(Utilisateur utilisateur) {
        return utilisateur.estAJour();
    }
    
    public void enregistrerEmprunt(Utilisateur utilisateur, Livre livre) {
        if (livresEmpruntes.containsKey(utilisateur)) {
            ArrayList<Livre> livresEmpruntesUtilisateur = livresEmpruntes.get(utilisateur);
            livresEmpruntesUtilisateur.add(livre);
            livresEmpruntes.put(utilisateur, livresEmpruntesUtilisateur);
        } else {
            ArrayList<Livre> livresEmpruntesUtilisateur = new ArrayList<>();
            livresEmpruntesUtilisateur.add(livre);
            livresEmpruntes.put(utilisateur, livresEmpruntesUtilisateur);
        }
    }

    public void enregistrerRetour(Utilisateur utilisateur, Livre livre) {
        if (livresEmpruntes.containsKey(utilisateur)) {
            ArrayList<Livre> livresEmpruntesUtilisateur = livresEmpruntes.get(utilisateur);
            livresEmpruntesUtilisateur.remove(livre);
            livresEmpruntes.put(utilisateur, livresEmpruntesUtilisateur);
        }
    }
        
    public void afficherStatistiquesBibliothèque() {
        System.out.println("---*Statistiques de la bibliothèque*----- :");
        System.out.println("**Nombre total de livres : " + livres.size());
        System.out.println("**Nombre de livres empruntés : " + livresEmpruntes.size());
    }
    
}
