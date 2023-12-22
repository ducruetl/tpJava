import java.util.Scanner;

public class Calendrier {

    public static void main(String[] args){

        int uneAnnee, nbJours;
        Scanner lecteur = new Scanner(System.in);

        System.out.print("Entrez une année : ");
        uneAnnee = lecteur.nextInt();
        lecteur.nextLine();

        if (uneAnnee % 100 == 0){

            System.out.println("* Cette année termine un siècle !");
            if ((uneAnnee / 100) % 4 == 0){

                nbJours = 366;
                System.out.println("* Elle est bissextile et contient " + nbJours + " jours.");

            } else {

                nbJours = 365;
                System.out.println("* Elle n'est pas bissextile et contient " + nbJours + " jours.");

            }

        } else {

            System.out.println("* Cette année ne termine pas un siècle.");
            if (uneAnnee % 4 == 0){

                nbJours = 366;
                System.out.println("* Elle est bissextile et contient " + nbJours + " jours.");

            } else {

                nbJours = 365;
                System.out.println("* Elle n'est pas bissextile et contient " + nbJours + " jours.");

            }

        }

    }

}
