package nancy.miage.fr.bar.model;

/**
 * Created by machin on 10/11/2017.
 */

public class Consommable {
    private int id;
    private String name;
    private TypeConsommable type;
    private double price;

    public Consommable(String name,TypeConsommable type, double price) {
        this.name = name;
        this.type=type;
        this.price = price;
    }

    public int getId() {
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

    public TypeConsommable getType() {
        return type;
    }

    public void setType(TypeConsommable type) {
        this.type = type;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
