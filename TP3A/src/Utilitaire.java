import java.util.Scanner;

public class Utilitaire {
    public static float saisieFloatPos() {
    // { } => { résultat = un réel (float) strictement positif }
        Scanner lecteur = new Scanner(System.in);
        float result;
        do {

            System.out.print("Entrez une valeur positive : ");
            result = lecteur.nextFloat();
            lecteur.nextLine();

            if (result <= 0.0f){

                System.out.println("Valeur incorrecte !");

            }

        } while (result <= 0.0f);

        return result;

    }

    public static float saisieFloatPosMinMax(float min, float max) {
        // { 0 < min < max } =>
        // { résultat = un réel saisi par l'utilisateur, appartenant à ]min, max[ }
        Scanner lecteur = new Scanner(System.in);
        float result;
        do {

            System.out.print("Entrez une valeur : ");
            result = lecteur.nextFloat();
            lecteur.nextLine();

            if (result <= min | result >= max){

                System.out.println("Valeur incorrecte !");

            }

        } while (result <= min | result >= max);

        return result;

    }

    public static float troisiemeCoteTriangle(float cote1, float cote2) {
        // { cote1 et cote2 > 0 } =>
        // { le résultat est un float strictement positif, tel qu'un triangle dont
        // les côtés seraient cote1, cote2 et le float saisi puisse être construit }
        // INDICATION : INÉGALITÉ TRIANGULAIRE

        float cote3;
        float max = cote1;
        float autre1 = cote2;
        float autre2;

        do {
                cote3 = saisieFloatPos();
                autre2 = cote3;

                if (cote2 > max) {

                    max = cote2;
                    autre1 = cote1;

                }
                if (cote3 > max) {

                    max = cote3;
                    autre2 = cote2;

                }

                if (max >= (autre1 + autre2)) {

                    System.out.println("Valeur incorrecte !");

                }

            } while(max >= (autre1 + autre2));

            return cote3;

        }
    public static Rectangle saisirRectangle() {
        // { } => { résultat = un nouvel objet de type Rectangle
        // dont les côtés sont saisis par l'utilisateur }
        System.out.println("Longueur coté 1 ?");
        float cote1 = saisieFloatPos();
        System.out.println("Longueur coté 2 ?");
        float cote2 = saisieFloatPos();
        return new Rectangle(cote1, cote2);

    }

    public static Cercle saisirCercle() {
        // { } => { résultat = un nouvel objet de type Cercle dont le rayon
        // est saisi par l'utilisateur }
        System.out.println("Longueur rayon ?");
        float rayon = saisieFloatPos();
        return new Cercle(rayon);

    }

    public static Triangle saisirTriangle() {
        // { } => { résultat = un nouvel objet de type triangle
        // dont les côtés sont saisis par l'utilisateur }
        System.out.println("Longueur coté 1 ?");
        float cote1 = saisieFloatPos();
        System.out.println("Longueur coté 2 ?");
        float cote2 = saisieFloatPos();
        System.out.println("Longueur coté 3 ?");
        float cote3 = troisiemeCoteTriangle(cote1, cote2);
        return new Triangle(cote1, cote2, cote3);

    }
}
