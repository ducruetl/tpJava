import java.util.Scanner;

public class ConversionsBis {

    public static void main(String[] args) {

        Scanner lecteur = new Scanner(System.in);
        final float euroToUsd = 1.07f;
        final float euroToChf = 0.96f;
        final float euroToGbp = 0.86f;

        System.out.print("Entrez une valeur en euro : ");
        float euro = lecteur.nextFloat();
        lecteur.nextLine();

        System.out.println("Choisissez une devise : USD (dollar américain), CHF (franc suisse) ou GBP (livre sterling)");
        String devise = lecteur.nextLine();

        if(devise.equalsIgnoreCase("USD")){

            System.out.println(euro + " euros = " + euro * euroToUsd + " dollars.");

        }

        else if(devise.equalsIgnoreCase("CHF")){

            System.out.println(euro + " euros = " + euro * euroToChf + " francs suisses.");

        }

        else if(devise.equalsIgnoreCase("GBP")){

            System.out.println(euro + " euros = " + euro * euroToGbp + " livres sterling.");

        }

        else{

            System.out.println("Devise invalide");

        }

    }

}
