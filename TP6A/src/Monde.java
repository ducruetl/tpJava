import java.util.ArrayList;
import java.util.Scanner;

public class Monde {

    public static void main(String[] args) {

        Scanner lecteur = new Scanner(System.in);
        ArrayList<Pays> leMonde = InitMonde.creerMonde();
        ArrayList<Pays> vPaysDeCont;
        ArrayList<String> lesContinents = new ArrayList<>();
        String unCont;
        String unPays;

        for (int i = 0; i < leMonde.size(); i++) {

            if (Utilitaire.indContinent(lesContinents, leMonde.get(i).getContinent()) != -1) {

                lesContinents.add(Utilitaire.indContinent(lesContinents, leMonde.get(i).getContinent()), leMonde.get(i).getContinent());

            }

        }

        System.out.println("---------------------------------------");
        System.out.println("         AFFICHAGE DES PAYS");
        System.out.println("---------------------------------------");
        System.out.println();

        for (int i = 0; i < leMonde.size(); i++) {

            System.out.println(leMonde.get(i));

        }

        System.out.println();
        System.out.println("---------------------------------------");
        System.out.println("       AFFICHAGE DES CONTINENTS");
        System.out.println("---------------------------------------");
        System.out.println();

        for (int i = 0; i < lesContinents.size(); i++) {

            System.out.println(lesContinents.get(i));

        }

        System.out.println();
        System.out.println("---------------------------------------");
        System.out.println();
        unCont = Utilitaire.saisieCont(lesContinents);
        vPaysDeCont = Utilitaire.paysDeCont(leMonde, unCont);
        System.out.println();
        System.out.println("Premier pays du continent '" + unCont + "' : " + vPaysDeCont.get(0).getNom());
        System.out.println("Dernier pays du continent '" + unCont + "' :" + vPaysDeCont.get(vPaysDeCont.size() - 1).getNom());
        System.out.println("Nombre de pays du continent '" + unCont + "' : " + vPaysDeCont.size());

        System.out.println();
        System.out.println("---------------------------------------");
        System.out.println();
        System.out.print("Entrez un pays : ");
        unPays = lecteur.nextLine();
        if (Utilitaire.rechPaysT(vPaysDeCont, unPays) != vPaysDeCont.size()) {

            System.out.println(vPaysDeCont.get(Utilitaire.rechPaysT(vPaysDeCont, unPays)));

        } else {

            System.out.println(unPays + " ne fait pas partie du continent '" + unCont + "'");

        }

        Utilitaire.paysMoinsPeuples(leMonde);
        Utilitaire.contExtremes(leMonde, lesContinents);

    }

}
