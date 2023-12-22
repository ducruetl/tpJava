import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class VecteursDeInteger {

    public static int saisieEntPos(){
        // { } => { résultat = un entier > 0, saisi par l'utilisateur }
        Scanner lecteur = new Scanner(System.in);
        int result;
        do {

            System.out.print("Entrez un entier positif non nul : ");
            result = lecteur.nextInt();
            lecteur.nextLine();
            if (result <= 0) {

                System.out.println("Valeur invalide, réessayez");

            }
        } while (result <= 0);

        return result;

    }

    public static ArrayList<Integer> lesDiviseurs(int unEnt) {
        // { unEnt > 0 } => {résultat = vecteur contenant les diviseurs de unEnt
        // y compris 1 et unEnt }
        ArrayList<Integer> listeDiviseur = new ArrayList<>();
        for (int i = 1; i <= unEnt; i++) {

            if (unEnt % i == 0) {

                listeDiviseur.add(i);

            }

        }

        return listeDiviseur;

    }

    public static int sommeDe(ArrayList<Integer> unVectEntPos) {
        // { unVectEntPos non vide, tous ses éléments sont > 0 } =>
        // { résultat = somme des éléments de unVectEntPos }
        int somme = 0;
        for (int i = 0; i < unVectEntPos.size(); i++) {

            somme += unVectEntPos.get(i);

        }

        return somme;

    }

    private static boolean estPremier(int unEnt) {
        // { unEnt > 0 } => { résultat = vrai si unEnt est PREMIER }
        return sommeDe(lesDiviseurs(unEnt)) == 1 + unEnt;

    }

    private static boolean estParfait(int unEnt) {
        // {unEnt > 0 } => { résultat = vrai si unEnt est PARFAIT }
        return sommeDe(lesDiviseurs(unEnt)) / 2 == unEnt;

    }

    private static boolean estSublime(int unEnt) {
        // {unEnt > 0 } => { résultat = vrai si unEnt est SUBLIME }
        return estParfait(lesDiviseurs(unEnt).size()) & estParfait(sommeDe(lesDiviseurs(unEnt)));

    }

    private static String qualiteDe(int unEnt) {
        // { unEnt > 0 } =>
        // { résultat = "PREMIER", "PARFAIT", "SUBLIME" ou "QUELCONQUE"
        // selon les propriétés de unEnt }
        if (estPremier(unEnt)) {

            return "PREMIER";

        } else if (estParfait(unEnt)) {

            return "PARFAIT";

        } else if (estSublime(unEnt)) {

            return "SUBLIME";

        } else {

            return "QUELCONQUE";

        }

    }

    public static void main(String[] args) {

        int unEnt = saisieEntPos();
        ArrayList<Integer> lesDiv = lesDiviseurs(unEnt);
        System.out.println("* Diviseurs de " + unEnt + " : " + lesDiv);
        System.out.println("* Nombre de diviseurs : " + lesDiv.size());
        System.out.println("* Somme des diviseurs : " + sommeDe(lesDiv));
        System.out.println("* Qualité : " + qualiteDe(unEnt));
        if (!qualiteDe(unEnt).equalsIgnoreCase("PREMIER")) {
            System.out.println("* Divisieurs de " + unEnt + ", autres que 1 et " + unEnt);
            for (int i = 1; i < lesDiv.size() - 1; i++) {

                System.out.println(" - " + lesDiv.get(i) + " est " + qualiteDe(lesDiv.get(i)));

            }

        }

    }

}
