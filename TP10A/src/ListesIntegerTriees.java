import java.util.ArrayList;
import java.util.Arrays;

public class ListesIntegerTriees {

    public static void main(String[] args) {

        ArrayList<Integer> vIntRandom1 = new ArrayList<>();
        ArrayList<Integer> vIntRandom2 = new ArrayList<>();

        ListeTrieeC<Integer> listIntC1 = new ListeTrieeC<>();
        ListeTrieeC<Integer> listIntC2 = new ListeTrieeC<>();

        ListeTrieeC<Integer> listIntC1_sdb = new ListeTrieeC<>();
        ListeTrieeC<Integer> listIntC2_sdb = new ListeTrieeC<>();

        ArrayList<Integer> vIntTest = new ArrayList<>(Arrays.asList(31, 1, 46, 35, 5, 32,
14, 49, 19, 28, 2, 30, 32, 12, 20));
        ListeTrieeD<Integer> listIntD = new ListeTrieeD<>();

        for (int i = 0; i < vIntTest.size(); i++) {

            listIntD.insereTrie(vIntTest.get(i));

        }

        listIntD.afficheGD();

        int i;

        while (vIntRandom1.size() < 20) {

            i = (int) (Math.random()*40);
            vIntRandom1.add(i);
            listIntC1.insereTrie(i);

        }

        while (vIntRandom2.size() < 15) {

            i = (int) (Math.random()*40);
            vIntRandom2.add(i);
            listIntC2.insereTrie(i);

        }

        System.out.println("vIntRandom1 : " + vIntRandom1);
        System.out.println("vIntRandom2 : " + vIntRandom2);
        System.out.println();
        System.out.print("listIntC1 : ");
        listIntC1.afficheGD();
        System.out.print("listIntC2 : ");
        listIntC2.afficheGD();
        System.out.println();

        listIntC1_sdb = Utilitaire.lCsansDoublons(listIntC1);
        listIntC2_sdb = Utilitaire.lCsansDoublons(listIntC2);

        System.out.print("listIntC1 sans doublons : ");
        listIntC1_sdb.afficheGD();
        System.out.print("listIntC2 sans doublons : ");
        listIntC2_sdb.afficheGD();



    }

}
