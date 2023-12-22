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

    public static void triSelect(ArrayList<Polar> vPolar) {
        // { } => { vPolar a été trié selon l'ORDRE(auteur, annee)
        // en utilisant la méthode DU TRI PAR SÉLECTION }
        int i = 0;
        int indMin;
        int j;
        Polar temp;
        while (i < vPolar.size() - 1) {

            indMin = i;
            j = i + 1;

            while (j < vPolar.size()) {

                if (vPolar.get(j).compareTo(vPolar.get(indMin)) < 0 ) {

                    indMin = j;

                }

                j ++;

            }

            if (indMin != i) {

                temp = vPolar.get(indMin);
                vPolar.set(indMin, vPolar.get(i));
                vPolar.set(i, temp);

            }

            i++;

        }

    }

    public static void triBulle(ArrayList<Polar> vPolar) {
        // { } => { vPolar est trié selon l'ORDRE(auteur, annee)
        // en utilisant la méthode DU TRI À BULLES AMÉLIORÉ }
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

    public static void triInsertion(ArrayList<Polar> vPolar) {
        // { } => { vPolar est trié selon l'ORDRE(auteur, annee)
        // en utilisant la méthode DU TRI PAR INSERTION }
        int i = 1;
        int j;
        Polar aPlacer;

        while (i < vPolar.size()) {

            j = i;
            aPlacer = vPolar.get(i);

            while (j > 0 && vPolar.get(j - 1).compareTo(aPlacer) > 0) {

                vPolar.set(j, vPolar.get(j - 1));

                j--;
            }

            vPolar.set(j, aPlacer);

            i++;

        }
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

}
