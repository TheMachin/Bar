package nancy.miage.fr.bar;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;
import nancy.miage.fr.bar.model.Consumable;
import nancy.miage.fr.bar.model.TypeConsumable;

public class PriceConsumable extends AppCompatActivity {

    private RealmResults<Consumable> consumables;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_price_consumable);


        Realm.init(getApplicationContext());
        Realm realm = Realm.getDefaultInstance();
        consumables = realm.where(Consumable.class).findAll();

        Spinner spinT = (Spinner) findViewById(R.id.spinConsos);
        List<String> listTC = new ArrayList<String>();
        listTC.add("Consommable");
        for(Consumable c : consumables){
            listTC.add(c.getName()+" "+c.getType());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, listTC);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinT.setAdapter(adapter);

    }

    public void updatePrice(View view){
        EditText editPrice = findViewById(R.id.editPrice);
        Spinner spin = findViewById(R.id.spinConsos);
        int position = spin.getSelectedItemPosition();
        Log.i("positiontext",String.valueOf(position));

        if(position==0){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Veuillez sélectionner un consommable")
                    .setTitle("Erreur");
            AlertDialog dialog = builder.create();
            dialog.show();
            return;
        }

        if(editPrice.getText().toString().isEmpty()||Double.parseDouble(editPrice.getText().toString())<0){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Veuillez indiquer prix >= 0")
                    .setTitle("Erreur");
            AlertDialog dialog = builder.create();
            dialog.show();
            return;
        }

        Realm.init(getApplicationContext());
        Realm realm = Realm.getDefaultInstance();
        Consumable c = consumables.get(position - 1);

        realm.beginTransaction();
        c.setPrice(Double.parseDouble(editPrice.getText().toString()));
        realm.commitTransaction();


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Le prix a bien été modifié")
                .setTitle("Succès");
        AlertDialog dialog = builder.create();
        dialog.show();

    }

}
