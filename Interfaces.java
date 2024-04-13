import java.util.Scanner;

public class Interfaces {
    private  Bibliotheque bibliotheque;
    private Scanner sc;

    protected boolean Status;
    public Interfaces(Bibliotheque bibliotheque) {
        this.bibliotheque = bibliotheque;
        this.sc = new Scanner(System.in);
    }
    public void afficherMenuPrincipalUtilisateur() {
        System.out.println("===== MENU PRINCIPAL =====");
        System.out.println("1. Empunter  Livre(s)");
        System.out.println("2. Retourner Livre(s)");
        System.out.println("3. Deconnexion");
        System.out.print("Choisissez une Option : ");
    }
    public void afficherMenuPrincipalBibliothecaire() {
        System.out.println("===== MENU PRINCIPAL =====");
        System.out.println("1. Gestion des Livres");
        System.out.println("2. Gestion des Utilisateurs");
        System.out.println("3. Deconnexion");
        System.out.print("Choisissez une Option : ");
    }
    public void afficherMenuGestionLivres() {
        System.out.println("===== GESTION DES LIVRES =====");
        System.out.println("1. Ajouter un Livre");
        System.out.println("2. Supprimer un Livre");
        System.out.println("3. Rechercher un Livre");
        System.out.println("4. Retour au menu Principal");
        System.out.print("Choisissez une Option : ");
    }

    public void afficherMenuGestionUtilisateurs() {
        System.out.println("===== GESTION DES UTILISATEURS =====");
        System.out.println("1. Ajouter un Utilisateur");
        System.out.println("2. Vérifier l'éligibilité d'un Utilisateur");
        System.out.println("3. Retour au menu Principal");
        System.out.print("Choisissez une Option : ");
    }
    public void gererLivres() {
        int choix;
        do {
            afficherMenuGestionLivres();
            choix = sc.nextInt();
            sc.nextLine(); // Pour vider la ligne du scanner

            switch (choix) {
                case 1:
                    // Logique pour ajouter un livre
                    break;
                case 2:
                    // Logique pour supprimer un livre
                    break;
                case 3:
                    // Logique pour rechercher un livre
                    break;
                case 4:
                    System.out.println("Retour au menu principal...");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez choisir une option valide.");
            }
        } while (choix != 4);
    }
    public void gererUtilisateurs() {
        int choix;
        do {
            afficherMenuGestionUtilisateurs();
            choix = sc.nextInt();
            sc.nextLine(); //

            switch (choix) {
                case 1:
                    //
                    break;
                case 2:
                    //
                    break;
                case 3:
                    System.out.println("Retour au menu principal...");
                    break;
                default:
                    System.out.println("Choix invalide. Veuillez choisir une option valide.");
            }
        } while (choix != 3);
    }
    public void demarrer() {
        if (Status) {
            int choix;
            do {
                afficherMenuPrincipalBibliothecaire();
                choix = sc.nextInt();
                sc.nextLine(); // Pour vider la ligne du scanner

                switch (choix) {
                    case 1:
                        gererLivres();
                        break;
                    case 2:
                        gererUtilisateurs();
                        break;
                    case 3:
                        System.out.println("Au revoir !");
                        break;
                    default:
                        System.out.println("Choix invalide. Veuillez choisir une option valide.");
                }
            } while (choix != 3);
        }
        else{

        }
    }

    public static void main(String[] args){
        Bibliotheque B = new Bibliotheque();
        Interfaces it = new Interfaces(B);
        it.afficherMenuPrincipalUtilisateur();
    }
}
