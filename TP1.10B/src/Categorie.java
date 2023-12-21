public class Categorie implements Comparable<Categorie> {

    private String nomCat;
    private ListeTrieeC<Instrument> lInstruments;

    public Categorie(String nomCat, ListeTrieeC<Instrument> lInstruments) {

        this.nomCat = nomCat;
        this.lInstruments = lInstruments;

    }

    public String getNomCat() {

        return this.nomCat;

    }

    public ListeTrieeC<Instrument> GetLInstruments() {

        return this.lInstruments;

    }

    public void afficheCat() {

        System.out.print(this.nomCat + " (" + this.lInstruments.getLongueur()+") : ");
        lInstruments.afficheGD();

    }

    public boolean exixstInsDispo() {
        // { lInstruments non vide } =>
        // { résultat = vrai si au moins un instrument de lInstruments peut être prêté }

        boolean dispo = false;
        int i = 1;

        while (i <= this.lInstruments.getLongueur() && !dispo) {

            try {

                if (lInstruments.getInfoAtPosit(i).getNbDispo() > 0) {

                    dispo = true;

                }

            } catch (ExceptionMauvaisIndice e) {

                System.out.println("Mauvais indice.");

            }

            i++;

        }

        return dispo;

    }

    @Override
    public int compareTo(Categorie c) {

        if (this.nomCat.compareTo(c.getNomCat()) >= 1) {

            return 1;

        } else if (this.nomCat.compareTo(c.getNomCat()) == 0) {

            return 0;

        } else {

            return -1;

        }

    }

}
