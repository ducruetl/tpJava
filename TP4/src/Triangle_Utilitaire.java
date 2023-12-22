import java.util.Scanner;

public class Triangle_Utilitaire {

    public static Point saisirPoint() {
        // { } => {résultat = un Point dont les coordonnées
        // sont saisies par l'utilisateur}
        Scanner lecteur = new Scanner(System.in);
        System.out.print("Coordonnée x : ");
        int x = lecteur.nextInt();
        lecteur.nextLine();
        System.out.print("Coordonnée y : ");
        int y = lecteur.nextInt();
        lecteur.nextLine();
        return new Point(x, y);

    }

    public static Point saisirPointNonConfondu(Point lePoint) {
        // { } => {résultat = un Point non confondu avec lePoint,
        // dont les coordonnées sont saisies par l'utilisateur}
        Scanner lecteur = new Scanner(System.in);
        int x, y;
        do {

            System.out.print("Coordonnée x : ");
            x = lecteur.nextInt();
            lecteur.nextLine();
            System.out.print("Coordonnée y : ");
            y = lecteur.nextInt();
            lecteur.nextLine();

            if (x == lePoint.getX() & y == lePoint.getY()) {

                System.out.println("Erreur, les coordonnées doivent être différentes de " + lePoint);

            }

        } while (x == lePoint.getX() & y == lePoint.getY());

        return new Point(x, y);

    }

    public static Point saisirPointNonAligneP1P2(Point p1, Point p2) {
        // { } => { résultat = un Point de coordonnées saisies par l'utilisateur,
        // différent de p1 et de p2 et non aligné avec p1 et p2 }
        Scanner lecteur = new Scanner(System.in);
        int x, y;
        do {

            System.out.print("Coordonnée x : ");
            x = lecteur.nextInt();
            lecteur.nextLine();
            System.out.print("Coordonnée y : ");
            y = lecteur.nextInt();
            lecteur.nextLine();

            if ((x == p1.getX() & x == p2.getX())) {

                System.out.println("Erreur, la coordonnée X doit être différente de " + x);

            } else if ((y == p1.getY() && y == p2.getY())) {

                System.out.println("Erreur, la coordonnée Y doit être différente de " + y);

            }
            else if ((x != p1.getX()) && (x != p2.getX()) && (p1.getX() != p2.getX()) && (((p1.getY() - y) / ((p1.getX()) - x)) == ((p2.getY() - y) / (p2.getX() - x)))){

                System.out.println("Erreur, les 3 points sont alignés.");

            }

        } while ((x == p1.getX() && x == p2.getX()) || (y == p1.getY() && y == p2.getY()) || ((x != p1.getX()) && (x != p2.getX()) && (p1.getX() != p2.getX()) && (((p1.getY() - y) / ((p1.getX()) - x)) == ((p2.getY() - y) / (p2.getX() - x)))));

        return new Point(x, y);

    }

    public static TriangleCompose symetriqueH(TriangleCompose tComp) {
        // { } =>
        // { résultat = nouveau TriangleCompose dont les sommets sont obtenus par
        // symétrie des sommets de tComp par rapport à l'axe horizontal }

        Point pA = new Point(tComp.getSomA().getX(), -tComp.getSomA().getY());
        Point pB = new Point(tComp.getSomB().getX(), -tComp.getSomB().getY());
        Point pC = new Point(tComp.getSomC().getX(), -tComp.getSomC().getY());

        return new TriangleCompose(pA, pB, pC);

    }

    public static TriangleCompose symetriqueV(TriangleCompose tComp) {
        // { } =>
        // { résultat = nouveau TriangleCompose dont les sommets sont obtenus par
        // symétrie des sommets de tComp par rapport à l'axe vertical }

        Point pA = new Point(-tComp.getSomA().getX(), tComp.getSomA().getY());
        Point pB = new Point(-tComp.getSomB().getX(), tComp.getSomB().getY());
        Point pC = new Point(-tComp.getSomC().getX(), tComp.getSomC().getY());

        return new TriangleCompose(pA, pB, pC);

    }


}
