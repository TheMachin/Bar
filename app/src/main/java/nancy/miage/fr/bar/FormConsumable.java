package nancy.miage.fr.bar;

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
        EditText nom = findViewById(R.id.editNC);
        EditText prix = findViewById(R.id.editPrix);
        Spinner mySpinner=(Spinner) findViewById(R.id.spinTC);
        String type = mySpinner.getSelectedItem().toString();

        Realm.init(getApplicationContext());
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        Consumable c = realm.createObject(Consumable.class, UUID.randomUUID().toString());
        c.setName(nom.getText().toString());
        c.setPrice(Double.parseDouble(prix.getText().toString()));
        c.setType(type);
        realm.commitTransaction();

    }
}
