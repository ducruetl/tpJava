import java.util.ArrayList;
import java.util.Scanner;

public class Monde {

    public static void main(String[] args) {

        Scanner lecteur = new Scanner(System.in);

        ArrayList<Pays> leMonde = InitMonde.creerMonde();

        System.out.println("Pays avec la plus grande superficie ( Iterative ) : " + Utilitaire.plusGrandPaysIter(leMonde));
        System.out.println("Pays avec la plus grande superficie ( Recursive ) : " + Utilitaire.plusGrandPaysDPR(leMonde));

        System.out.println();

        System.out.println("Pays avec la plus petite population ( Iterative ) : " + Utilitaire.indMinPopIter(leMonde));
        int minPop = Utilitaire.indMinPopDPR(leMonde);
        System.out.println("Pays avec la plus petite population ( Recursive ) : " + minPop);
        System.out.println("Caractéristique de l'élément " + minPop + " : " + leMonde.get(minPop));

        System.out.println();

        ArrayList<Pays> leMondeTrie = Utilitaire.triBulleContNom(leMonde);
        System.out.println("Vecteur trié : " + Utilitaire.verifTriContNom(leMondeTrie));

        System.out.println();

        System.out.print("Entrez un continent : ");
        String unCont = lecteur.nextLine();
        System.out.print("Entrez un pays : ");
        String unNomP = lecteur.nextLine();

        System.out.println();

        System.out.println("Element trouvé ( Iterative ) : " + Utilitaire.indDichoIter(leMondeTrie, unCont, unNomP));
        System.out.println("Element trouvé ( Recursive ) : " + Utilitaire.indDichoRec(leMondeTrie, unCont, unNomP));

        if (Utilitaire.indDichoIter(leMondeTrie, unCont, unNomP) != -1) {

            System.out.println(leMondeTrie.get(Utilitaire.indDichoIter(leMondeTrie, unCont, unNomP)));

        }

        System.out.println();

        System.out.println("Pays en " + unCont + " ayant moins de 100 000 habitants ( Iterative ) : " + Utilitaire.nbPaysDeContInfNbHabIter(leMondeTrie, unCont, 100000));
        System.out.println("Pays en " + unCont + " ayant moins de 100 000 habitants ( Recursive ) : " + Utilitaire.nbPaysDeContInfNbHabRec(leMondeTrie, unCont, 100000));


    }

}
