import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Bibliotheque {
    private ArrayList<Livre> listeLivres;
    private HashMap<Utilisateur, ArrayList<Livre>> empruntsUtilisateur;
    private ArrayList<Utilisateur> utilisateurs;
    public Bibliotheque() {
        this.listeLivres = new ArrayList<>();
        this.empruntsUtilisateur = new HashMap<>();
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
        listeLivres.add(livre);
        scanner.close();
    }
        // Méthode permettant de modifier un livre à partir de son ISBN
        public void modifierLivre() {
            Scanner scanner = new Scanner(System.in);
            // On demande à l'utilisateur l'ISBN du livre dont il souhaite modier
            System.out.print("Entrez l'ISBN du livre à modifier : ");
            String ISBN = scanner.nextLine();
            for (Livre livre : listeLivres) {
                if (livre.getISBN().equals(ISBN)) {
                    // Si le livre est trouvé il rempli un formulaire pour modifier les informations
                    System.out.println("Livre trouvé. Veuillez saisir les nouvelles informations :");
                    System.out.print("Nouveau titre : ");
                    String nouveauTitre = scanner.nextLine();
                    livre.setTitre(nouveauTitre);
                    
                    System.out.print("Nouvel auteur : ");
                    String nouvelAuteur = scanner.nextLine();
                    livre.setAuteur(nouvelAuteur);
                    
                    System.out.print("Nouvelle année de publication : ");
                    int nouvelleAnneePublication = scanner.nextInt();
                    livre.setAnneePublication(nouvelleAnneePublication);
                    scanner.nextLine(); 
                    //Confirmation de la mise à jour 
                    System.out.println("Les informations du livre ont été mises à jour.");
                    scanner.close();
                    return;
                }
            }
            // Si le livre n'est trouvé
            System.out.println("Aucun livre trouvé avec l'ISBN : " + ISBN);
            scanner.close();
        }
    // Méthode permettant de supprimer un livre à partir de son ISBN
    public void supprimerLivre() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez l'ISBN du livre à supprimer : ");
        String ISBN = scanner.nextLine();
    
        Livre livreASupprimer = null;
        for (Livre livre : listeLivres) {
            if (livre.getISBN().equals(ISBN)) {
                livreASupprimer = livre;
                break;
            }
        }
    
        if (livreASupprimer != null) {
            listeLivres.remove(livreASupprimer);
            System.out.println("Le livre a été supprimé avec succès.");
        } else {
            System.out.println("Livre non trouvé.");
        }
        scanner.close();
    }

    public Livre rechercherLivreParTitre(String titre) {
        for (Livre livre : listeLivres) {
            if (livre.getTitre().equals(titre)) {
                return livre;
            }
        }
        System.out.println("Aucun livre du nom " + titre);
        return null; // Livre non trouvé
    }

    public Livre rechercherLivreParAuteur(String auteur) {
        for (Livre livre : listeLivres) {
            if (livre.getAuteur().equals(auteur)) {
                return livre;
            }
        }
        System.out.println("Livre non trouvé pour l'auteur " + auteur);
        return null; // Livre non trouvé
    }

    public Livre rechercherLivreParISBN(String ISBN) {
        for (Livre livre : listeLivres) {
            if (livre.getISBN().equals(ISBN)) {
                return livre;
            }
        }
        System.out.println("Aucun livre ne correspond à l'ISBN : " + ISBN);
        return null; // Livre non trouvé
    }
    //Méthode pour chercher un utilisateur par son identifiant
    public Utilisateur trouverUtilisateurParIdentifiant(int identifiant) {
        for (Utilisateur utilisateur : utilisateurs) {
            if (utilisateur.getNumeroIdentification() == identifiant) {
                return utilisateur;
            }
        }
        return null; // Aucun utilisateur trouvé avec cet identifiant
    }
    

    public void enregistrerEmprunt(Utilisateur utilisateur, Livre livre) {
        if (empruntsUtilisateur.containsKey(utilisateur)) {
            ArrayList<Livre> livresEmpruntesUtilisateur = empruntsUtilisateur.get(utilisateur);
            livresEmpruntesUtilisateur.add(livre);
            empruntsUtilisateur.put(utilisateur, livresEmpruntesUtilisateur);
        } else {
            ArrayList<Livre> livresEmpruntesUtilisateur = new ArrayList<>();
            livresEmpruntesUtilisateur.add(livre);
            empruntsUtilisateur.put(utilisateur, livresEmpruntesUtilisateur);
        }
    }

    public void enregistrerRetour(Utilisateur utilisateur, Livre livre) {
        if (empruntsUtilisateur.containsKey(utilisateur)) {
            ArrayList<Livre> livresEmpruntesUtilisateur = empruntsUtilisateur.get(utilisateur);
            livresEmpruntesUtilisateur.remove(livre);
            empruntsUtilisateur.put(utilisateur, livresEmpruntesUtilisateur);
        }
    }
    // Méthode pour ajouter un nouvel utilisateur
    public void ajouterUtilisateur() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Veuillez saisir les informations de l'utilisateur :");
        System.out.print("Nom : ");
        String nom = scanner.nextLine();       
        System.out.println("Quel est le statut de l'utilisateur(utilisateur ou bibliothecaire)"); 
        String status = scanner.nextLine();  
        
        System.out.print("Numéro d'identification : ");
        int numeroIdentification = scanner.nextInt();
        scanner.nextLine(); // Pour consommer le retour à la ligne après nextInt()
        
        Utilisateur utilisateur = new Utilisateur(nom, numeroIdentification,status);
        utilisateurs.add(utilisateur);
        scanner.close();
    }

    // Méthode pour supprimer un utilisateur
    public void supprimerUtilisateur() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entrez le numéro d'identification de l'utilisateur à supprimer : ");
        int numeroIdentification = scanner.nextInt();
        
        Utilisateur utilisateurASupprimer = null;
        for (Utilisateur utilisateur : utilisateurs) {
            if (utilisateur.getNumeroIdentification() == numeroIdentification) {
                utilisateurASupprimer = utilisateur;
                break;
            }
        }
        
        if (utilisateurASupprimer != null) {
            utilisateurs.remove(utilisateurASupprimer);
            System.out.println("L'utilisateur a été supprimé avec succès.");
        } else {
            System.out.println("Utilisateur non trouvé.");
        }
        scanner.close();
    }
        
    public void afficherStatistiquesBibliothèque() {
        System.out.println("---*Statistiques de la bibliothèque*----- :");
        System.out.println("**Nombre total de listeLivres : " + listeLivres.size());
        System.out.println("**Nombre de listeLivres empruntés : " + empruntsUtilisateur.size());
    }
    
}
