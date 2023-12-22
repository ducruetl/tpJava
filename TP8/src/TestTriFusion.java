import java.util.ArrayList;
import java.util.Arrays;

public class TestTriFusion {

    public static void triFusion(ArrayList<Integer> vInt, int inf, int sup) {
        // { vInt[inf..sup] non vide } => { vInt[inf..sup] trié }

        if (inf < sup) {
            int m = (inf + sup) / 2;
            triFusion(vInt, inf, m);
            triFusion(vInt, m + 1, sup);
            fusionTabGTabD(vInt, inf, m,sup);
        }

    }

    public static void fusionTabGTabD(ArrayList<Integer> vInt, int inf, int m, int sup) {
        // { inf <= sup, m = (inf+sup)/2, vInt[inf..m] trié, vInt[m+1..sup] trié }
        // => { VInt[inf..sup] trié }

        ArrayList<Integer> vTemp = new ArrayList<>();
        int i = 0;
        int j = m + 1;
        if (vInt.get(i) < vInt.get(j)) {

            while (i < m + 1) {

                vTemp.add(vInt.get(i));
                i++;

            }

        } else {

            while (j < vInt.size()) {

                vTemp.add(vInt.get(j));
                j++;

            }

        }

        if (i == m + 1) {


            while (j < vInt.size()) {

                i = 0;

                while (i < vTemp.size() && vInt.get(j) < vTemp.get(i)) {

                    i++;

                }

                if (i == vTemp.size()) {

                    vTemp.add(vTemp.size() - 1, vInt.get(j));

                } else {

                    vTemp.add(i, vInt.get(j));

                }

                j++;

            }

        }

    }

    public static void main(String[] args) {

        ArrayList<Integer> vInt = new ArrayList<>(Arrays.asList(10, 12, 7, 9, 1, 4, 4, 8, 5, 2, 3));
        System.out.println("vInt : " + vInt);
        triFusion(vInt, 0, vInt.size() - 1);
        System.out.println("vInt trié : " + vInt);

    }

}