package nancy.miage.fr.bar.model;

import java.util.Date;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by machin on 10/11/2017.
 */

public class Order extends RealmObject {
    @PrimaryKey
    private String id;
    private float total;
    private Date date;
    private RealmList<Consumable> consummables;
    private Table table;
    private Client client;



    public String getId() {
        return id;
    }

    public float getTotal() {
        return total;
    }

    public Date getDate() {
        return date;
    }

    public RealmList<Consumable> getConsummables() {
        return consummables;
    }

    public Table getTable() {
        return table;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setConsummables(RealmList<Consumable> consummables) {
        this.consummables = consummables;
    }

    public void setTable(Table table) {
        this.table = table;
    }
}
