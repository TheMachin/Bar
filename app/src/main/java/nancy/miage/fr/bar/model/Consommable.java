package nancy.miage.fr.bar.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by machin on 10/11/2017.
 */

public class Consommable extends RealmObject{
    @PrimaryKey
    private String id;
    private String name;
    private String type;
    private double price;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void saveEnum(TypeConsommable val) {
        this.type = val.toString();
    }

    public TypeConsommable getEnum() {
        return TypeConsommable.valueOf(type);
    }

}
