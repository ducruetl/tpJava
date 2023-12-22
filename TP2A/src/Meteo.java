import java.util.Scanner;

public class Meteo {
    public static void main(String[] args){

        boolean pluie, parapluie, tongs, chapeau, bonEquipement;
        Scanner lecteur = new Scanner(System.in);

        System.out.print("Est-ce qu'il pleut ? ( true or false ) : ");
        pluie = lecteur.nextBoolean();
        lecteur.nextLine();
        System.out.print("Avez-vous un parapluie ? ( true or false ) : ");
        parapluie = lecteur.nextBoolean();
        lecteur.nextLine();
        System.out.print("Avez-vous un chapeau ? ( true or false ) : ");
        chapeau = lecteur.nextBoolean();
        lecteur.nextLine();
        System.out.print("Avez-vous des tongs ? ( true or false ) : ");
        tongs = lecteur.nextBoolean();
        lecteur.nextLine();

        if (pluie){

            bonEquipement = (parapluie | chapeau) & !tongs;

        } else {

            bonEquipement = true;

        }

        if (bonEquipement){

            System.out.println("Vous êtes bien équipé !");

        } else {

            System.out.println("Vous êtes mal équipé.");

        }
    }
}
