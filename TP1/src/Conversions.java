import java.util.Scanner;

public class Conversions {

    public static void main(String[] args) {

        float dollars, euro;
        final float taux = 0.89f;
        Scanner lecteur = new Scanner(System.in);

        System.out.print("Entrez un prix en dollars : ");
        dollars = lecteur.nextFloat();
        lecteur.nextLine();
        euro = dollars * taux;

        System.out.println(dollars + " dollars vaut " + euro + " euros.");

    }
}
