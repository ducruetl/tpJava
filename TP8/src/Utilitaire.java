import java.util.ArrayList;

public class Utilitaire {

    public static Pays plusGrandPaysIter(ArrayList<Pays> vPays) {
        // { vPays non vide } =>
        // { résultat = élément de vPays ayant la plus grande superficie }
        int i = 1;
        Pays paysMaxSuperficie = vPays.get(0);
        while (i < vPays.size()) {

            if (paysMaxSuperficie.getSuperficie() < vPays.get(i).getSuperficie()) {

                paysMaxSuperficie = vPays.get(i);

            }

            i++;

        }

        return paysMaxSuperficie;

    }

    public static Pays plusGrandPaysDPR(ArrayList<Pays> vPays) {
        // { vPays non vide } =>
        // { résultat = élément de vPays ayant la plus grande superficie }

        return maxPaysDPRWorker(vPays, 0, vPays.size() - 1);

    }

    public static Pays maxPaysDPRWorker(ArrayList<Pays> vPays, int inf, int sup) {
        // { vPays non vide, 0<=inf<=sup<vPays.size() } =>
        // { résultat = élément de plus grande superficie dans vPays[inf..sup] }
        int m = (inf + sup)/2;
        if (inf == sup) {

            return vPays.get(sup);

        } else {

            Pays vGauche = maxPaysDPRWorker(vPays, inf, m);
            Pays vDroite = maxPaysDPRWorker(vPays, m + 1, sup);

            if (vDroite.getSuperficie() < vGauche.getSuperficie()) {

                return vGauche;

            } else {

                return vDroite;

            }
        }


    }

    public static int indMinPopIter(ArrayList<Pays> vPays) {
        // { vPays non vide } =>
        // { résultat = indice dans vPays de l'élément de population la plus faible }
        int i = 1;
        int minPop = 0;

        while (i < vPays.size()) {

            if (vPays.get(i).getPopulation() < vPays.get(minPop).getPopulation()) {

                minPop = i;

            }

            i++;

        }

        return minPop;

    }

    public static int indMinPopDPR(ArrayList<Pays> vPays) {
        // { vPays non vide } =>
        // { résultat = indice dans vPays de l'élément de population la plus faible }

        return indMinPopDPRWorker(vPays, 0, vPays.size() - 1);

    }

    public static int indMinPopDPRWorker(ArrayList<Pays> vPays, int inf, int sup) {
        // { vPays non vide, 0<=inf<=sup<vPays.size() } =>
        // { résultat = indice dans vPay[inf..sup] de l'élément de population
        // la plus faible }
        int m = (inf + sup)/2;
        if (inf == sup) {

            return sup;

        } else {

            int vGauche = indMinPopDPRWorker(vPays, inf, m);
            int vDroite = indMinPopDPRWorker(vPays, m + 1, sup);

            if (vPays.get(vGauche).getPopulation() < vPays.get(vDroite).getPopulation()) {

                return vGauche;

            } else {

                return vDroite;

            }

        }

    }

    public static ArrayList<Pays> triBulleContNom(ArrayList<Pays> vPays) {
        // { } => { résultat = vecteur contenant les éléments de vPays,
        // triés selon l'ORDRE(continent, nom) }
        // ALGORITHME : tri à bulles amélioré
        boolean permute = true;
        int i = 0;
        int j;
        while(permute) {

            permute = false;
            j = vPays.size() - 1;


            while (j > i) {

                if (vPays.get(j).compareTo(vPays.get(j - 1)) < 0) {

                    Pays temp = vPays.get(j);
                    vPays.set(j, vPays.get(j - 1));
                    vPays.set(j - 1, temp);
                    permute = true;

                }

                j--;

            }

            i++;

        }

        return vPays;

    }

    public static boolean verifTriContNom(ArrayList<Pays> vPays) {
        // { } => { résultat = vrai si vPays trié selon l'ORDRE(continent, nom) }
        int i = 1;
        while (i < vPays.size() && vPays.get(i).compareTo(vPays.get(i - 1)) >= 0) {

            i++;

        }

        return i == vPays.size();

    }

