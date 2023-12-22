import java.util.ArrayList;

public class PolarsEtTris {

    public static void main(String[] args) {

        ArrayList<Polar> lesPolars = CreationBib.lesPolars();

        if (Utilitaire.verifTri(lesPolars)) {

            System.out.println("Le vecteur est bien trié par titre strictement croissant.");

        } else {

            System.out.println("Le vecteur n'est pas bien trié par titre strictement croissant.");

        }

        for(int i = 0; i < lesPolars.size(); i++) {

            System.out.println(lesPolars.get(i).getTitre());

        }

        // Intermède : vérification du code de compareTo et de toString
        Polar pol1 = new Polar(2000, "AUTEUR1", "Une oeuvre");
        Polar pol2 = new Polar(2000, "AUTEUR2", "Mon oeuvre");
        Polar pol3 = new Polar(1998, "AUTEUR1", "Oeuvre sans nom");
        System.out.print("pol1 : "); System.out.println(pol1);
        System.out.print("pol2 : "); System.out.println(pol2);
        System.out.print("pol3 : "); System.out.println(pol3);
        System.out.println("* pol1 comparé à pol2 : " + pol1.compareTo(pol2));
        System.out.println("* pol1 comparé à pol1 : " + pol1.compareTo(pol1));
        System.out.println("* pol1 comparé à pol3 : " + pol1.compareTo(pol3));
        System.out.println();
        System.out.println("Le vecteur va être trié selon l'ordre auteur, année avec le tri par sélection.");
        Utilitaire.triSelect(lesPolars);

        for (int i = 0; i < lesPolars.size(); i++) {

            System.out.println(lesPolars.get(i));

        }

        lesPolars = CreationBib.lesPolars();

        System.out.println("Le vecteur va être trié selon l'ordre auteur, année avec le tri à bulles amélioré");

        Utilitaire.triBulle(lesPolars);

        for (int i = 0; i < lesPolars.size(); i++) {

            System.out.println(lesPolars.get(i));

        }

        lesPolars = CreationBib.lesPolars();

        System.out.println("Le vecteur va être trié selon l'ordre auteur, année avec le tri par insertion.");

        Utilitaire.triInsertion(lesPolars);

        for (int i = 0; i < lesPolars.size(); i++) {

            System.out.println(lesPolars.get(i));

        }

        Utilitaire.nbPolarAuteur(lesPolars);

        System.out.println("* Auteurs ayant écrit en 2016");
        System.out.println(Utilitaire.auteursDeAn(lesPolars, 2016));
        System.out.println("* Auteurs ayant écrit en 2008");
        System.out.println(Utilitaire.auteursDeAn(lesPolars, 2008));
        System.out.println("* Auteurs ayant écrit en 1975");
        System.out.println(Utilitaire.auteursDeAn(lesPolars, 1975));
        System.out.println("* Auteurs ayant écrit en 2001");
        System.out.println(Utilitaire.auteursDeAn(lesPolars, 2001));

    }

}
