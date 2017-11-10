package nancy.miage.fr.bar.model;

import java.util.Date;
import java.util.List;

/**
 * Created by machin on 10/11/2017.
 */

public class Client {
    private int id;
    private String nom;
    private String prenom;
    private float total;
    private Date date;
    private List<Consommable> consummables;
    private Table table;

    public Client(String nom, String prenom, float total, Date date, List<Consommable> consummables, Table table) {
        this.nom = nom;
        this.prenom = prenom;
        this.total = total;
        this.date = date;
        this.consummables = consummables;
        this.table = table;
    }

    public int getId() {
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

    public List<Consommable> getConsummables() {
        return consummables;
    }

    public Table getTable() {
        return table;
    }
}
