import java.util.Scanner;

public class Triangle_Main2 {

    public static void main(String[] args) {

        //déclarations
        Scanner lecteur = new Scanner(System.in);
        int dx, dy;

        //saisie coordonnées
        System.out.println("Valeur point A ?");
        Point ptA = Triangle_Utilitaire.saisirPoint();
        System.out.println("Valeur point B ?");
        Point ptB = Triangle_Utilitaire.saisirPointNonConfondu(ptA);
        System.out.println("Valeur point C ?");
        Point ptC = Triangle_Utilitaire.saisirPointNonAligneP1P2(ptA, ptB);

        TriangleCompose tComp = new TriangleCompose(ptA, ptB, ptC);
        TriangleCompose tCompH = Triangle_Utilitaire.symetriqueH(tComp);
        TriangleCompose tCompV = Triangle_Utilitaire.symetriqueV(tComp);

        //affichage coordonnées
        System.out.println("Point A : " + ptA);
        System.out.println("Point B : " + ptB);
        System.out.println("Point C : " + ptC);
        System.out.println();

        //affichage triangle base
        System.out.println("Triangle construit avec les points A, B et C : ");
        System.out.println(tComp);
        System.out.println();
        System.out.println("Triangle symétrique par rapport à l'axe horizontal : ");
        System.out.println(tCompH);
        System.out.println();
        System.out.println("Triangle symétrique par rapport à l'axe vertical : ");
        System.out.println(tCompV);
        System.out.println();

        //déplacement triangle
        System.out.println("Déplacement du triangle : ");
        System.out.print("Déplacement horizontal ? : ");
        dx = lecteur.nextInt();
        lecteur.nextLine();
        System.out.print("Déplacement vertical ? : ");
        dy = lecteur.nextInt();
        lecteur.nextLine();
        System.out.println();
        tComp.deplacer(dx, dy);
        tCompH = Triangle_Utilitaire.symetriqueH(tComp);
        tCompV = Triangle_Utilitaire.symetriqueV(tComp);

        //affichage triangle modifié
        System.out.println("Triangle modifié : ");
        System.out.println(tComp);
        System.out.println();
        System.out.println("Triangle symétrique par rapport à l'axe horizontal : ");
        System.out.println(tCompH);
        System.out.println();
        System.out.println("Triangle symétrique par rapport à l'axe vertical : ");
        System.out.println(tCompV);
        System.out.println();

    }

}
