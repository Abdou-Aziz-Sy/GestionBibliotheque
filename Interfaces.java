import java.util.Scanner;

public class Interfaces {

    private final Bibliotheque bibliotheque;
    protected Scanner sc = new Scanner(System.in);


    public Utilisateur utilisateur;

    // Constructeur
    public Interfaces(Bibliotheque bibliotheque) {
        this.bibliotheque = bibliotheque;
        this.utilisateur = utilisateur;
    }
    // Méthode pour afficher le menu principal de l'application pour un utilisateur
    public void afficherMenuPrincipalUtilisateur() {
        System.out.println("\n===== MENU PRINCIPAL =====");
        System.out.println("1. Empunter  Livre(s)");
        System.out.println("2. Retourner Livre(s)");
        System.out.println("3. Rechercher Livre(s)");
        System.out.println("4. Deconnexion");
        System.out.println("==========================\n");
        System.out.print("Choisissez une Option : ");
    }
    // Méthode pour afficher le menu principal de l'application pour un bibliothécaire
    public void afficherMenuPrincipalBibliothecaire() {
        System.out.println("\n===== MENU PRINCIPAL =====");
        System.out.println("1. Gestion des Livres");
        System.out.println("2. Gestion des Utilisateurs");
        System.out.println("3. Statistiques Bibliotheque");
        System.out.println("4. Deconnexion");
        System.out.println("==========================\n");
        System.out.print("Choisissez une Option : ");
    }
    // Méthode pour afficher le menu de gestion des livres
    public void afficherMenuGestionLivres() {
        System.out.println("\n===== GESTION DES LIVRES =====");
        System.out.println("1. Ajouter un Livre");
        System.out.println("2. Supprimer un Livre");
        System.out.println("3. Rechercher un Livre");
        System.out.println("4. Enregistrer un Emprunt");
        System.out.println("5. Enregistrer un Retour");
        System.out.println("6. Modifier un Livre");
        System.out.println("7. Retour au menu Principal");
        System.out.println("==============================\n");
        System.out.print("Choisissez une Option : ");
    }
    // Méthode pour afficher le menu de gestion des utilisateurs
    public void afficherMenuGestionUtilisateurs() {
        System.out.println("\n===== GESTION DES UTILISATEURS =====");
        System.out.println("1. Ajouter un Utilisateur");
        System.out.println("2. Supprimer un Utilisateur");
        System.out.println("3. Retour au menu Principal");
        System.out.println("====================================\n");
        System.out.print("Choisissez une Option : ");
    }
    // Méthode pour afficher le menu de recherche de livre
    public void MenuRechercheLivre() {
        System.out.println("\n===== RECHERCHE LIVRE =====");
        System.out.println("1. PAR TITRE");
        System.out.println("2. PAR AUTEUR");
        System.out.println("3. PAR ISBN");
        System.out.println("4. Retour au menu Principal");
        System.out.println("===========================\n");
        System.out.print("Choisissez une Option : ");
    }

