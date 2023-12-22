import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class PaysDesContinents {

    public static void main(String[] args) {

        Scanner lecteur = new Scanner(System.in);
        ArrayList<Pays> mondeT = new ArrayList<>(InitMondeT.creerMondeT());
        ArrayList<ListeChainee<PaysDeCont>> vListesPdeC = new ArrayList<>();
        ArrayList<String> vContinents = new ArrayList<>(Arrays.asList("Afrique",
"Amériques", "Antarctique", "Asie", "Europe", "Océanie"));
        ListeChainee<PaysDeCont> listeAfrique;
        ListeChainee<PaysDeCont> listeAmeriques;
        ListeChainee<PaysDeCont> listeAntarctique;
        ListeChainee<PaysDeCont> listeAsie;
        ListeChainee<PaysDeCont> listeEurope;
        ListeChainee<PaysDeCont> listeOceanie;

        listeAfrique = Utilitaire.countries(mondeT, "Afrique");
        listeAmeriques = Utilitaire.countries(mondeT, "Amériques");
        listeAntarctique = Utilitaire.countries(mondeT, "Antarctique");
        listeAsie = Utilitaire.countries(mondeT, "Asie");
        listeEurope = Utilitaire.countries(mondeT, "Europe");
        listeOceanie = Utilitaire.countries(mondeT, "Océanie");

        vListesPdeC.add(listeAfrique);
        vListesPdeC.add(listeAmeriques);
        vListesPdeC.add(listeAntarctique);
        vListesPdeC.add(listeAsie);
        vListesPdeC.add(listeEurope);
        vListesPdeC.add(listeEurope);

        System.out.println("Afrique : " + listeAfrique.getLongueur() + ", Amériques : " + listeAmeriques.getLongueur()
        + ", Antarctique : " + listeAntarctique.getLongueur() + ", Asie : " + listeAsie.getLongueur()
        + ", Europe : " + listeEurope.getLongueur() + ", Océanie : " + listeOceanie.getLongueur());

        Utilitaire.affichePaysDeCont(vListesPdeC.get(Utilitaire.indString(lecteur, vContinents)));



    }

}
