import java.util.Scanner;
public class Main {
    public static void main(String[] args){
        Bibliotheque bibliotheque = new Bibliotheque();
        bibliotheque.initialiserUtilisateur("Aziz", 2000);
        bibliotheque.initialiserBibliothecaire("Biblio", 1000);

        Interfaces IT = new Interfaces(bibliotheque);

        Scanner scanner = new Scanner(System.in);
        Utilisateur utilisateurConnecte = null;

        while (true) {
            do {
                System.out.println("Veuillez vous identifier (entrez votre numéro d'identification) :");
                int numeroIdentification = scanner.nextInt();
                utilisateurConnecte = bibliotheque.trouverUtilisateurParIdentifiant(numeroIdentification);

                if (utilisateurConnecte != null) {
                    IT.demarrer(utilisateurConnecte, bibliotheque);
                } else {
                    System.out.println("Utilisateur non trouvé.");
                }
            } while (utilisateurConnecte == null);
        }
    }
}