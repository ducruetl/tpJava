import jdk.jshell.execution.Util;
import org.w3c.dom.TypeInfo;

import java.util.Random;
import java.util.Scanner;

public class TestListInt {

    public static void main(String[] args) throws ExceptionMauvaisIndice {

        ListeChainee<Integer> listInt = new ListeChainee<>();
        Scanner lecteur = new Scanner(System.in);
        for (int i = 0; i < 15; i++) {

            listInt.insereTete(new Random().nextInt(101));

        }

        System.out.println("Nombre de cellules : " + listInt.getLongueur());

        listInt.afficheGaucheDroiteRec();

        System.out.print("Somme des valeurs des cellules ( Itératif ) : " + Utilitaire.sumIter(listInt));
        System.out.println();
        System.out.print("Somme des valeurs des cellules ( Récursif ) : " + Utilitaire.sumRec(listInt));

        System.out.println();
/*
        System.out.print("Entrez une valeur : ");
        int unInt = lecteur.nextInt();
        lecteur.nextLine();

        System.out.println(Utilitaire.existIntRec(listInt, unInt));

        int entier = Utilitaire.posFirstSup(listInt, unInt);
        if (entier != 0){

            try{

            System.out.println(listInt.getInfoAtPosit(entier));

            } catch(ExeptionMauvaisIndice e) {

                system.out.println("Mauvais indice");

            }
        } else {

            System.out.println("Aucun entier dans la liste supérieur à " + unInt);

        }

 */

        System.out.println("Plus gros entier : " + Utilitaire.bigger(listInt));

        int pos = Utilitaire.getIntMinMax_IME(lecteur, 1, listInt.getLongueur());

        ListeChainee <Integer> sousListe = Utilitaire.subList(listInt, pos);

        sousListe.afficheGaucheDroiteRec();

        System.out.println("Qte de nombres pairs : " + Utilitaire.nbMult2(sousListe));

    }



}
