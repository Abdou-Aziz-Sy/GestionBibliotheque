
import java.util.ArrayList;
public class Utilisateur {
    String nom;
    int numeroIdentification;
    ArrayList<Livre> livresEmpruntes;
    boolean cotisationAJour=false;//suppose que cotisationAJour indique si l'utilisateur est éligible à emprunter des livres  ou non 
    boolean Status =false; // suppose que status indique si le livre est disponible ou non


    public Utilisateur(String nom, int numeroIdentification){
        this.nom=nom;
        this.numeroIdentification=numeroIdentification;
        this.livresEmpruntes = new ArrayList<>();
    }
    //fonction 'getCotisationAJour' pour permettre aux autres classes de récupérer cet état
    public boolean getCotisationAJour() {
        return cotisationAJour;
    }
    public boolean EstDisponible(){
        return Status;
    }
//pour permettre à l'utilisateur d'emprunter un livre 
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
    //pour permettre à l'utilisateur de retourner le livre emprunté 
    public void retournerLivre(Livre livre) {
            livresEmpruntes.contains(livre);
            livresEmpruntes.remove(livre);
            System.out.println("Le livre \"" + livre.getTitre() + "\" a été retourné par"+ nom);
       }
       //pour permettre à l'utilisateur d'afficher les livres empruntés
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
