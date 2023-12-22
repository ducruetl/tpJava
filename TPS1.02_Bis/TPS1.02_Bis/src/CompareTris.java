import java.util.ArrayList;

public class CompareTris {

    public static void main(String[] args) {

        ArrayList<Integer> vInt = Utilitaire.genVectSansDoublons(10);
        System.out.println("Vecteur de base (10) : " + vInt);
        int count = Utilitaire.triSelect_O(vInt);
        System.out.println("Vecteur trié (tri par selection) : " + vInt);
        System.out.println("Nombre de comparaisons : " + count);

        System.out.println();

        vInt = Utilitaire.genVectSansDoublons(40);
        System.out.println("Vecteur de base (40) : " + vInt);
        count = Utilitaire.triSelect_O(vInt);
        System.out.println("Vecteur trié (tri par selection) : " + vInt);
        System.out.println("Nombre de comparaisons : " + count);

        System.out.println();

        vInt = Utilitaire.genVectSansDoublons(160);
        System.out.println("Vecteur de base (160) : " + vInt);
        count = Utilitaire.triSelect_O(vInt);
        System.out.println("Vecteur trié (tri par selection) : " + vInt);
        System.out.println("Nombre de comparaisons : " + count);
    }

}
