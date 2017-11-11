package nancy.miage.fr.bar;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.Date;
import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmList;
import io.realm.RealmResults;
import nancy.miage.fr.bar.model.Consumable;
import nancy.miage.fr.bar.model.Order;
import nancy.miage.fr.bar.model.Table;
import nancy.miage.fr.bar.model.TypeConsumable;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Realm.init(getApplicationContext());

        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .initialData(initialDataTransaction).build();
        Realm.setDefaultConfiguration(realmConfiguration);

        Realm.init(getApplicationContext());
        Realm realm = Realm.getDefaultInstance();

    }

    public void order(View view){
        Intent intent= new Intent(this, SelectConsoActivity.class);
        startActivity(intent);
    }

    public void menuAdministration(View view){
        Intent intent= new Intent(this, MenuAdministration.class);
        startActivity(intent);
    }

    public void showListConsummable(View view){
        Intent intent = new Intent(this, ListConsumable.class);
        startActivity(intent);
    }

    public void showListOrder(View view){
        Intent intent = new Intent(this, ListOrder.class);
        startActivity(intent);
    }

    private Realm.Transaction initialDataTransaction = new Realm.Transaction() {
        @Override
        public void execute(@NonNull Realm realm) {
            Consumable consumable = realm.createObject(Consumable.class, UUID.randomUUID().toString());
            consumable.setName("Coca Cola");
            consumable.setType(TypeConsumable.BOISSON.name());
            consumable.setPrice(2.50);

            consumable = realm.createObject(Consumable.class, UUID.randomUUID().toString());
            consumable.setName("Saucisson");
            consumable.setType(TypeConsumable.NOURRITURE.name());
            consumable.setPrice(2.50);

            consumable = realm.createObject(Consumable.class, UUID.randomUUID().toString());
            consumable.setName("Mojito");
            consumable.setType(TypeConsumable.BOISSON.name());
            consumable.setPrice(5.50);

            consumable = realm.createObject(Consumable.class, UUID.randomUUID().toString());
            consumable.setName("Diabolo banane");
            consumable.setType(TypeConsumable.BOISSON.name());
            consumable.setPrice(1.30);

            consumable = realm.createObject(Consumable.class, UUID.randomUUID().toString());
            consumable.setName("Glace à la menthe");
            consumable.setType(TypeConsumable.DESSERT.name());
            consumable.setPrice(3.00);

            consumable = realm.createObject(Consumable.class, UUID.randomUUID().toString());
            consumable.setName("Cacahuète");
            consumable.setType(TypeConsumable.NOURRITURE.name());
            consumable.setPrice(0.90);

            consumable = realm.createObject(Consumable.class, UUID.randomUUID().toString());
            consumable.setName("Ice Tea");
            consumable.setType(TypeConsumable.BOISSON.name());
            consumable.setPrice(1.70);

            consumable = realm.createObject(Consumable.class, UUID.randomUUID().toString());
            consumable.setName("RedBull");
            consumable.setType(TypeConsumable.BOISSON.name());
            consumable.setPrice(2.70);

            consumable = realm.createObject(Consumable.class, UUID.randomUUID().toString());
            consumable.setName("Limonade");
            consumable.setType(TypeConsumable.BOISSON.name());
            consumable.setPrice(0.50);

            consumable = realm.createObject(Consumable.class, UUID.randomUUID().toString());
            consumable.setName("Cafe");
            consumable.setType(TypeConsumable.BOISSON.name());
            consumable.setPrice(1.0);

            Table table = realm.createObject(Table.class, 1);
            table.setNbPlace(4);
            table.setSalle("Haut");

            table = realm.createObject(Table.class, 2);
            table.setNbPlace(2);
            table.setSalle("Haut");

            Order order = realm.createObject(Order.class,UUID.randomUUID().toString());
            order.setNom("Martin");
            order.setPrenom("Michel");
            order.setDate(new Date());
            order.setTable(table);
            RealmResults<Consumable> consumables = realm.where(Consumable.class).findAll();
            Double total = 0.0;
            for(Consumable c : consumables){
                total+=c.getPrice();
            }
            RealmList<Consumable> listConsos = new RealmList<Consumable>();
            listConsos.addAll(consumables.subList(0, consumables.size()));
            order.setConsummables(listConsos);
            float t = Float.parseFloat(String.valueOf(total));
            order.setTotal(t);

        }
    };

}
