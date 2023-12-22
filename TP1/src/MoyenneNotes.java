import java.util.Scanner;

public class MoyenneNotes {

    public static void main(String[] args){

        float moyenne = 0.0f;
        float nbNotes;
        Scanner lecteur = new Scanner(System.in);

        System.out.print("Nombre de notes : ");
        nbNotes = lecteur.nextFloat();
        lecteur.nextLine();

        for (int i = 0; i < nbNotes; i++) {
            System.out.print("Saisissez une note : ");
            moyenne = moyenne + lecteur.nextFloat();
            lecteur.nextLine();
        }

        moyenne = moyenne / nbNotes;
        System.out.println("Votre moyenne est de : " + moyenne);

    }
}
