package nancy.miage.fr.bar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

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
        EditText id = findViewById(R.id.editNT);
        EditText nbPlace = findViewById(R.id.editNbPlace);
        EditText salle = findViewById(R.id.editSalle);

        Table t = new Table(Integer.getInteger(id.getText().toString()),Integer.getInteger(nbPlace.getText().toString()),salle.getText().toString());



    }

}
