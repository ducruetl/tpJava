import java.util.InputMismatchException;
import java.util.Scanner;

public class Utilitaire {

    public static int getInt_IME(Scanner lecteur) {
// { } => {résultat = un entier saisi par l'utilisateur }
// L'EXCEPTION InputMismatchException EST GÉRÉE
        int input;
        try {

            System.out.print("Entrez un entier : ");
            input = lecteur.nextInt();
            return input;

        } catch (InputMismatchException e) {

            lecteur.nextLine();
            System.out.println("Veuillez entrer un entier.");
            return getInt_IME(lecteur);

        }

    }

    public static int getIntMinMax_IME(Scanner lecteur, int min, int max) {
// { min <= max } =>
// { résultat = un entier compris entre min et max, saisi par l'utilisateur }
// L'EXCEPTION inputMismatchException EST GÉRÉE
        int input;

            try {

                System.out.print("Entrez un entier entre " + min + " et " + max + " : ");
                input = lecteur.nextInt();
                if (input < min | input > max) {

                    throw new Exception("Valeur incorrecte");

                }
                return input;

            } catch (InputMismatchException e) {

                lecteur.nextLine();
                System.out.println("Veuillez entrer un entier.");
                return getIntMinMax_IME(lecteur, min, max);

            } catch (Exception e){

                lecteur.nextLine();
                System.out.println("La valeur doit être comprise entre " + min + " et " + max + ".");
                return getIntMinMax_IME(lecteur, min, max);

            }

    }

    public static int getInt_NFE(Scanner lecteur) {
// { } => {résultat = un entier saisi par l'utilisateur }
// L'EXCEPTION NumberFormatException EST GÉRÉE

        String s;
        int result;

        try {

            System.out.print("Entrez une valeur à convertir en entier : ");
            s = lecteur.nextLine();
            result = Integer.parseInt(s);
            return result;

        } catch (NumberFormatException nfe) {

            System.out.println("Valeur incorrecte.");
            return getInt_NFE(lecteur);

        }

    }

    public static float getFloat_NFE(Scanner lecteur) {
// { } => { résultat = un réel saisi par l'utilisateur }
// L'EXCEPTION NumberFormatException EST GÉRÉE
        String s;
        float result;

        try {

            System.out.print("Entrez une valeur à convertir en float : ");
            s = lecteur.nextLine();
            result = Float.parseFloat(s);
            return result;

        } catch (NumberFormatException nfe) {

            System.out.println("Valeur incorrecte.");
            return getFloat_NFE(lecteur);

        }
    }

    public static int sumIter(ListeChainee<Integer> listInt) {
// { listInt non vide } =>
// { résultat = somme des entiers portés par les cellules de listInt }

        int sum = 0;
        Cellule<Integer> i = listInt.getTete();

        while (i != null) {

            sum = sum + i.getInfo();
            i = i.getCelluleSuivante();

        }

        return sum;

    }

    public static int sumRec(ListeChainee<Integer> listInt) {
// { listInt non vide } =>
// { résultat = somme des entiers portés par les cellules de listInt }

        int sum = sumRec_wk(listInt.getTete());
        return sum;

    }

    private static int sumRec_wk(Cellule<Integer> cellCour) {
// { } =>
// { résultat = somme des entiers portés par les cellules d'une sous-liste
// de tête cellCour

        if (cellCour.getCelluleSuivante() != null) {

            return sumRec_wk(cellCour.getCelluleSuivante()) + cellCour.getInfo();

        } else {

            return cellCour.getInfo();

        }

    }

    public static boolean existIntRec(ListeChainee<Integer> listInt, int unInt) {
// { } =>
// { résultat = vrai si au moins une cellule de listInt porte l'info unInt }

        return existIntRec_wk(listInt.getTete(), unInt);

    }

    private static boolean existIntRec_wk(Cellule<Integer> cellCour, int unInt) {
// { } => { résultat = vrai si au moins une cellule d'une sous-liste de tête
// cellCour porte l'info unInt }

        if (cellCour.getInfo() == unInt) {

            return true;

        } else if (cellCour.getCelluleSuivante() != null) {

            return existIntRec_wk(cellCour.getCelluleSuivante(), unInt);

        } else {

            return false;

        }

    }

    public static int posFirstSup(ListeChainee<Integer> listInt, int unInt) {
// { } => {résultat = rang de la première cellule de listInt portant
// un entier supérieur à unInt, 0 si non trouvée }

        int i = 1;
        Cellule <Integer> cell = listInt.getTete();

        while(i <= listInt.getLongueur() && cell.getInfo() <= unInt) {

            cell = cell.getCelluleSuivante();
            i++;

        }

        if (i > listInt.getLongueur()) {

            return 0;

        } else {

            return i;

        }

    }

    public static int bigger(ListeChainee<Integer> listInt) {
// { listInt non vide } =>
// { résultat = plus grand entier porté par une cellule de listInt }

        int i = 2;
        Cellule <Integer> cell = listInt.getTete();
        int maxInt = cell.getInfo();

        while (i <= listInt.getLongueur()) {

            cell = cell.getCelluleSuivante();
            if (cell.getInfo() > maxInt) {

                maxInt = cell.getInfo();

            }
            i++;

        }

        return maxInt;

    }

    public static ListeChainee<Integer> subList(ListeChainee<Integer> listInt,
                                                int position) {
// { * listInt non vide,
// * position compris entre 1 et le nombre de cellules de listInt } =>
// { résultat = une liste d'entiers contenant les cellules de listInt
// à partir de position }

        ListeChainee<Integer> sousListe = new ListeChainee<>();

        Cellule <Integer> cell = listInt.getTete();
        int i = 1;

        while (i < position) {

            cell = cell.getCelluleSuivante();
            i++;

        }

        sousListe.insereTete(cell.getInfo());

        cell = cell.getCelluleSuivante();
        i++;

        while (i <= listInt.getLongueur()) {

            sousListe.insereAtPosit((i - position) + 1, cell.getInfo());
            cell = cell.getCelluleSuivante();
            i++;

        }

        return sousListe;

    }

    public static int nbMult2(ListeChainee<Integer> listeInt) {
// { } =>
// { résultat = nombre d'entiers pairs portés par les cellules de listeInt }

        return nbMult2_wk(listeInt.getTete());

    }

    private static int nbMult2_wk(Cellule<Integer> cellCour) {
// { } =>
// { résultat = nombre d'entiers pairs portés par les cellules d'une sous-liste
// de tête cellCour }

        if (cellCour.getCelluleSuivante() != null & cellCour.getInfo() % 2 == 0) {

            return nbMult2_wk(cellCour.getCelluleSuivante()) + 1;

        } else if (cellCour.getCelluleSuivante() != null & cellCour.getInfo() % 2 == 1) {

            return nbMult2_wk(cellCour.getCelluleSuivante());

        } else if (cellCour.getCelluleSuivante() == null & cellCour.getInfo() % 2 == 0) {

            return 1;

        } else {

            return 0;

        }

    }

}
