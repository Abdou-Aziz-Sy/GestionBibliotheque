public class Main {
    public static void main(String[] args) {
        Bibliotheque bibliotheque = new Bibliotheque();

        // Ajout de livres à la bibliothèque
        bibliotheque.ajouterLivre(new Livre("Titre 1", "Auteur 1", 2000, "ISBN1"));
        bibliotheque.ajouterLivre(new Livre("Titre 2", "Auteur 2", 2005, "ISBN2"));
        // Ajout d'autres livres...

        // Création d'un bibliothécaire
        Utilisateur bibliothecaire = new Utilisateur("Bibliothecaire", 123456);
        bibliothecaire.setBibliothecaire(true);

        // Création d'autres utilisateurs
        Utilisateur utilisateur1 = new Utilisateur("Utilisateur 1", 987654);
        Utilisateur utilisateur2 = new Utilisateur("Utilisateur 2", 654321);
        // Création d'autres utilisateurs...

        // Ajout des utilisateurs à la liste des utilisateurs de la bibliothèque
        bibliotheque.ajouterUtilisateur(bibliothecaire);
        bibliotheque.ajouterUtilisateur(utilisateur1);
        bibliotheque.ajouterUtilisateur(utilisateur2);
        // Ajout d'autres utilisateurs...

        // Simulation de la connexion de l'utilisateur
        int numeroIdentificationConnecte = 987654; // Numéro d'identification de l'utilisateur connecté
        Utilisateur utilisateurConnecte = bibliotheque.trouverUtilisateurParNumero(numeroIdentificationConnecte);

        // Vérification si l'utilisateur connecté est un bibliothécaire ou un utilisateur normal
        if (utilisateurConnecte != null) {
            if (utilisateurConnecte.estBibliothecaire()) {
                // Redirection vers l'interface du bibliothécaire
                Interfaces interfaceBibliothecaire = new Interfaces(bibliotheque,utilisateurConnecte, true);
                interfaceBibliothecaire.demarrer(utilisateurConnecte);
            } else {
                // Redirection vers l'interface de l'utilisateur normal
                Interfaces interfaceUtilisateur = new Interfaces(bibliotheque,utilisateurConnecte, false);
                interfaceUtilisateur.demarrer(utilisateurConnecte);
            }
        } else {
            System.out.println("Utilisateur non trouvé.");
        }
    }
}
