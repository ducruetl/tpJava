public class Instrument implements Comparable<Instrument>{

    private String nomInstrument;
    private int nbDispo;

    public Instrument(String nomInstrument, int nbDispo) {
        this.nomInstrument = nomInstrument;
        this.nbDispo = nbDispo;
    }

    public String getNomInstrument(){

        return this.nomInstrument;

    }

    public int getNbDispo(){

        return this.nbDispo;

    }

    public void renduExemplaires(int nbEx) {
        // { } => { nbDispo a été mis à jour }

        this.nbDispo = this.nbDispo + nbEx;

    }

    public void retraitExemplaires(int nbEx) throws ExceptionDefautDispo {
        // { } => { nbDispo a été mis à jour si et seulement si sa valeur était
        // supérieure à nbEx, sinon, l'exception ExceptionDefautDispo
        // est levée }

        if (nbEx <= this.nbDispo) {

            this.nbDispo = this.nbDispo - nbEx;

        } else {

            try {

                throw new ExceptionDefautDispo();

            } catch (ExceptionDefautDispo e) {

                System.out.println("Pas assez d'exemplaires disponibles.");

            }

        }

    }

    @Override
    public String toString() {

        return "(" + this.nomInstrument + ", " + this.nbDispo + ")";

    }

    @Override
    public int compareTo(Instrument i) {

        if (this.nomInstrument.compareTo(i.getNomInstrument()) >= 1) {

            return 1;

        } else if (this.nomInstrument.compareTo(i.getNomInstrument()) == 0) {

            return 0;

        } else {

            return -1;

        }

    }

}
