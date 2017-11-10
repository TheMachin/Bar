package nancy.miage.fr.bar.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by machin on 10/11/2017.
 */

public class Table extends RealmObject {
    @PrimaryKey
    private int id;
    private int nbPlace;
    private String salle;

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

    public void setId(int id) {
        this.id = id;
    }
}
