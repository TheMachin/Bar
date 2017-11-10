package nancy.miage.fr.bar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import io.realm.Realm;
import nancy.miage.fr.bar.model.Consommable;
import nancy.miage.fr.bar.model.Table;
import nancy.miage.fr.bar.model.TypeConsommable;

public class FormTable extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_table);
    }

    public void add(View view){
        EditText editId = findViewById(R.id.editNT);
        EditText nbPlace = findViewById(R.id.editNbPlace);
        EditText salle = findViewById(R.id.editSalle);
        Log.i("id",editId.getText().toString());
        int id = Integer.parseInt(editId.getText().toString());
        //Table t = new Table(Integer.getInteger(id.getText().toString()),Integer.getInteger(nbPlace.getText().toString()),salle.getText().toString());
        Realm.init(getApplicationContext());
        Realm realm = Realm.getDefaultInstance();


        realm.beginTransaction();
        Table table = realm.createObject(Table.class, id);
        table.setNbPlace(Integer.parseInt(nbPlace.getText().toString()));
        table.setSalle(salle.getText().toString());
        realm.commitTransaction();

    }

}
