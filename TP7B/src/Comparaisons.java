import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Scanner;

public class Comparaisons {

    public static void main(String[] args) {

        Scanner lecteur = new Scanner(System.in);
        ArrayList<Polar> mesPolars = CreationBib.lesPolars();

        System.out.println("Tri par selection - Nombre de comparaisons : " + Utilitaire.triSelectNbComp(mesPolars));
        System.out.println();

        mesPolars = CreationBib.lesPolars();

        System.out.println("Tri par insertion - Nombre de comparaisons : " + Utilitaire.triInsertionNbComp(mesPolars));

        for (int i = 0; i < mesPolars.size(); i++) {

            System.out.println(mesPolars.get(i));

        }

        System.out.print("Entrez un nom d'auteur : ");
        String auteurTest = lecteur.nextLine();

        System.out.println();
        System.out.print("Entrez une année : ");
        int anneeTest = lecteur.nextInt();
        lecteur.nextLine();

        System.out.println("Recherche sequentielle : ");

        int result = Utilitaire.rechSeqT_O(mesPolars, auteurTest, anneeTest).getRes();

        if (result == -1) {

            System.out.println("Aucun résultat.");
            System.out.println("Nombre de comparaisons : " + Utilitaire.rechSeqT_O(mesPolars, auteurTest, anneeTest).getCompteur());

        } else {

            System.out.println(result + ", " + mesPolars.get(result).getTitre());
            System.out.println("Nombre de comparaisons : " + Utilitaire.rechSeqT_O(mesPolars, auteurTest, anneeTest).getCompteur());

        }

        System.out.println();

        System.out.println("Recherche dichotomique : ");

        result = Utilitaire.rechDicho_O(mesPolars, auteurTest, anneeTest).getRes();

        if (result == -1) {

            System.out.println("Aucun résultat.");
            System.out.println("Nombre de comparaisons : " + Utilitaire.rechDicho_O(mesPolars, auteurTest, anneeTest).getCompteur());

        } else {

            System.out.println(result + ", " + mesPolars.get(result).getTitre());
            System.out.println("Nombre de comparaisons : " + Utilitaire.rechDicho_O(mesPolars, auteurTest, anneeTest).getCompteur());

        }

    }

}
