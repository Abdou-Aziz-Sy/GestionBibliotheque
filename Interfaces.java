import java.util.Scanner;

public class Interfaces {

    private final Bibliotheque bibliotheque ;
    protected Scanner sc =new Scanner(System.in);
    public Utilisateur utilisateur;
    // le type nous permet de distinguer les utilisateurs(type=false) du bibliothecaire(type=true) responsable du systéme
    protected boolean Type;



    public Interfaces(Bibliotheque bibliotheque, Utilisateur utilisateur, boolean type) {
        this.bibliotheque = bibliotheque;
        this.utilisateur = utilisateur;
        Type = type;
    }

    public void afficherMenuPrincipalUtilisateur() {
        System.out.println("===== MENU PRINCIPAL =====");
        System.out.println("1. Empunter  Livre(s)");
        System.out.println("2. Retourner Livre(s)");
        System.out.println("3. Rechercher Livre(s)");
        System.out.println("4. Deconnexion");
        System.out.print("Choisissez une Option : ");
    }
    public void afficherMenuPrincipalBibliothecaire() {
        System.out.println("===== MENU PRINCIPAL =====");
        System.out.println("1. Gestion des Livres");
        System.out.println("2. Gestion des Utilisateurs");
        System.out.println("3. Statistiques Bibliotheque");
        System.out.println("4. Deconnexion");
        System.out.print("Choisissez une Option : ");
    }
    public void afficherMenuGestionLivres() {
        System.out.println("===== GESTION DES LIVRES =====");
        System.out.println("1. Ajouter un Livre");
        System.out.println("2. Supprimer un Livre");
        System.out.println("3. Rechercher un Livre");
        System.out.println("4. Enregistrer un Emprunt");
        System.out.println("5. Enregistrer un Retour");
        System.out.println("6. Retour au menu Principal");
        System.out.print("Choisissez une Option : ");
    }

    public void afficherMenuGestionUtilisateurs() {
        System.out.println("===== GESTION DES UTILISATEURS =====");
        System.out.println("1. Ajouter un Utilisateur");
        System.out.println("2. Retour au menu Principal");
        System.out.print("Choisissez une Option : ");
    }
    public void MenuRechercheLivre(){
        System.out.println("===== RECHERCHE LIVRE =====");
        System.out.println("1. PAR TITRE");
        System.out.println("2. PAR AUTEUR");
        System.out.println("3. PAR ISBN");
        System.out.println("4. Retour au menu Principal");
        System.out.print("Choisissez une Option : ");
    }
    public void gererLivres(Utilisateur utilisateur) {
        int choix;
        do {
            afficherMenuGestionLivres();
            choix = sc.nextInt();
            sc.nextLine(); // Pour vider la ligne du scanner

            switch (choix) {
                case 1:
                    bibliotheque.ajouterLivre();
                    break;
                case 2:
                    bibliotheque.supprimerLivre();
                    break;
                case 3:
                    MenuRechercheLivre();
                    int option;
                    option = sc.nextInt();
                    if(option == 1) {
                        System.out.println("Saisir le titre du Livre :");
                        String titre = sc.nextLine();
                        bibliotheque.rechercherLivreParTitre(titre);
                    }
                    if(option == 2) {
                        System.out.println("Saisir l'auteur du Livre :");
                        String auteur = sc.nextLine();
                        bibliotheque.rechercherLivreParAuteur(auteur);
                    }
                    if(option == 3) {
                        System.out.println("Saisir ISBN du Livre :");
                        String isbn = sc.nextLine();
                        bibliotheque.rechercherLivreParISBN(isbn);
                    }
                    if (option==4)
                        gererLivres(utilisateur);
                    break;
                case 4:
                    System.out.println("Enregistrer un emprunt :");
                    System.out.print("Entrez l'ISBN du livre : ");
                    String isbnEmprunt = sc.nextLine();
                    Livre livreEmprunt = bibliotheque.rechercherLivreParISBN(isbnEmprunt);
                    if (livreEmprunt != null) {
                        bibliotheque.enregistrerEmprunt(utilisateur, livreEmprunt);
                    }
                    break;
                case 5:
                    System.out.println("Enregistrer un retour :");
                    System.out.print("Entrez l'ISBN du livre : ");
                    String isbnRetour = sc.nextLine();
                    Livre livreRetour = bibliotheque.rechercherLivreParISBN(isbnRetour);
                    if (livreRetour != null) {
                        bibliotheque.enregistrerRetour(utilisateur, livreRetour);
                    }
                    break;
                case 6:
                        return;
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
            sc.nextLine();

            switch (choix) {
                case 1:
                    //fonction pour ajout de utilisateur
                    break;
                case 2:
                   return;
                default:
                    System.out.println("Choix invalide. Veuillez choisir une option valide.");
            }
        } while (choix != 3);
    }
    public void demarrer(Utilisateur utilisateur) {
        if (utilisateur.Status) {
            int choix;
            do {
                afficherMenuPrincipalBibliothecaire();
                choix = sc.nextInt();
                sc.nextLine(); // Pour vider la ligne du scanner

                switch (choix) {
                    case 1:
                        gererLivres(utilisateur);
                        break;
                    case 2:
                        gererUtilisateurs();
                        break;
                    case 3:
                        bibliotheque.afficherStatistiquesBibliothèque();
                        break;
                    case 4:
                        System.out.println("Au revoir !");
                        break;
                    default:
                        System.out.println("Choix invalide. Veuillez choisir une option valide.");
                }
            } while (choix != 3);
        }
        else{
            afficherMenuPrincipalUtilisateur();
        }
    }


}
