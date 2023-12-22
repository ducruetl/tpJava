import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class VecteursDeString {

    private static int nbChEgales(ArrayList<String> v1, ArrayList<String> v2) {
        // { v1 non vide, sans doublons, de même taille que v2 } =>
        // { résultat = nombre d'éléments de v1 dont la valeur est égale
        // à celle de l'élément de même indice dans v2 }
        int result = 0;
        for (int i = 0; i < v1.size(); i++) {

            if (v1.get(i).equals(v2.get(i))) {

                result++;

            }

        }

        return result;

    }

    public static String equiv(String uneChaine, ArrayList<String> v1, ArrayList<String> v2) {
        // { v1 non vide, sans doublons, de même taille que v2 } =>
        // { résultat = * chaîne du vecteur v2, ayant le même indice que
        // uneChaine dans v1 si uneChaine est un élément de v1,
        // * chaîne vide sinon }
        int i = 0;
        while (i < v1.size() && !uneChaine.equals(v1.get(i))) {

            i++;

        }

        if (i == v1.size()) {

            return "";

        } else {

            return v2.get(i);

        }

    }

    public static void main(String[] args) {

        Scanner lecteur = new Scanner(System.in);
        String couleur;
        ArrayList<String> couleursFR = new ArrayList<>(Arrays.asList("rouge", "orange", "jaune", "vert", "bleu", "indigo", "violet"));
        ArrayList<String> colorsEN = new ArrayList<>(Arrays.asList("red", "orange", "yellow", "green", "blue", "indigo", "purple"));

        System.out.println("Couleurs de l'arc en ciel en français : " + couleursFR);
        System.out.println("Couleurs de l'arc en ciel en anglais : " + colorsEN);
        System.out.println("-------------------------------------------------------");
        System.out.println("Nombre de couleurs de même nom : " + nbChEgales(couleursFR, colorsEN));
        do {
            System.out.println("-------------------------------------------------------");
            System.out.print("Entrez le nom français d'une des 7 couleurs de l'arc en ciel : ");
            couleur = lecteur.nextLine();
            if (equiv(couleur, couleursFR, colorsEN).isEmpty()) {

                System.out.println("--> La couleur " + couleur + " ne fait pas partie des 7 couleurs de l'arc en ciel en français.");

            } else {

                System.out.println("--> L'équivalent de " + couleur + " parmis les noms des 7 couleurs de l'arc en ciel en anglais est : " + equiv(couleur, couleursFR, colorsEN));

            }

            System.out.print("*** Recommencer (o pour continuer / n pour arrêter) : ");

        } while (lecteur.nextLine().charAt(0) == 'o');
    }

}
