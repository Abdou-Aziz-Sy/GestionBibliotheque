import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Bibliotheque bibliotheque = new Bibliotheque();    // Création de la bibliothèque
        bibliotheque.initialiserUtilisateur("Aziz", 2000);   // Initialisation d'un utilisateur
        bibliotheque.initialiserBibliothecaire("Biblio", 1000);  // Initialisation d'un bibliothécaire

        Interfaces IT = new Interfaces(bibliotheque); // Création de l'interface

        Scanner scanner = new Scanner(System.in);
        Utilisateur utilisateurConnecte = null; // Utilisateur connecté

        while (true) {   // Boucle pour la connexion
            do {
                System.out.println("Veuillez vous identifier (entrez votre numéro d'identification) :");
                int numeroIdentification = scanner.nextInt();
                utilisateurConnecte = bibliotheque.trouverUtilisateurParIdentifiant(numeroIdentification);   // Recherche de l'utilisateur par son identifiant

                if (utilisateurConnecte != null) {
                    IT.demarrer(utilisateurConnecte, bibliotheque);  // Démarrage de l'interface   si l'utilisateur est trouvé
                } else {
                    System.out.println("Utilisateur non trouvé.");
                }
            } while (utilisateurConnecte == null);
        }
    }
}