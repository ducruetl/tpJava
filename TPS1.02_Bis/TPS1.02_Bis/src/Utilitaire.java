import java.util.ArrayList;

public class Utilitaire {

    public static int triBulle_O (ArrayList<Integer> vInt) {

        int j;
        int i = 0;
        int temp;
        boolean permute = true;
        int count = 0;

        while(permute) {

            permute = false;
            j = vInt.size() - 1;

            while (j > i) {

                if (vInt.get(j) < vInt.get(j - 1) ) {

                    permute = true;
                    temp = vInt.get(j - 1);
                    vInt.set(j - 1, vInt.get(j));
                    vInt.set(j, temp);

                }

                count++;

                j--;

            }

            i ++;

        }

        return count;

    }

    public static int triInsert_O (ArrayList<Integer> vInt) {

        int i = 1;
        int j;
        int aPlacer;
        int count = 0;

        while (i < vInt.size()) {

            j = i;
            aPlacer = vInt.get(i);

            while (j > 0 && vInt.get(j - 1) > aPlacer) {

                vInt.set(j, vInt.get(j - 1));
                count++;
                j--;
            }

            if (j > 0) {

                count++;

            }

            vInt.set(j, aPlacer);

            i++;

        }

        return count;

    }

    public static int triSelect_O (ArrayList<Integer> vInt) {

        int i = 0;
        int indMin;
        int j;
        int temp;
        int count = 0;
        while (i < vInt.size() - 1) {

            indMin = i;
            j = i + 1;

            while (j < vInt.size()) {

                if (vInt.get(j) < vInt.get(indMin)) {

                    indMin = j;

                }

                count++;
                j ++;

            }

            if (indMin != i) {

                temp = vInt.get(indMin);
                vInt.set(indMin, vInt.get(i));
                vInt.set(i, temp);

            }

            i++;

        }

        return count;

    }

    public static ArrayList<Integer> genVectSansDoublons(int n) {
        // { } =>
        // { résultat = vecteur de n entiers, sans doublons, dont les valeurs
        // sont choisies aléatoirement dans [0..2*n] }
        ArrayList<Integer> array = new ArrayList<>();
        int m;
        for (int i = 0; i < n; i++) {

            do {

                m = (int)(Math.random()*((2 * n) + 1));

            } while(array.contains(m));

            array.add(m);

        }

        return array;

    }

    public static PaireResCompteur<Integer> rechSeqIt_O(ArrayList<Integer> vInt, int unInt) {
        // { vInt non vide, trié } =>
        // { résultat = variable de type PaireResCompteur avec :
        // res = * indice de la 1ère occurrence de unInt dans vInt
        // * -1 si non trouvé
        // compteur = nombre de comparaisons entre unInt
        // et un élément de vInt }
        int compteur = 0, i = 0;
        while(i < vInt.size() && vInt.get(i) < unInt) {

            compteur++;
            i++;

        }

        if (i == vInt.size()) {

            return new PaireResCompteur<>(-1, compteur);

        } else if (vInt.get(i) > unInt) {

            compteur++;
            return new PaireResCompteur<>(-1, compteur);

        } else {

            compteur++;
            return new PaireResCompteur<>(i, compteur);

        }

    }

    public static PaireResCompteur<Integer> rechDichoIt_O(ArrayList<Integer> vInt, int unEnt) {
        // { vInt non vide, trié } =>
        // { résultat = variable de type PaireResCompteur avec :
        // res = * indice de la 1ère occurrence de unInt dans vInt
        // * -1 si non trouvé
        // compteur = nombre de comparaisons effectuées entre unInt
        // et un élément de vInt }
        int compteur = 0, min = 0, max = vInt.size() - 1, mid;

        if (unEnt > vInt.get(max)) {

            compteur++;
            return new PaireResCompteur<>(-1, compteur);

        }

        while (min < max) {

            mid = (min + max) / 2;

            if (vInt.get(mid) >= unEnt) {

                max = mid;

            } else {

                min = mid + 1;

            }

            compteur++;

        }

        compteur++;

        if (vInt.get(max) != unEnt) {

            return new PaireResCompteur<>(-1, compteur + 1);

        } else {

            return new PaireResCompteur<>(max, compteur + 1);

        }

    }

}
