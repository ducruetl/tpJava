import java.util.Scanner;

public class Localisation {

    public static void main(String[] args) {

        int x, y;
        Scanner lecteur = new Scanner(System.in);
        char jeu;

        do {

            System.out.print("Entrez une coordonnée pour x : ");
            x = lecteur.nextInt();
            lecteur.nextLine();
            System.out.print("Entrez une coordonnée pour y : ");
            y = lecteur.nextInt();
            lecteur.nextLine();

            if (x < 0 & y < 0) System.out.println("Position : Sud-Ouest");
            else if (x > 0 & y > 0) System.out.println("Position : Nord-Est");
            else if (x == 0 & y == 0) System.out.println("Position : Centre");
            else if (x < 0 & y > 0) System.out.println("Position : Nord-Ouest");
            else if (x > 0 & y < 0) System.out.println("Position : Sud-Est");
            else if (x == 0 & y > 0) System.out.println("Position : Nord");
            else if (x == 0 & y < 0) System.out.println("Position : Sud");
            else if (x > 0) { // x > 0 & y == 0
                System.out.println("Position : Est");
            }
            else System.out.println("Position : Ouest");

            System.out.println("Taper o pour rejouer, n pour arrêter.");
            jeu = lecteur.next().charAt(0);
            lecteur.nextLine();

        } while (jeu == 'o');

    }

}
