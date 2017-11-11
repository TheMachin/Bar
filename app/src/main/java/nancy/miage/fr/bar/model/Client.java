package nancy.miage.fr.bar.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by machin on 11/11/2017.
 */

public class Client extends RealmObject{
    @PrimaryKey
    private String id;
    private String nom;
    private String prenom;
    private Double totalAll;

    public String getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Double getTotalAll() {
        return totalAll;
    }

    public void setTotalAll(Double totalAll) {
        this.totalAll = totalAll;
    }
}
