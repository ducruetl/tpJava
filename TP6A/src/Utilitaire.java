import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.Integer.MAX_VALUE;

public class Utilitaire {

    public static int indContinent(ArrayList<String> vCont, String cont) {
        // { vCont trié } =>
        // { résultat = * -1 si cont est déjà dans vCont
        // * indice où il faudrait insérer cont dans VCont
        // pour conserver le tri de ce vecteur, sinon }

        if (vCont.isEmpty()) {

            return 0;

        } else if (cont.compareTo(vCont.get(vCont.size() - 1)) >= 1) {

            return vCont.size();

        } else {

            int m;
            int inf = 0;
            int sup = vCont.size() - 1;

            while (inf < sup) {

                m = (inf + sup) / 2;
                if (cont.compareTo(vCont.get(m)) > 0) {

                    inf = m + 1;

                } else {

                    sup = m;

                }

            }

            if (vCont.get(sup).compareTo(cont) == 0) {

                return -1;

            } else {

                return sup;

            }

        }


    }

    public static boolean existString(ArrayList<String> vString, String uneString) {
        // { vString trié } =>
        // { résultat = vrai si uneString appartient à vString }

        if (vString.isEmpty()) {

            return false;

        } else if (uneString.compareTo(vString.get(vString.size() - 1)) > 0) {

            return false;

        } else {

            int m;
            int inf = 0;
            int sup = vString.size() - 1;

            while (inf < sup) {

                m = (inf + sup) / 2;
                if (uneString.compareTo(vString.get(m)) > 0) {

                    inf = m + 1;

                } else {

                    sup = m;

                }

            }

            return uneString.equals(vString.get(sup));

        }

    }

    public static String saisieCont(ArrayList<String> vCont) {
        // { vCont trié, non vide } =>
        // { résultat = valeur d'un élément de vCont saisie par l'utilisateur }
        // LA SAISIE DOIT ÊTRE CONTRÔLÉE
        Scanner lecteur = new Scanner(System.in);
        String cont;

        do {

            System.out.print("Entrez un continent : ");
            cont = lecteur.nextLine();

            if (!existString(vCont, cont)) {

                System.out.println("Entrée invalide, réessayez...");

            }
        } while (!existString(vCont, cont));

        return cont;

    }

    public static ArrayList<Pays> paysDeCont(ArrayList<Pays> vPays, String cont) {
        // { cont est le continent d'au moins un pays de vPays } =>
        // { résultat = vecteur contenant les pays de vPays
        // dont le continent est cont }
        ArrayList<Pays> result = new ArrayList<>();

        for (int i = 0; i < vPays.size(); i++) {

            if (vPays.get(i).getContinent().equals(cont)) {

                result.add(vPays.get(i));

            }

        }

        return result;

    }

    public static int rechPaysT(ArrayList<Pays> vPays, String nomP) {
        // { vPays trié sur le nom } =>
        // { résultat = indice dans vPays du pays de nom nomP s'il existe,
        // vPays.size() si pas de pays de nom nomP dans vPays }
        int i = 0;
        while (i < vPays.size() && !nomP.equals(vPays.get(i).getNom())) {

            i++;

        }

        return i;

    }

    public static void paysMoinsPeuples(ArrayList<Pays> vMonde) {
        // { vMonde non vide } =>
        // { les caractéristiques du ou des pays le(s) moins peuplé(s)
        // dans vMonde ont été affichées }
        int min = vMonde.get(0).getPopulation();

        System.out.println("------------------------------------------");
        System.out.println("Pays avec le moins d'habitants : ");
        System.out.println("------------------------------------------");

        for (int i = 1; i < vMonde.size(); i++) {

            if (vMonde.get(i).getPopulation() < min) {

                min = vMonde.get(i).getPopulation();

            }

        }

        for (int i = 0; i < vMonde.size(); i++) {

            if (vMonde.get(i).getPopulation() == min) {

                System.out.println(vMonde.get(i));

            }

        }

    }

    public static void contExtremes(ArrayList<Pays> vMonde, ArrayList<String> vCont) {
        // { vMonde non vide } =>
        // { * Affichage du nom et du nombre de pays du (ou des) continent(s)
        // comptant le plus de pays
        // * Affichage du nom et du nombre de pays du (ou des) continent(s)
        // comptant le moins de pays }
        int min = MAX_VALUE;
        int max = 0;
        for (int i = 0; i < vCont.size(); i++) {

            if (paysDeCont(vMonde, vCont.get(i)).size() < min) {

                min = paysDeCont(vMonde, vCont.get(i)).size();

            }

            if (paysDeCont(vMonde, vCont.get(i)).size() > max) {

                max = paysDeCont(vMonde, vCont.get(i)).size();

            }

        }

        System.out.println("------------------------------------------");
        System.out.println("Continents avec le moins de pays : ");
        System.out.println("------------------------------------------");

        for (int i = 0; i < vCont.size(); i++) {

            if (paysDeCont(vMonde, vCont.get(i)).size() == min) {

                System.out.println(vCont.get(i) + ", " + paysDeCont(vMonde, vCont.get(i)).size());

            }

        }

        System.out.println("------------------------------------------");
        System.out.println("Continents avec le plus de pays : ");
        System.out.println("------------------------------------------");

        for (int i = 0; i < vCont.size(); i++) {

            if (paysDeCont(vMonde, vCont.get(i)).size() == max) {

                System.out.println(vCont.get(i) + ", " + paysDeCont(vMonde, vCont.get(i)).size());

            }

        }

    }

}
