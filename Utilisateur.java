
import java.util.ArrayList;
public class Utilisateur {
    String nom;
    int numeroIdentification;
    ArrayList<Livre> livresEmpruntes;
    boolean cotisationAJour=false;
    boolean Status;



    public Utilisateur(String nom, int numeroIdentification){
        this.nom=nom;
        this.numeroIdentification=numeroIdentification;
        this.livresEmpruntes = new ArrayList<>();
    }
    public boolean getCotisationAJour() {
        return cotisationAJour;
    }
    public boolean EstDisponible(){
        return Status;
    }

    public void emprunterLivre(Livre livre) {
        if (cotisationAJour) {
            if (Status) {
                System.out.println("Le livre :"+livre.getTitre() +"est disponible, Vous pouvez faire l'emprunt");
                livresEmpruntes.add(livre);
                System.out.println("Le livre \"" + livre.getTitre() + "\" a été emprunté par"+ nom);
            }else{
                System.out.println("Le livre :"+livre.getTitre() +"n'est pas disponible");
            }
           
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
