import java.util.ArrayList;

public class Utilitaire {

    public static boolean verifTri(ArrayList<Polar> vPolar) {
        // { } =>
        // { résultat = vrai si vPolar est trié par titre strictement croissant }
        if (vPolar.size() < 2) {

            return true;

        } else {
            int j = vPolar.size() - 1;
            while (j > 0 && vPolar.get(j).getTitre().compareTo(vPolar.get(j - 1).getTitre()) > 0) {

                j--;

            }

            return j == 0;

        }
    }

    public static int triSelectNbComp(ArrayList<Polar> vPolar) {
        // { } => { * vPolar est trié selon l'ORDRE(auteur, annee)
        // en utilisant la méthode DU TRI PAR SÉLECTION
        // * résultat = nombre de comparaisons effectuées
        // entre deux éléments de vPolar }
        int i = 0;
        int indMin;
        int j;
        int nbComp = 0;
        Polar temp;
        while (i < vPolar.size() - 1) {

            indMin = i;
            j = i + 1;

            while (j < vPolar.size()) {

                if (vPolar.get(j).compareTo(vPolar.get(indMin)) < 0 ) {

                    indMin = j;

                }

                nbComp++;
                j ++;

            }

            if (indMin != i) {

                temp = vPolar.get(indMin);
                vPolar.set(indMin, vPolar.get(i));
                vPolar.set(i, temp);

            }

            i++;

        }

        return nbComp;

    }

    public static void triBulle(ArrayList<Polar> vPolar) {
        // { } => { * vPolar est trié selon l'ORDRE(auteur, annee)
        // en utilisant la méthode DU TRI A BULLES AMELIORE }
        int j;
        int i = 0;
        Polar temp;
        boolean permute = true;

        while(permute) {

            permute = false;
            j = vPolar.size() - 1;

            while (j > i) {

                if (vPolar.get(j).compareTo(vPolar.get(j - 1)) < 0) {

                    permute = true;
                    temp = vPolar.get(j - 1);
                    vPolar.set(j - 1, vPolar.get(j));
                    vPolar.set(j, temp);

                }

                j--;

            }

            i ++;

        }


    }

    public static int triInsertionNbComp(ArrayList<Polar> vPolar) {
        // { } => { * vPolar est trié selon l'ORDRE(auteur, annee)
        // en utilisant la méthode DU TRI PAR INSERTION
        // * résultat = nombre de comparaisons effectuées
        // entre deux éléments de vPolar }
        int i = 1;
        int j;
        Polar aPlacer;
        int nbComp = 0;

        while (i < vPolar.size()) {

            j = i;
            aPlacer = vPolar.get(i);

            while (j > 0 && vPolar.get(j - 1).compareTo(aPlacer) > 0) {

                vPolar.set(j, vPolar.get(j - 1));

                j--;
                nbComp++;

            }

            if (j > 0) {

                nbComp++;

            }

            vPolar.set(j, aPlacer);

            i++;

        }

        return nbComp;

    }

    public static void nbPolarAuteur(ArrayList<Polar> vPolar) {
        // { vPolar non vide, trié selon l'ORDRE(auteur, année) } =>
        // { le nombre de romans écrits par chaque auteur a été affiché
        // ligne à ligne, chaque ligne ayant la forme :
        // * Nombre de romans écrits par XXX : nbR
        // (nbR étant le nombre de romans de l'auteur de nom XXX} }
        int i = 0;
        int nbRomans;
        String nomAuteur;
        while (i < vPolar.size()){

            nomAuteur = vPolar.get(i).getAuteur();
            nbRomans = 0;
            while(i < vPolar.size() && vPolar.get(i).getAuteur().equals(nomAuteur)){

                nbRomans++;
                i++;

            }

            System.out.println("* Nombre de romans écrits par " + nomAuteur + " : " + nbRomans);

        }

    }

    public static ArrayList<String> auteursDeAn(ArrayList<Polar> vPolar, int an){
        // { vPolar non vide, trié selon l'ORDRE(auteur, annee) } =>
        // { résultat = vecteur contenant les noms des auteurs ayant écrit au
        // moins un roman l'année an }
        ArrayList<String> auteurAn = new ArrayList<>();
        int i = 0;
        String nomAuteur;
        int romansAn;

        while (i < vPolar.size()) {

            nomAuteur = vPolar.get(i).getAuteur();
            romansAn = 0;

            while (i < vPolar.size() && vPolar.get(i).getAuteur().equals(nomAuteur)) {

                if (vPolar.get(i).getAnnee() == an) {

                    romansAn++;

                }

                i++;

            }

            if (romansAn > 0) {

                auteurAn.add(nomAuteur);

            }
        }

        return auteurAn;

    }

