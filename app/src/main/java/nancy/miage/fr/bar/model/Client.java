package nancy.miage.fr.bar.model;

import java.util.Date;
import java.util.List;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by machin on 10/11/2017.
 */

public class Client extends RealmObject {
    @PrimaryKey
    private String id;
    private String nom;
    private String prenom;
    private float total;
    private Date date;
    private RealmList<Consommable> consummables;
    private Table table;



    public String getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public float getTotal() {
        return total;
    }

    public Date getDate() {
        return date;
    }

    public RealmList<Consommable> getConsummables() {
        return consummables;
    }

    public Table getTable() {
        return table;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setConsummables(RealmList<Consommable> consummables) {
        this.consummables = consummables;
    }

    public void setTable(Table table) {
        this.table = table;
    }
}
