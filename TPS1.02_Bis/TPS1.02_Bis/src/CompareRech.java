import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CompareRech {

    public static void main(String[] args) {

        ArrayList<Integer> vInt = new ArrayList<>(Arrays.asList(-45, -45, -10, 9, 10, 20, 30, 75, 90));
        Scanner lecteur = new Scanner(System.in);
        ArrayList<Integer> v160 = Utilitaire.genVectSansDoublons(160);
        int unEnt;


        System.out.println("vInt : " + vInt);
        System.out.println("Nombre d'éléments : " + vInt.size());
        System.out.println();

        System.out.print("Entrez un nombre à rechercher dans le vecteur : ");
        unEnt = lecteur.nextInt();
        lecteur.nextLine();

        System.out.println();

        System.out.println("RECHERCHE SEQUENTIELLE ITERATIVE : ");
        System.out.println();
        PaireResCompteur<Integer> paire = Utilitaire.rechSeqIt_O(vInt, unEnt);

        if (paire.getRes() != -1) {

            System.out.println("Indice : " + paire.getRes());

        } else {

            System.out.println("Nombre non présent dans le vecteur !");

        }

        System.out.println("Nombre de comparaisons : " + paire.getCompteur());

        System.out.println();

        System.out.println("RECHERCHE DICHOTOMIQUE ITERATIVE : ");
        System.out.println();
        paire = Utilitaire.rechDichoIt_O(vInt, unEnt);

        if (paire.getRes() != -1) {

            System.out.println("Indice : " + paire.getRes());

        } else {

            System.out.println("Nombre non présent dans le vecteur !");

        }

        System.out.println("Nombre de comparaisons : " + paire.getCompteur());

        System.out.println();

        Utilitaire.triBulle_O(v160);



    }

}
