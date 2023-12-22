import java.util.ArrayList;
import java.util.Arrays;

public class Pollution {

    public static void main(String[] args) {

        ArrayList<String> semestre1 = new ArrayList<>(Arrays.asList("janvier", "février", "mars", "avril", "mai", "juin"));
        ArrayList<String> semestre2 = new ArrayList<>(Arrays.asList("juillet", "août", "septembre", "octobre", "novembre", "décembre"));
        final float SEUIL_ALERTE = 40.0f;
        ArrayList<ReleveMensuel> bilanSem1;
        ArrayList<ReleveMensuel> bilanSem2;

        System.out.println("-------------------------------------");
        System.out.println("       Bilan 1er semestre");
        System.out.println("-------------------------------------");
        bilanSem1 = Utilitaire.bilanSem(semestre1);
        System.out.println("---------------------------------------------");
        System.out.println("  Concentration en NO2 sur le 1er semestre");
        System.out.println("---------------------------------------------");
        System.out.println("* Taux moyen : " + Utilitaire.moyConc(bilanSem1));
        System.out.println("* Nombre de mois pollués : " + Utilitaire.nbPoll(bilanSem1, SEUIL_ALERTE));
        System.out.println("* Nom du premier mois pollué : " + Utilitaire.poll1(bilanSem1, SEUIL_ALERTE));
        System.out.println("* Taux maximum relevé : " + Utilitaire.maxConc(bilanSem1));
        System.out.println("* Taux minimum relevé : " + Utilitaire.minConc(bilanSem1));
        System.out.println("* Analyse mois par mois...");
        for (int i = 0; i < bilanSem1.size(); i++) {

            System.out.println("  - " + bilanSem1.get(i) + " --> " + Utilitaire.niveauPol(bilanSem1.get(i)));

        }


        System.out.println("-------------------------------------");
        System.out.println("       Bilan 2eme semestre");
        System.out.println("-------------------------------------");
        bilanSem2 = Utilitaire.bilanSem(semestre2);
        System.out.println("---------------------------------------------");
        System.out.println("  Concentration en NO2 sur le 2eme semestre");
        System.out.println("---------------------------------------------");
        System.out.println("* Taux moyen : " + Utilitaire.moyConc(bilanSem2));
        System.out.println("* Nombre de mois pollués : " + Utilitaire.nbPoll(bilanSem2, SEUIL_ALERTE));
        System.out.println("* Nom du premier mois pollué : " + Utilitaire.poll1(bilanSem2, SEUIL_ALERTE));
        System.out.println("* Taux maximum relevé : " + Utilitaire.maxConc(bilanSem2));
        System.out.println("* Taux minimum relevé : " + Utilitaire.minConc(bilanSem2));
        System.out.println("* Analyse mois par mois...");
        for (int i = 0; i < bilanSem2.size(); i++) {

            System.out.println("  - " + bilanSem2.get(i) + " --> " + Utilitaire.niveauPol(bilanSem2.get(i)));

        }


        System.out.println("---------------------------------------------");
        System.out.println("   Comparaison entre les 2 semestres");
        System.out.println("---------------------------------------------");
        if (Utilitaire.compareReleves(bilanSem1, bilanSem2, SEUIL_ALERTE) == -1) {

            System.out.println("Augmentation de l'émission de NO2 sur le second semestre");

        } else if (Utilitaire.compareReleves(bilanSem1, bilanSem2, SEUIL_ALERTE) == 0) {

            System.out.println("Aucun changement entre les 2 semestres");

        } else {

            System.out.println("Diminution de l'émission de NO2 sur le second semestre");

        }


    }

}
