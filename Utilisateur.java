import java.util.Scanner;
import java.util.ArrayList;
public class Utilisateur {
    String nom;
    int numeroIdentification;
    ArrayList<Livre> livresEmpruntes;
    boolean cotisationAJour=false;
    String status;


    public Utilisateur(String nom, int numeroIdentification, String status){
        this.nom=nom;
        this.numeroIdentification=numeroIdentification;
        this.status = status;
        this.livresEmpruntes = new ArrayList<>();
    }

    public void emprunterLivre(Bibliotheque bibliotheque) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez saisir votre identifiant :");
        int identifiant = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        Utilisateur utilisateur = bibliotheque.trouverUtilisateurParIdentifiant(identifiant);
        if (utilisateur == null) {
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

        bibliotheque.enregistrerEmprunt(utilisateur, livre);
        System.out.println("Le livre \"" + livre.getTitre() + "\" a été emprunté par " + utilisateur.getNom());
    }

    public void retournerLivre(Bibliotheque bibliotheque) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez saisir votre identifiant :");
        int identifiant = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        Utilisateur utilisateur = bibliotheque.trouverUtilisateurParIdentifiant(identifiant);
        if (utilisateur == null) {
            System.out.println("Utilisateur non trouvé.");
            return;
        }

        if (utilisateur.getLivresEmpruntes().isEmpty()) {
            System.out.println("Vous n'avez aucun livre emprunté.");
            return;
        }

        System.out.println("Veuillez saisir le titre du livre que vous souhaitez retourner :");
        String titre = scanner.nextLine();

        Livre livre = bibliotheque.rechercherLivreParTitre(titre);
        if (livre == null || !utilisateur.getLivresEmpruntes().contains(livre)) {
            System.out.println("Vous n'avez pas emprunté le livre avec le titre \"" + titre + "\".");
            return;
        }

        bibliotheque.enregistrerRetour(utilisateur, livre);
        System.out.println("Le livre \"" + livre.getTitre() + "\" a été retourné par " + utilisateur.getNom());
    }
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
