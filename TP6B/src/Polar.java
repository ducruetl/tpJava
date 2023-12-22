import java.util.ArrayList;
import java.util.Scanner;

public class Polar implements Comparable<Polar> {

    // attributs
    private int annee; // année de première parution
    private String auteur; // auteur du roman policier
    private String titre; // titre du roman policier

    // constructeur
    public Polar(int annee, String auteur, String titre) {

        this.annee = annee;
        this.auteur = auteur;
        this.titre = titre;

    }

    // getters
    public int getAnnee() {

        return annee;

    }

    public String getAuteur() {

        return auteur;

    }

    public String getTitre() {

        return titre;

    }


    @Override
    // ordre naturel sur l'année et à année égale sur l'auteur : ordre (annee, auteur)
    public int compareTo(Polar o) {
        // { } =>
        // { résultat =
        //      * -1 si l'attribut annee de cePolar est inférieur à celui de o,
        //             ou si l'attribut annee de cePolar est égal à celui de o
        //                  et l'attribut auteur de cePolar précède celui de o selon l'ordre lexicograpique
        //      *  0 si les attributs annee de cePolar et de o sont égaux
        //            et les attributs auteur de cePolar et de o sont selon l'ordre lexicographique
        //       *  1 dans tous les autres cas
        if (this.annee < o.getAnnee() | (this.annee == o.getAnnee() & this.auteur.compareTo(o.getAuteur()) < 0)) {

            return -1;

        } else if (this.annee == o.getAnnee() & this.auteur.compareTo(o.getAuteur()) == 0) {

            return 0;

        } else {

            return 1;

        }


    }

    public static int saisirIntMinMax(int min, int max) {
        // { min <= max } => { résultat = entier compris entre min et max }
        Scanner lecteur = new Scanner(System.in);
        int result;
        do {

            System.out.print("Entrez une valeur entre " + min + " et " + max + " : ");
            result = lecteur.nextInt();;
            lecteur.nextLine();

            if (result < min | result > max) {

                System.out.println("Valeur invalide, réessayer...");

            }

        } while (result < min | result > max);

        return result;

    }

    public static int rechPremIndSeq(ArrayList<Polar> vPolar, int an, String aut) {
        // { vPolar trié dans l'ordre (annee, auteur) } =>
        // { * s'il y a dans vPolar au moins un élément d'année an et d'auteur aut,
        // résultat = indice du premier de ces éléments
        // * sinon, résultat = -1 }
        int i = 0;
        while (i < vPolar.size() && (vPolar.get(i).getAnnee() != an | vPolar.get(i).getAuteur().compareTo(aut) != 0)) {

            i++;

        }

        if (i == vPolar.size()) {

            return -1;

        } else {

            return i;

        }

    }

    public static int rechPremIndDicho(ArrayList<Polar> vPolar, int an, String aut) {
        // { vPolar trié dans l'ordre (annee, auteur) } =>
        // { * s'il y a dans vPolar au moins un élément d'année an et d'auteur aut,
        // résultat = indice du premier de ces éléments
        // * sinon, résultat = -1 }
        if (aut.compareTo(vPolar.get(vPolar.size() - 1).getAuteur()) > 0) {

            return  -1;

        } else {

            int inf = 0;
            int sup = vPolar.size() - 1;
            int m;

            while (inf < sup) {

                m = (inf + sup) / 2;
                if (vPolar.get(m).getAnnee() < inf) {

                    

                }

            }

        }

    }

    @Override
    // traduction en chaîne de caractères
    public String toString() {
        // { } =>
        // { résultat = chaîne représentant les attributs de cePolar
        //   EXEMPLE : (2019, SYLVAIN, Kabukicho}

            return "(" + this.annee + ", " + this.auteur + ", " + this.titre + ")";

    }
}