public class Utilitaire {

    public static ListeTrieeC<Integer> lCsansDoublons(ListeTrieeC<Integer> lC) {
// { lC non vide, avec potentiellement des doublons } =>
// { résultat = nouvelle liste triée croissante dont les cellules portent
// les mêmes entiers que lC, mais sans doublons }

        ListeTrieeC<Integer> listeSansDouble = new ListeTrieeC<>();
        Cellule<Integer> cellTest;
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

        ListeTrieeC<Integer> listeUnion = new ListeTrieeC<>();
        for (int x = 1; x <= lC1_sdb.getLongueur(); x++) {

            try {

                listeUnion.insereTrie(lC1_sdb.getInfoAtPosit(x));

            } catch (ExceptionMauvaisIndice e) {

                System.out.println("Mauvais indice !");

            }

        }
        Cellule<Integer> cellTest = lC2_sdb.getTete();
        Cellule<Integer> cellUnion;
        int j;

        for (int i = 1; i <= lC2_sdb.getLongueur(); i++) {

            j = 1;
            cellUnion = listeUnion.getTete();

            while (j < listeUnion.getLongueur() & !cellTest.getInfo().equals(cellUnion.getInfo())) {

                cellUnion = cellUnion.getCelluleSuivante();
                j++;

            }

            if (!cellTest.getInfo().equals(cellUnion.getInfo())) {

                try {

                    listeUnion.insereTrie(lC2_sdb.getInfoAtPosit(i));

                } catch (ExceptionMauvaisIndice e) {

                    System.out.println("Mauvais indice !");

                }
            }

            cellTest = cellTest.getCelluleSuivante();

        }

        return listeUnion;

    }

    public static ListeTrieeC<Integer> intersect(ListeTrieeC<Integer> lC1_sdb,
ListeTrieeC<Integer> lC2_sdb) {
// { lC1_sdb et lC2_sdb non vides, sans doublons } =>
// { résultat = liste triée croissante, contenant, sans doublons,
// les entiers portés par les cellules de lC1_sdb qui sont
// égaux à ceux portés par les cellules de lC2_sdb }

        ListeTrieeC<Integer> listeInter = new ListeTrieeC<>();
        Cellule<Integer> cellTest = lC2_sdb.getTete();
        Cellule<Integer> cellInter;
        int j;

        for (int i = 1; i <= lC2_sdb.getLongueur(); i++) {

            j = 1;
            cellInter = lC1_sdb.getTete();

            while (j < lC1_sdb.getLongueur() & !cellTest.getInfo().equals(cellInter.getInfo())) {

                cellInter = cellInter.getCelluleSuivante();
                j++;

            }

            if (cellTest.getInfo().equals(cellInter.getInfo()) & listeInter.estVide() || cellTest.getInfo().equals(cellInter.getInfo()) && !estDansListeC(listeInter, cellTest.getInfo())) {

                    listeInter.insereTrie(cellTest.getInfo());

            }

            cellTest = cellTest.getCelluleSuivante();

        }

        return listeInter;

    }

}
