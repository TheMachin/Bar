package nancy.miage.fr.bar;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import io.realm.Realm;
import nancy.miage.fr.bar.model.Table;

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

        if(editId.getText().toString().isEmpty()||nbPlace.getText().toString().isEmpty()||salle.getText().toString().isEmpty()){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Veuillez renseigner les informations")
                    .setTitle("Error");
            AlertDialog dialog = builder.create();
            dialog.show();
            return;
        }

        int id = Integer.parseInt(editId.getText().toString());
        Realm.init(getApplicationContext());
        Realm realm = Realm.getDefaultInstance();

        try{
            realm.beginTransaction();
            Table table = realm.createObject(Table.class, id);
            table.setNbPlace(Integer.parseInt(nbPlace.getText().toString()));
            table.setSalle(salle.getText().toString());
            realm.commitTransaction();
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Table ajoutée")
                    .setTitle("Succès");
            AlertDialog dialog = builder.create();
            dialog.show();
        } catch (Exception e) {
            Log.e("Realm Error", "error"+ e);
            realm.cancelTransaction();
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("La table existante")
                    .setTitle("Error");
            AlertDialog dialog = builder.create();
            dialog.show();
        }

    }

}
