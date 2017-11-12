package nancy.miage.fr.bar;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import io.realm.Realm;
import io.realm.RealmResults;
import nancy.miage.fr.bar.model.Consumable;
import nancy.miage.fr.bar.model.TypeConsumable;

public class FormConsumable extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_consumable);


        Spinner spinT = (Spinner) findViewById(R.id.spinTC);
        List<String> listTC = new ArrayList<String>();
        listTC.add("Type de consommable");
        for(TypeConsumable t : TypeConsumable.values()){
            listTC.add(t.name());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, listTC);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinT.setAdapter(adapter);

    }

    public void add(View view){
        EditText editName = findViewById(R.id.editNC);
        EditText editPrice = findViewById(R.id.editPrix);
        Spinner mySpinner=(Spinner) findViewById(R.id.spinTC);
        String type = mySpinner.getSelectedItem().toString();
        String name = editName.getText().toString();
        String price = editPrice.getText().toString();

        //Vérifier si les infos ont été remplies
        if(name.isEmpty()||price.isEmpty()||Double.parseDouble(price)<0||type.equals("Type de consommable")) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Veuillez indiquer le nom du consommable \n Veuillez sélectionner un type consommable \n Veuillez indiquer prix >= 0")
                    .setTitle("Erreur");
            AlertDialog dialog = builder.create();
            dialog.show();
            return;
        }

        Realm.init(getApplicationContext());
        Realm realm = Realm.getDefaultInstance();

        realm.beginTransaction();
        Consumable c = realm.createObject(Consumable.class, UUID.randomUUID().toString());
        c.setName(name);
        c.setPrice(Double.parseDouble(price));
        c.setType(type);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Consommable ajouté")
                .setTitle("Succès");
        AlertDialog dialog = builder.create();
        dialog.show();

        realm.commitTransaction();

    }
}