    public static int indDichoIter(ArrayList<Pays> vPays, String contP, String nomP) {
        // { vPays trié selon l'ORDRE(continent, nom) } =>
        // { résultat = * indice dans vPays du pays de continent contP et de nom nomP,
        // si trouvé
        // * -1 si non trouvé }
        int inf = 0;
        int sup = vPays.size() - 1;
        int m;
        Pays paysTarget = new Pays(nomP, contP, 0, 0);

        while (inf < sup) {

            m = (inf + sup)/2;
            if (paysTarget.compareTo(vPays.get(m)) < 0) {

                sup = m;

            } else if (paysTarget.compareTo(vPays.get(m)) > 0){

                inf = m + 1;

            } else {

                return m;

            }

        }

        if (vPays.get(sup).compareTo(paysTarget) == 0) {

            return sup;

        } else {

            return -1;

        }

    }

    public static int indDichoRec(ArrayList<Pays> vPays, String contP, String nomP) {
        // { vPays trié selon l'ORDRE(continent, nom) } =>
        // { résultat = * indice dans vPays du pays de continent contP et de nom nomP,
        // si trouvé
        // * -1 si non trouvé }

        return indDichoRecWorker(vPays, contP, nomP, 0, vPays.size() - 1);

    }

    public static int indDichoRecWorker(ArrayList<Pays> vPays, String contP, String nomP, int inf, int sup) {
        // { vPays trié selon l'ORDRE(continent,nom), 0<=inf<=sup<vPays.size() } =>
        // { résultat = * indice dans vPays[inf..sup] du pays de continent contP et de
        // nom nomP, si trouvé
        // * -1 si non trouvé }

        Pays paysTarget = new Pays(nomP, contP, 0, 0);

        if (inf == sup) {

            if (paysTarget.compareTo(vPays.get(sup)) == 0) {

                return sup;

            } else {

                return -1;

            }

        } else {

            int m = (inf + sup)/2;
            if (paysTarget.compareTo(vPays.get(m)) < 0) {

                return indDichoRecWorker(vPays, contP, nomP, inf, m);

            } else if (paysTarget.compareTo(vPays.get(m)) > 0){

                return indDichoRecWorker(vPays, contP, nomP, m + 1, sup);

            } else {

                return m;

            }

        }

    }

    public static int nbPaysDeContInfNbHabIter(ArrayList<Pays> vPays, String unCont, int popMax) {
        // { vPays trié selon l'ORDRE(continent, nom), popMax > 0 } =>
        // { résultat = nombre d'éléments de vPays de continent unCont
        // et de population < popMax }

        int compteur = 0;
        int i = 0;
        while (i < vPays.size()) {

            if (vPays.get(i).getContinent().compareTo(unCont) == 0 & vPays.get(i).getPopulation() < popMax) {

                compteur++;

            }

            i++;

        }

        return compteur;

    }

    public static int nbPaysDeContInfNbHabRec(ArrayList<Pays> vPays, String unCont, int popMax) {
        // { vPays trié selon l'ORDRE(continent, nom), popMax > 0 } =>
        // { résultat = nombre d'éléments de vPays de continent unCont
        // et de population < popMax }

        return nbPaysDeContInfHabWorker(vPays, unCont, popMax, 0);

    }

    public static int nbPaysDeContInfHabWorker(ArrayList<Pays> vPays, String unCont, int popMax, int ind) {
        // { vPays[ind..vPays.size()-1] trié selon l'ORDRE(continent, nom),
        // 0<=ind<vPays.size(), popMax > 0 } =>
        // { résultat = nombre d'éléments de vPays[ind..vPays.size()-1]
        // de continent unCont et de population < popMax }

        if (ind == vPays.size()) {

            return 0;

        } else {

            if (vPays.get(ind).getContinent().compareTo(unCont) == 0 & vPays.get(ind).getPopulation() < popMax) {

                return 1 + nbPaysDeContInfHabWorker(vPays, unCont, popMax, ind + 1);

            } else {

                return nbPaysDeContInfHabWorker(vPays, unCont, popMax, ind + 1);

            }

        }

    }



}
