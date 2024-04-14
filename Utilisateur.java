
import java.util.ArrayList;
public class Utilisateur {
    String nom;
    int numeroIdentification;
    ArrayList<Livre> livresEmpruntes;
    boolean cotisationAJour=false;
    String status = null;

    public Utilisateur(String nom, int numeroIdentification,String status){
        this.nom=nom;
        this.numeroIdentification=numeroIdentification;
        this.status = status;
        this.livresEmpruntes = new ArrayList<>();
    }
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
    public boolean estAJour(){
        this.cotisationAJour = true;
        return this.cotisationAJour;
    }

    public void emprunterLivre(Livre livre) {
        if (cotisationAJour) {
            livresEmpruntes.add(livre);
            System.out.println("Le livre \"" + livre.getTitre() + "\" a été emprunté par"+ nom);
        } else {
            System.out.println("Votre cotisation doit être à jour pour emprunter un livre.");
        }
    }
    public void retournerLivre(Livre livre) {
            livresEmpruntes.contains(livre);
            livresEmpruntes.remove(livre);
            System.out.println("Le livre \"" + livre.getTitre() + "\" a été retourné par"+ nom);
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
    

    
}
