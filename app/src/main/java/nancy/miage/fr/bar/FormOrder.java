package nancy.miage.fr.bar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import io.realm.Realm;
import io.realm.RealmResults;
import nancy.miage.fr.bar.model.Consommable;
import nancy.miage.fr.bar.model.Table;
import nancy.miage.fr.bar.model.TypeConsommable;

public class FormOrder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_order);

        Realm.init(getApplicationContext());
        Realm realm = Realm.getDefaultInstance();

        RealmResults<Table> tables = realm.where(Table.class).findAll();

        Spinner spinT = (Spinner) findViewById(R.id.spinTable);
        List<String> listTC = new ArrayList<String>();
        listTC.add("Table");
        for(Table t : tables){
            listTC.add(t.getId()+" Nombre de place : "+t.getNbPlace()+" Salle : "+t.getSalle());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, listTC);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinT.setAdapter(adapter);

    }

    public void confirmOrder(View view){
        Intent intent = new Intent(this,CheckOrder.class);
        EditText editPrenom = (EditText) findViewById(R.id.editPrenom);
        EditText editNom = (EditText) findViewById(R.id.editNom);
        intent.putExtra("prenom",editPrenom.getText().toString());
        intent.putExtra("nom",editNom.getText().toString());


        Spinner mySpinner=(Spinner) findViewById(R.id.spinTable);
        String text = mySpinner.getSelectedItem().toString();
        StringTokenizer tokens = new StringTokenizer(text, " ");
        String first = tokens.nextToken();

        intent.putExtra("idTable",first);
        startActivity(intent);

    }


}
