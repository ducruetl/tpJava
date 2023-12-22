import java.lang.reflect.Type;

public class Utilitaire {

    public static ListeTrieeC<Integer> lCsansDoublons(ListeTrieeC<Integer> lC) {
// { lC non vide, avec potentiellement des doublons } =>
// { résultat = nouvelle liste triée croissante dont les cellules portent
// les mêmes entiers que lC, mais sans doublons }

        ListeTrieeC<Integer> listeSansDouble = new ListeTrieeC<>();
        Cellule<Integer> cellTest = lC.getTete();
        int j;

        for (int i = 1; i <= lC.getLongueur(); i++) {

            if (listeSansDouble.estVide()) {

                try {

                    listeSansDouble.insereTrie(lC.getInfoAtPosit(i));

                } catch (ExceptionMauvaisIndice e) {

                    System.out.println("Erreur indice !");

                }

            }

            else {

                j = 1;
                cellTest = listeSansDouble.getTete();

                try {

                    while (j < listeSansDouble.getLongueur() && !cellTest.getInfo().equals(lC.getInfoAtPosit(i))) {

                        j++;
                        cellTest = cellTest.getCelluleSuivante();

                    }

                    if (!cellTest.getInfo().equals(lC.getInfoAtPosit(i))) {

                        listeSansDouble.insereTrie(lC.getInfoAtPosit(i));

                    }

                } catch (ExceptionMauvaisIndice e) {

                    System.out.println("Erreur indice !");

                }



            }

        }

        return listeSansDouble;

    }

    public static boolean estDansListeC(ListeTrieeC<Integer> lC, int unEnt) {
// { lC non vide, sans doublons } =>
// { résultat = vrai s'il existe une cellule de lC portant l'entier unEnt,
// faux sinon }

        return estDansListeC_wk(lC.getTete(), unEnt);

    }

    private static boolean estDansListeC_wk(Cellule<Integer> cellCour, int unEnt) {

        if (unEnt == cellCour.getInfo()) {

            return true;

        } else if (cellCour.getCelluleSuivante() == null) {

            return false;

        } else {

            return estDansListeC_wk(cellCour.getCelluleSuivante(), unEnt);

        }

    }

    public static ListeTrieeC<Integer> union(ListeTrieeC<Integer> lC1_sdb,
ListeTrieeC<Integer> lC2_sdb) {
// { lC1_sdb et lC2_sdb non vides, sans doublons } =>
// { résultat = liste triée croissante, contenant, sans doublons,
// les entiers portés par les cellules de lC1_sdb et
// les entiers portés par les cellules de lC2_sdb }

        ListeTrieeC<Integer> listeUnion = lC1_sdb;
        Cellule<Integer> cellTest;

        

    }

}
