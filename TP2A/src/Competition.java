import java.util.Scanner;

public class Competition {

    public static void main(String[] args) {

        final float tempsMax = 20.0f;
        float temps = 0.0f;
        float estimation, min = 20.0f, max = 0.0f;
        int nbJuges;
        Scanner lecteur = new Scanner(System.in);

        System.out.print("Nombre de juges : ");
        nbJuges = lecteur.nextInt();
        lecteur.nextLine();

        for (int i = 1; i <= nbJuges; i++){

            System.out.print("* Temps estimé par le juge n°" + i + " ? : ");
            estimation = lecteur.nextFloat();
            lecteur.nextLine();
            if ((estimation > tempsMax) | (estimation < 0.0f)){

                do{
                    System.out.println(">>> Saisie invalide, valeur comprise entre 0 et 20.");
                    System.out.print("* Temps estimé par le juge n°" + i + " ? : ");
                    estimation = lecteur.nextFloat();
                    lecteur.nextLine();
                } while((estimation > tempsMax) | (estimation < 0.0f));

            }

            if (estimation < min) min = estimation;
            if (estimation > max) max = estimation;
            temps = temps + estimation;

        }

        temps = temps / nbJuges;

        System.out.println("Temps minimum : " + min);
        System.out.println("Temps maximum : " + max);
        System.out.println("Moyenne des temps : " + temps);

    }

}
