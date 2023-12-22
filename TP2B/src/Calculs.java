import java.util.Scanner;

public class Calculs {

    private static int saisieEntPosOuNul() {
        // { } =>
        // { résultat = un entier positif ou nul saisi par l'utilisateur }
        Scanner lecteur = new Scanner(System.in);
        System.out.print("Entrez un entier positif : ");
        int resultat = lecteur.nextInt();
        lecteur.nextLine();
        while (resultat < 0){

            System.out.println("Valeur incorrecte.");
            System.out.print("Entrez un entier positif : ");
            resultat = lecteur.nextInt();
            lecteur.nextLine();

        }

        return resultat;

    }

    private static int saisieEntMinMax(int min, int max){
        // { 0 <= min <= max } => { résultat = entier compris entre min et max
        // saisi par l'utilisateur }
        Scanner lecteur = new Scanner(System.in);
        int resultat;

        System.out.print("Entrez une valeur entre " + min + " et " + max + " : ");
        resultat = lecteur.nextInt();
        lecteur.nextLine();
        while ((resultat < min) | (resultat > max)) {

            System.out.println("Valeur incorrecte.");
            System.out.print("Entrez une valeur entre " + min + " et " + max + " : ");
            resultat = lecteur.nextInt();
            lecteur.nextLine();

        }
        return resultat;

    }

    private static int factorielle(int n){
        // { n >= 0 } => { résultat = factorielle de n (n!) }
        int resultat = 1;

        for (int i = 1; i <= n; i++){

            resultat = resultat * i;

        }

        return resultat;

    }

    private static int combinaison(int n, int p){
        // { 0 <= p <= n } =>
        // { résultat = nombre de sous-ensembles de p éléments que l'on peut
        // obtenir à partir d'un ensemble de n éléments
        // formule : n!/(p!*(n-p)!) }
        return factorielle(n)/(factorielle(p)*factorielle(n-p));

    }

    private static int arrangement(int n, int p){
        // { 0 <= p <= n } =>
        // { résultat = nombre de n-uplets ordonnés de p éléments que l'on
        //peut obtenir à partir d'un ensemble de n éléments
        // formule : n!/(n-p)! }
        return factorielle(n)/factorielle(n-p);

    }

    public static void main(String[] args) {

        Scanner lecteur = new Scanner(System.in);
        int n, p;

        n = saisieEntPosOuNul();
        p = saisieEntMinMax(0, n);

        System.out.println("Factorielle de " + n + " : " + factorielle(n));

    }

}
