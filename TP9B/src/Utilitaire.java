import java.util.ArrayList;
import java.util.Scanner;

public class Utilitaire {

    public static ListeChainee<PaysDeCont> countries(ArrayList<Pays> mondeT, String cont) {
// { mondeT non vide, trié selon l'ORDRE (continent, nom) } =>
// { résultat = liste chainée des pays du continent cont, TRIÉE par nom }

        ListeChainee <PaysDeCont> listPays = new ListeChainee<>();

        int i = 0;

        while (!mondeT.get(i).getContinent().equals(cont)) {

            i++;

        }

        int j = i + 1;

        listPays.insereTete(new PaysDeCont(mondeT.get(i).getNom(), mondeT.get(i).getPopulation(), mondeT.get(i).getSuperficie()));

        while (j < mondeT.size() && mondeT.get(j).getContinent().equals(cont)) {

            listPays.insereAtPosit((j - i) + 1, new PaysDeCont(mondeT.get(j).getNom(), mondeT.get(j).getPopulation(), mondeT.get(j).getSuperficie()));
            j++;

        }

        return listPays;

    }

    public static void affichePaysDeCont(ListeChainee<PaysDeCont> listePdeC) {
// { listePdeC non vide } =>
// { l'information portée par chaque celle de listePdeC a été affichée
// ligne à ligne, précédée par sa position dans listePdeC }

        affichePaysDeCont_wk(0, listePdeC.getTete());

    }

    private static void affichePaysDeCont_wk(int pos, Cellule<PaysDeCont> cellCour) {

        System.out.println(pos + " : " + cellCour.getInfo());

        if (cellCour.getCelluleSuivante() != null) {

            affichePaysDeCont_wk(pos + 1, cellCour.getCelluleSuivante());

        }

    }

    public static int indString(Scanner lecteur,
                                ArrayList<String> vString) {
// { vString non vide, trié par ordre strictement croissant } =>
// { résultat = indice dans vString, d'une chaîne saisie par l'utilisateur }
// La saisie a été répétée tant que la chaîne saisie n'est pas dans vString

        String value;
        do {

            System.out.print("Entrez un continent : ");
            value = lecteur.nextLine();

            if (!vString.contains(value)) {

                System.out.println("Entrée invalide, réessayer...");

            }

        } while (!vString.contains(value));

        return vString.indexOf(value);

    }

    public static void contExtremes(ArrayList<String> vCont,
ArrayList<ListeChainee<PaysDeCont>>vListesPdeC) {
// { * vCont, trié et non vide : vecteur des continents du monde
// * vListesPdeC, non vide : vecteur des listes de pays de ces continents
// dans l'ordre des continents de vCont } =>
// { le nom et le nombre de pays du continent qui a le plus de pays est affiché,
// ainsi que le nom et le nombre de pays du continent qui a le moins de pays }

    }

}
