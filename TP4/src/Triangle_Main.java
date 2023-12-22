import java.util.Scanner;

public class Triangle_Main {

    public static void main(String[] args) {

        //declarations
        Scanner lecteur = new Scanner(System.in);

        Point ptA = new Point(1, 1);
        Point ptB = new Point(3, 5);
        Point ptC = new Point(5, 1);
        Point ptA2 = new Point(1, 1);
        Point ptB2 = new Point(3, 5);
        Point ptC2 = new Point(5, 1);

        TriangleCompose tComp = new TriangleCompose(ptA, ptB, ptC);
        TriangleAgrege tAgr = new TriangleAgrege(ptA2, ptB2, ptC2);

        int dx, dy;

        //affichage coordonnées
        System.out.println("Point A : " + ptA);
        System.out.println("Point B : " + ptB);
        System.out.println("Point C : " + ptC);
        System.out.println();

        //affichage triangles
        System.out.println("Triangle composé : " + tComp);
        System.out.println("Triangle agrégé : " + tAgr);
        System.out.println();

        //valeurs modification coordonnées
        System.out.println("Modification de la valeur x : ");
        dx = lecteur.nextInt();
        lecteur.nextLine();
        System.out.println("Modification de la valeur y : ");
        dy = lecteur.nextInt();
        lecteur.nextLine();
        System.out.println();

        //modification coordonnées
        tComp.deplacer(dx, dy);
        tAgr.deplacer(dx, dy);

        //affichage coordonnées modifiées
        System.out.println("Triangle composé : ");
        System.out.println();
        System.out.println("Point A : " + ptA);
        System.out.println("Point B : " + ptB);
        System.out.println("Point C : " + ptC);
        System.out.println();
        System.out.println(tComp);
        System.out.println();
        System.out.println("Triangle agrégé : ");
        System.out.println();
        System.out.println("Point A : " + ptA2);
        System.out.println("Point B : " + ptB2);
        System.out.println("Point C : " + ptC2);
        System.out.println();
        System.out.println(tAgr);

    }

}
