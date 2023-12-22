import java.util.ArrayList;
import java.util.Scanner;

public class Polars_Main {

    public static void main(String[] args) {

        Scanner lecteur = new Scanner(System.in);
        ArrayList<Polar> lesPolars = InitBibPolars.lesPolars();
        int anMin = lesPolars.get(0).getAnnee();
        int anMax = lesPolars.get(lesPolars.size() - 1).getAnnee();
        String auteurTest;
        int anTest;

        // Affichage de tout les éléments de la liste lesPolars
        for (int i = 0; i < lesPolars.size(); i++) {

            System.out.println(lesPolars.get(i));

        }

        anTest = Polar.saisirIntMinMax(anMin, anMax);

        System.out.print("Entrez un nom d'auteur (EN MAJUSCULES) : ");
        auteurTest = lecteur.nextLine();

        if (Polar.rechPremIndSeq(lesPolars, anTest, auteurTest) != -1) {

            System.out.println(lesPolars.get(Polar.rechPremIndSeq(lesPolars, anTest, auteurTest)));

        } else {

            System.out.println("Aucune correspondance trouvée...");

        }



    }

}
