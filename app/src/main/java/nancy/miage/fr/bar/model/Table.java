package nancy.miage.fr.bar.model;

/**
 * Created by machin on 10/11/2017.
 */

public class Table {
    private int id;
    private int nbPlace;
    private String salle;

    public Table(int id, int nbPlace, String salle) {
        this.id=id;
        this.nbPlace = nbPlace;
        this.salle = salle;
    }

    public int getId() {
        return id;
    }

    public int getNbPlace() {
        return nbPlace;
    }

    public void setNbPlace(int nbPlace) {
        this.nbPlace = nbPlace;
    }

    public String getSalle() {
        return salle;
    }

    public void setSalle(String salle) {
        this.salle = salle;
    }
}
