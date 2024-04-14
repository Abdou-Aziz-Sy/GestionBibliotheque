import java.util.Scanner;
import java.util.ArrayList;
public class Utilisateur {
    String nom;
    int numeroIdentification; // numéro d'identification
    ArrayList<Livre> livresEmpruntes;  // liste des livres empruntés
    boolean cotisationAJour=false; // cotisation à jour ou non
    String status; // utilisateur ou bibliothecaire

    // Constructeur
    public Utilisateur(String nom, int numeroIdentification, String status){
        this.nom=nom;
        this.numeroIdentification=numeroIdentification;
        this.status = status;
        this.livresEmpruntes = new ArrayList<>();
    }
    // Méthode pour emprunter un livre
    public void emprunterLivre(Bibliotheque bibliotheque) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez saisir votre identifiant :");  // Demande de l'identifiant
        int identifiant = scanner.nextInt();
        scanner.nextLine(); // Consommer le retour à la ligne après nextInt()

        Utilisateur utilisateur = bibliotheque.trouverUtilisateurParIdentifiant(identifiant); // Recherche de l'utilisateur par son identifiant
        if (utilisateur == null) { // Si l'utilisateur n'est pas trouvé
            System.out.println("Utilisateur non trouvé.");
            return;
        }

        System.out.println("Veuillez saisir le titre du livre que vous souhaitez emprunter :");
        String titre = scanner.nextLine();

        Livre livre = bibliotheque.rechercherLivreParTitre(titre);
        if (livre == null) {
            System.out.println("Le livre avec le titre \"" + titre + "\" n'a pas été trouvé.");
            return;
        }
        // Enregistrement de l'emprunt
        bibliotheque.enregistrerEmprunt(utilisateur, livre);
        System.out.println("Le livre \"" + livre.getTitre() + "\" a été emprunté par " + utilisateur.getNom());
    }

    // Méthode pour retourner un livre
    public void retournerLivre(Bibliotheque bibliotheque) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez saisir votre identifiant :");
        int identifiant = scanner.nextInt();
        scanner.nextLine(); // Consommer le retour à la ligne après nextInt()

        Utilisateur utilisateur = bibliotheque.trouverUtilisateurParIdentifiant(identifiant); // Recherche de l'utilisateur par son identifiant
        if (utilisateur == null) {
            System.out.println("Utilisateur non trouvé.");
            return;
        }

        // Vérifier si l'utilisateur a des livres empruntés
        if (utilisateur.getLivresEmpruntes().isEmpty()) {
            System.out.println("Vous n'avez aucun livre emprunté.");
            return;
        }

        System.out.println("Veuillez saisir le titre du livre que vous souhaitez retourner :");
        String titre = scanner.nextLine();

        Livre livre = bibliotheque.rechercherLivreParTitre(titre);  // Recherche du livre par son titre
        if (livre == null || !utilisateur.getLivresEmpruntes().contains(livre)) {
            System.out.println("Vous n'avez pas emprunté le livre avec le titre \"" + titre + "\".");
            return;
        }

        bibliotheque.enregistrerRetour(utilisateur, livre); // Enregistrement du retour
        System.out.println("Le livre \"" + livre.getTitre() + "\" a été retourné par " + utilisateur.getNom());
    }
    // Méthode pour afficher les livres empruntés par l'utilisateur
       public void afficherLivresEmpruntes() {
        if (livresEmpruntes.isEmpty()) {
            System.out.println("L'utilisateur n'a emprunté aucun livre.");
        } else {
            System.out.println("Livres empruntés par " + nom + ":");
            for (Livre livre : livresEmpruntes) {
                System.out.println("- " + livre.getTitre() + " par " + livre.getAuteur());
            }
        }
    }
    // Getters
    public String getNom() {
        return nom;
    }

    public int getNumeroIdentification() {
        return numeroIdentification;
    }

    public ArrayList<Livre> getLivresEmpruntes() {
        return livresEmpruntes;
    }

    public boolean isCotisationAJour() {
        return cotisationAJour;
    }

    public String getStatus() {
        return status;
    }

    // Setters
    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setNumeroIdentification(int numeroIdentification) {
        this.numeroIdentification = numeroIdentification;
    }

    public void setLivresEmpruntes(ArrayList<Livre> livresEmpruntes) {
        this.livresEmpruntes = livresEmpruntes;
    }

    public void setCotisationAJour(boolean cotisationAJour) {
        this.cotisationAJour = cotisationAJour;
    }

    public void setStatus(String status) {
        this.status = status;
    }


}
