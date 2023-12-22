import java.util.Scanner;

public class Moi {

    public static void main(String[] args) {

        Scanner lecteur = new Scanner(System.in);
        String nom, prenom, groupe, sousGroupe;
        int age;
        System.out.print("Nom : ");
        nom = lecteur.nextLine();
        System.out.print("Prénom : ");
        prenom = lecteur.nextLine();
        System.out.print("Age : ");
        age = lecteur.nextInt();
        lecteur.nextLine();
        System.out.print("Groupe : ");
        groupe = lecteur.nextLine();
        System.out.print("Sous-groupe : ");
        sousGroupe = lecteur.nextLine();

        System.out.println("-----------------------------------------------------------------");
        System.out.println("RENSEIGNEMENTS VOUS CONCERNANT");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Identité : " + prenom + " " + nom);
        System.out.println("Age : " + age + " ans");
        System.out.println("Groupe : " + groupe);
        System.out.println("Sous-groupe : " + sousGroupe);
    }
}
