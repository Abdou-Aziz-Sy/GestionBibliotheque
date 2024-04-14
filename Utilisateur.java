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

    public void emprunterLivre() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez saisir votre identifiant :");
        int identifiant = scanner.nextInt();

        Bibliotheque bibliotheque = new Bibliotheque(); // Création de l'instance de la bibliothèque
        Utilisateur utilisateur = bibliotheque.trouverUtilisateurParIdentifiant(identifiant);

        if (utilisateur != null) {
            System.out.println("Veuillez saisir le titre du livre que vous souhaitez emprunter :");
            String titre = scanner.nextLine();

            Livre livre = bibliotheque.rechercherLivreParTitre(titre);

            if (livre != null) {
                bibliotheque.enregistrerEmprunt(utilisateur, livre);
                System.out.println("Le livre \"" + livre.getTitre() + "\" a été emprunté par " + utilisateur.getNom());
            } else {
                System.out.println("Le livre avec le titre \"" + titre + "\" n'a pas été trouvé.");
            }
        } else {
            System.out.println("Utilisateur non trouvé.");
        }

        scanner.close();
    }

    public void retournerLivre() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez saisir votre identifiant :");
        int identifiant = scanner.nextInt();

        Bibliotheque bibliotheque = new Bibliotheque(); // Création de l'instance de la bibliothèque
        Utilisateur utilisateur = bibliotheque.trouverUtilisateurParIdentifiant(identifiant);

        if (utilisateur != null) {
            if (!utilisateur.getLivresEmpruntes().isEmpty()) {
                System.out.println("Veuillez saisir le titre du livre que vous souhaitez retourner :");
                String titre = scanner.nextLine();

                Livre livre = bibliotheque.rechercherLivreParTitre(titre);

                if (livre != null && utilisateur.getLivresEmpruntes().contains(livre)) {
                    bibliotheque.enregistrerRetour(utilisateur, livre);
                    System.out.println("Le livre \"" + livre.getTitre() + "\" a été retourné par " + utilisateur.getNom());
                } else {
                    System.out.println("Vous n'avez pas emprunté le livre avec le titre \"" + titre + "\".");
                }
            } else {
                System.out.println("Vous n'avez aucun livre emprunté.");
            }
        } else {
            System.out.println("Utilisateur non trouvé.");
        }

        scanner.close();
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
