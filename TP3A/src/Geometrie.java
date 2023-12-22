public class Geometrie {

    public static void main(String[] args) {
        // Création et affichage rectangle
        System.out.println("Création d'un rectangle :");
        System.out.println();
        Rectangle rectangle1 = Utilitaire.saisirRectangle();
        System.out.println(rectangle1);

        // Création et affichage cercle
        System.out.println("Création d'un cercle :");
        System.out.println();
        Cercle cercle1 = Utilitaire.saisirCercle();
        System.out.println(cercle1);

        // Création et affichage triangle
        System.out.println("Création d'un triangle :");
        System.out.println();
        Triangle triangle1 = Utilitaire.saisirTriangle();
        System.out.println(triangle1);
    }

}
