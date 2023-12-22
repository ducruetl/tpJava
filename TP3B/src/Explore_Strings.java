public class Explore_Strings {

    private static int nbOccCar (String uneChaine, char unCar) {
        // { } => { résultat = nombre de fois où le caractère unCar
        // apparaît dans la chaîne uneChaine }
        int result = 0;
        for (int i = 0; i < uneChaine.length(); i++){

            if (uneChaine.charAt(i) == unCar) {

                result++;

            }

        }

        return result;

    }

    private static int nbLettresMajSansAccent (String uneChaine) {
        // { } => { résultat = nombre de lettres majuscules
        // non accentuées dans uneChaine }
        int result = 0;
        for (int i = 0; i < uneChaine.length(); i++) {

            if (uneChaine.charAt(i) <= 90 & uneChaine.charAt(i) >= 65) {

                result++;

            }

        }

        return result;

    }

    private static int nbMots (String uneChaine) {
        // { uneChaine ne contient que :
        // * des lettres de l'alphabet (accentuées ou non)
        // * des espaces
        // * un point final }
        // => { résultat = nombre de mots dans uneChaine }
        // NOTE : un mot est constitué de lettres de l'alphabet
        char space = ' ';
        char point = '.';
        int result = 0;
        for (int i = 0; i < uneChaine.length(); i++) {

            if (uneChaine.charAt(i) == space | uneChaine.charAt(i) == point) {

                result++;

            }

        }

        return result;

    }

    private static int nbCarMax(String uneChaine) {
        // { uneChaine ne contient que :
        // * des lettres de l'alphabet (accentuées ou non)
        // * des espaces
        // * un point final }
        // => { résultat = plus grand nombre de caractères
        // d'un mot de uneChaine }
        // NOTE : un mot est constitué de lettres de l'alphabet
        char space = ' ';
        char point = '.';
        int tailleMot = 0, tailleMotMax = 0;
        for (int i = 0; i < uneChaine.length(); i++) {

            if (uneChaine.charAt(i) == space | uneChaine.charAt(i) == point) {

                if (tailleMot > tailleMotMax) {

                    tailleMotMax = tailleMot;

                }

                tailleMot = 0;

            } else {

                tailleMot++;

            }
        }

        return tailleMotMax;

    }

    public static void main(String[] args) {

        String lipogramme = "Un rond pas tout à fait clos, fini par un trait horizontal.";
        String lesVoyellesSansAccent = "aeiouy";
        String ch1 = "Il y a huit mots dans cette phrase.";
        String ch2 = "CE TP GAGNERAIT À ÊTRE TERMINÉ.";

        System.out.println("Analyse de la phrase : " + lipogramme);
        System.out.println();
        for (int i = 0; i < lesVoyellesSansAccent.length(); i++) {

            System.out.println("La lettre '" + lesVoyellesSansAccent.charAt(i) + "' apparaît " + nbOccCar(lipogramme, lesVoyellesSansAccent.charAt(i)) + " fois.");

        }

        System.out.println();
        System.out.println("Première chaîne : " + ch1);
        System.out.println();
        System.out.println("Cette chaîne contient " + nbLettresMajSansAccent(ch1) + " majuscules sans accents.");
        System.out.println("Cette chaîne contient " + nbMots(ch1) + " mots.");
        System.out.println("Le plus grand mot contient " + nbCarMax(ch1) + " caractères.");
        System.out.println();
        System.out.println();
        System.out.println("Deuxième chaîne : " + ch2);
        System.out.println();
        System.out.println("Cette chaîne contient " + nbLettresMajSansAccent(ch2) + " majuscules sans accents.");
        System.out.println("Cette chaîne contient " + nbMots(ch2) + " mots.");
        System.out.println("Le plus grand mot contient " + nbCarMax(ch2) + " caractères.");
    }

}
