import java.util.Scanner;

public class Nim {

    private static int saisieEntSupEgalMin(int min){
        // { min > 0 } => { résultat = un entier positif supérieur ou égal à min
        // saisi par l'utilisateur }
        Scanner lecteur = new Scanner(System.in);
        int resultat = lecteur.nextInt();
        lecteur.nextLine();
        while (resultat < min){

            System.out.println("Valeur trop faible !");
            System.out.print("Entrez une nouvelle valeur : ");
            resultat = lecteur.nextInt();
            lecteur.nextLine();

        }

        return resultat;

    }

    private static int unePrise(int reste, int max){
        // { reste > 0, max > 0 }
        // => { résultat = entier > 0 et inférieur ou égal à
        // la plus petite valeur parmi reste et max }
        Scanner lecteur = new Scanner(System.in);
        int min;
        int resultat = lecteur.nextInt();
        lecteur.nextLine();

        min = Math.min(reste, max);

        while ((resultat <= 0) | (resultat > min)){

            System.out.println("La valeur doit être supérieure à 0 et inférieure ou égale à " + min);
            System.out.print("Entrez une nouvelle valeur : ");
            resultat = lecteur.nextInt();
            lecteur.nextLine();

        }

        return resultat;

    }

    public static void main(String[] args) {

        Scanner lecteur = new Scanner(System.in);
        final int MINJOUEURS = 2, MAXPRISE = 3;
        int nbJoueurs, nbAllumettes, numJoueur, nbCoups = 0, prise, reste;

        System.out.print("Choix du nombre de joueurs : ");
        nbJoueurs = saisieEntSupEgalMin(MINJOUEURS);

        System.out.println();
        System.out.print("Choix du nombre d'allumettes : ");
        nbAllumettes = saisieEntSupEgalMin(3*nbJoueurs);
        numJoueur = nbJoueurs;
        reste = nbAllumettes;
        System.out.println();

        System.out.println("*************************************");
        System.out.println("* Nombre de joueurs : " + nbJoueurs);
        System.out.println("* Nombre d'allumettes : " + nbAllumettes);
        System.out.println("*************************************");
        System.out.println();

        while (reste > 0){

            if (numJoueur == nbJoueurs){

                numJoueur = 1;

            } else {

                numJoueur++;

            }

            System.out.println("Joueur n°" + numJoueur + ", combien prenez-vous d'allumettes ?");
            System.out.print("Entrez un entier (min 1, max " + Math.min(MAXPRISE, reste) + " ) : ");
            prise = unePrise(reste, MAXPRISE);
            reste = reste - prise;
            System.out.println("--> Il reste " + reste + " allumettes.");
            nbCoups++;

        }

        System.out.println("*************************************");
        System.out.println("Victoire du joueur n°" + numJoueur + " après " + nbCoups + " coups !");
        System.out.println("*************************************");


    }

}