    // Méthode pour gérer les livres
    public void gererLivres(Utilisateur utilisateur) {
        int choix;
        do {
            // Afficher le menu de gestion des livres
            afficherMenuGestionLivres();
            choix = sc.nextInt();
            sc.nextLine(); // Pour vider la ligne du scanner

            switch (choix) {
                case 1:
                    bibliotheque.ajouterLivre(sc);
                    break;
                case 2:
                    bibliotheque.supprimerLivre(sc);
                    break;
                case 3:
                    // Option pour rechercher un livre
                    MenuRechercheLivre();
                    int option;
                    option = sc.nextInt();
                    sc.nextLine(); // Pour vider la ligne du scanner
                    // Recherche de livre par titre
                    if (option == 1) {
                        System.out.println("Saisir le titre du Livre :");
                        String titre = sc.nextLine();
                        Livre livre = bibliotheque.rechercherLivreParTitre(titre);

                    }
                    // Recherche de livre par auteur
                    if (option == 2) {
                        System.out.println("Saisir l'auteur du Livre :");
                        String auteur = sc.nextLine();
                        bibliotheque.rechercherLivreParAuteur(auteur);
                    }
                    // Recherche de livre par ISBN
                    if (option == 3) {
                        System.out.println("Saisir ISBN du Livre :");
                        String isbn = sc.nextLine();
                        bibliotheque.rechercherLivreParISBN(isbn);
                    }
                    // Retour au menu principal
                    if (option == 4)
                        gererLivres(utilisateur);
                    break;
                case 4:
                    // Option pour enregistrer un emprunt
                    System.out.println("Enregistrer un emprunt :");
                    System.out.print("Entrez l'ISBN du livre : ");
                    String isbnEmprunt = sc.nextLine();
                    Livre livreEmprunt = bibliotheque.rechercherLivreParISBN(isbnEmprunt);
                    if (livreEmprunt != null) {
                        bibliotheque.enregistrerEmprunt(utilisateur, livreEmprunt);
                    }
                    break;
                case 5:
                    // Option pour enregistrer un retour
                    System.out.println("Enregistrer un retour :");
                    System.out.print("Entrez l'ISBN du livre : ");
                    String isbnRetour = sc.nextLine();
                    Livre livreRetour = bibliotheque.rechercherLivreParISBN(isbnRetour);
                    if (livreRetour != null) {
                        bibliotheque.enregistrerRetour(utilisateur, livreRetour);
                    }
                    break;
                case 6:
                    // Option pour modifier un livre
                    System.out.println("Modifier un livre :");
                    System.out.print("Entrez l'ISBN du livre : ");
                    String isbn = sc.nextLine();
                    Livre livre = bibliotheque.rechercherLivreParISBN(isbn);
                    if (livre != null) {
                        System.out.print("Entrez le nouveau titre : ");
                        String titre = sc.nextLine();
                        livre.setTitre(titre);
                        System.out.print("Entrez le nouvel auteur : ");
                        String auteur = sc.nextLine();
                        livre.setAuteur(auteur);
                        System.out.print("Entrez la nouvelle année de publication : ");
                        int anneePublication = sc.nextInt();
                        livre.setAnneePublication(anneePublication);
                        System.out.println("Le livre a été modifié avec succès.");
                    }
                    break;
                case 7:
                    // Retour au menu principal
                    return;
                default:
                    System.out.println("Choix invalide. Veuillez choisir une option valide.");
            }
        } while (choix != 6);
    }
    // Méthode pour gérer les utilisateurs
    public void gererUtilisateurs() {
        int choix;
        do {
            afficherMenuGestionUtilisateurs();
            choix = sc.nextInt();
            sc.nextLine(); // Pour vider la ligne du scanner

            switch (choix) {
                case 1:
                    bibliotheque.ajouterUtilisateur(sc);
                    break;
                case 2:
                    bibliotheque.supprimerUtilisateur(sc);
                    break;
                case 3:
                    // Retour au menu principal
                    MenuRechercheLivre();
                    int option;
                    option = sc.nextInt();
                    sc.nextLine(); // Pour vider la ligne du scanner
                    // Recherche de livre par titre
                    if (option == 1) {
                        System.out.println("Saisir le titre du Livre :");
                        String titre = sc.nextLine();
                        Livre livre = bibliotheque.rechercherLivreParTitre(titre);

                    }
                    // Recherche de livre par auteur
                    if (option == 2) {
                        System.out.println("Saisir l'auteur du Livre :");
                        String auteur = sc.nextLine();
                        bibliotheque.rechercherLivreParAuteur(auteur);
                    }
                    // Recherche de livre par ISBN
                    if (option == 3) {
                        System.out.println("Saisir ISBN du Livre :");
                        String isbn = sc.nextLine();
                        bibliotheque.rechercherLivreParISBN(isbn);
                    }
                    // Retour au menu principal
                    if (option == 4)
                        return;
                    break;
                case 4:
                    // Retour au menu principal
                    return;

                default:
                    System.out.println("Choix invalide. Veuillez choisir une option valide.");
            }
        } while (choix != 3);
    }
    // Méthode pour démarrer l'application
    public void demarrer(Utilisateur utilisateur, Bibliotheque bibliotheque) {
        if (utilisateur.status.equals("bibliothecaire")) { // Si l'utilisateur est un bibliothécaire
            int choix;
            do {
                afficherMenuPrincipalBibliothecaire();  // Afficher le menu principal pour un bibliothécaire
                choix = sc.nextInt();
                sc.nextLine(); // Pour vider la ligne du scanner

                switch (choix) {
                    case 1:
                        // Gérer les livres
                        gererLivres(utilisateur);
                        break;
                    case 2:
                        // Gérer les utilisateurs
                        gererUtilisateurs();
                        break;
                    case 3:
                        // Afficher les statistiques de la bibliothèque
                        bibliotheque.afficherStatistiquesBibliothèque();
                        break;
                    case 4:
                        // Option pour se déconnecter
                        System.out.println("Au revoir !");
                        return;
                    default:
                        System.out.println("Choix invalide. Veuillez choisir une option valide.");
                }
            } while (choix != 4); // Tant que l'utilisateur ne choisit pas de se déconnecter
        } else {
            // Si l'utilisateur est un utilisateur
            int choix;
            do {
                afficherMenuPrincipalUtilisateur();
                choix = sc.nextInt();
                sc.nextLine(); // Pour vider la ligne du scanner

                switch (choix) {
                    case 1:
                        // Option pour emprunter un livre
                        System.out.println("===== EMPRUNTER UN LIVRE =====");
                        utilisateur.emprunterLivre(bibliotheque);
                        break;
                    case 2:
                        // Option pour retourner un livre
                        System.out.println("===== RETOURNER UN LIVRE =====");
                        utilisateur.retournerLivre(bibliotheque);
                        break;
                    case 3:
                        // Option pour rechercher un livre
                        System.out.println("===== RECHERCHER UN LIVRE =====");
                        MenuRechercheLivre();
                        int option;
                        option = sc.nextInt();
                        sc.nextLine(); // Pour vider la ligne du scanner
                        if (option == 1) {
                            // Recherche de livre par titre
                            System.out.println("Saisir le titre du Livre :");
                            String titre = sc.nextLine();
                            bibliotheque.rechercherLivreParTitre(titre);
                        }
                        if (option == 2) {
                            // Recherche de livre par auteur
                            System.out.println("Saisir l'auteur du Livre :");
                            String auteur = sc.nextLine();
                            bibliotheque.rechercherLivreParAuteur(auteur);
                        }
                        if (option == 3) {
                            // Recherche de livre par ISBN
                            System.out.println("Saisir ISBN du Livre :");
                            String isbn = sc.nextLine();
                            bibliotheque.rechercherLivreParISBN(isbn);
                        }
                        if (option == 4) // Retour au menu principal
                            return;
                    case 4:
                        // Option pour se déconnecter
                        System.out.println("Déconnexion...");
                        return;
                    default:
                        System.out.println("Choix invalide. Veuillez choisir une option valide.");
                }
            } while (choix != 4);// Tant que l'utilisateur ne choisit pas de se déconnecter
        }
    }
}