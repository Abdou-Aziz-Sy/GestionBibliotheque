
    public class Bibliothecaire extends Utilisateur {
        public Bibliothecaire(String nom, int numeroIdentification) {
            super(nom, numeroIdentification);
        }

        // Méthode pour ajouter un livre à la bibliothèque
        public void ajouterLivre(Bibliotheque bibliotheque, Livre livre) {
            bibliotheque.ajouterLivre(livre);
            System.out.println("Le livre \"" + livre.getTitre() + "\" a été ajouté à la bibliothèque par " + nom);
        }

        // Méthode pour supprimer un livre de la bibliothèque
        public void supprimerLivre(Bibliotheque bibliotheque, String isbn) {
            if (bibliotheque.supprimerLivre(isbn)) {
                System.out.println("Le livre avec l'ISBN \"" + isbn + "\" a été supprimé de la bibliothèque par " + nom);
            } else {
                System.out.println("Le livre avec l'ISBN \"" + isbn + "\" n'a pas été trouvé dans la bibliothèque.");
            }
        }

        // Autres méthodes spécifiques au bibliothécaire, par exemple pour la gestion des utilisateurs, les statistiques, etc.
    }


