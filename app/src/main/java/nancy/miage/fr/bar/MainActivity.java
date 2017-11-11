package nancy.miage.fr.bar;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import nancy.miage.fr.bar.model.Consumable;
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
        }
    };

}
