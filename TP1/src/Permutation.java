import java.util.Scanner;
public class Permutation {

    public static void main(String[] args){

        int a, b, c, d, e, sauv;
        Scanner lecteur = new Scanner(System.in);

        System.out.println("Entrez un premier entier : ");
        a = lecteur.nextInt();
        lecteur.nextLine();

        System.out.println("Entrez un deuxième entier : ");
        b = lecteur.nextInt();
        lecteur.nextLine();

        System.out.println("Entrez un troisième entier : ");
        c = lecteur.nextInt();
        lecteur.nextLine();

        System.out.println("Entrez un quatrième entier : ");
        d = lecteur.nextInt();
        lecteur.nextLine();

        System.out.println("Entrez un dernier entier : ");
        e = lecteur.nextInt();
        lecteur.nextLine();

        sauv = a;
        a = b;
        b = c;
        c = d;
        d = e;
        e = sauv;

        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + c);
        System.out.println("d = " + d);
        System.out.println("e = " + e);
    }
}