    public static int rechSeqT(ArrayList<Polar> vPolar, String aut, int an){
        // { vPolar trié selon l'ORDRE(auteur, annee) }
        // => { * résultat = indice du premier élément de vPolar
        // écrit par aut, l'année an, si trouvé
        // * résultat = -1, si aucun roman écrit par aut, l'année an }
        // LA RECHERCHE EST SÉQUENTIELLE
        int i = 0;
        Polar compPolar = new Polar(an, aut, "");
        while (i < vPolar.size() && vPolar.get(i).compareTo(compPolar) != 0){

            i++;

        }

        if (i == vPolar.size()) {

            return -1;

        } else {

            return i;

        }

    }

    public static int rechDicho(ArrayList<Polar> vPolar, String aut, int an) {
        // { vPolar trié selon l'ORDRE(auteur, annee) }
        // => { * résultat = indice du premier élément de vPolar
        // écrit par aut, l'année an, si trouvé
        // * résultat = -1, si aucun roman écrit par aut, l'année an }
        // LA RECHERCHE EST DICHOTOMIQUE
        int min = 0;
        int max = vPolar.size() - 1;
        int val;
        Polar compPolar = new Polar(an, aut, "");

        if (vPolar.get(max).compareTo(compPolar) < 0) {

            return -1;

        }

        while (max > min) {

            val = (max + min)/2;
            if (vPolar.get(val).compareTo(compPolar) < 0){

                min = val + 1;

            } else {

                max = val;

            }

        }

        if (vPolar.get(max).compareTo(compPolar) == 0) {

            return max;

        } else {

            return -1;

        }

    }

    public static PaireResultatCompteur<Integer> rechSeqT_O(ArrayList<Polar> vPolar, String aut, int an) {
        // { vPolar trié selon l'ORDRE(auteur, annee) } =>
        // { * le premier élément de vPolar écrit par aut, l'année an a été cherché
        // à l'aide d'un algorithme de RECHERCHE SÉQUENTIELLE
        // * résultat = un objet de type PaireResCompteur où :
        // - l'attribut res est égal à l'indice dans vPolar du 1er élément d'auteur aut
        // et d'année an, si trouvé / -1 si pas trouvé
        // - l'attribut compteur est égal au nombre de comparaisons effectuées entre
        // un élément du vecteur et ce qui est cherché, pour produire res }
        int compteur = 0;
        int i = 0;
        Polar compPolar = new Polar(an, aut, "");
        while (i < vPolar.size() && vPolar.get(i).compareTo(compPolar) != 0){

            compteur++;
            i++;

        }

        if (i == vPolar.size()) {

            i = -1;

        }

        compteur++;

        return new PaireResultatCompteur<>(i, compteur);

    }

    public static PaireResultatCompteur<Integer> rechDicho_O(ArrayList<Polar> vPolar, String aut, int an) {
        // { vPolar trié selon l'ORDRE(auteur, annee) } =>
        // { * le premier élément de vPolar écrit par aut, l'année an a été cherché
        // à l'aide d'un algorithme de RECHERCHE DICHOTOMIQUE
        // * résultat = un objet de type PaireResCompteur dont :
        // - l'attribut res est égal à l'indice dans vPolar du 1er élément d'auteur aut
        // et d'année an, si trouvé / -1 si pas trouvé
        // - l'attribut compteur est égal au nombre de comparaisons effectuées entre
        // un élément du vecteur et ce qui est cherché, pour produire res }
        int min = 0;
        int max = vPolar.size() - 1;
        int val;
        int result;
        int compteur = 0;
        Polar compPolar = new Polar(an, aut, "");

        if (vPolar.get(max).compareTo(compPolar) < 0) {

            result = -1;

        } else {

            while (max > min) {

                val = (max + min) / 2;
                if (vPolar.get(val).compareTo(compPolar) < 0) {

                    min = val + 1;

                } else {

                    max = val;

                }

                compteur++;

            }

            if (vPolar.get(max).compareTo(compPolar) == 0) {

                result = max;

            } else {

                result = -1;

            }

            compteur++;



        }

        compteur++;

        return new PaireResultatCompteur<>(result, compteur);

    }

}
