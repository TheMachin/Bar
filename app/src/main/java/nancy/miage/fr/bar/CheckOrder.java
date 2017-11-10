package nancy.miage.fr.bar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import io.realm.Realm;
import nancy.miage.fr.bar.model.Table;

public class CheckOrder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_order);

        Realm.init(getApplicationContext());
        Realm realm = Realm.getDefaultInstance();

        Intent intent = getIntent();
        String prenom = intent.getStringExtra("prenom");
        String nom = intent.getStringExtra("nom");
        String idTable = intent.getStringExtra("idTable");

        Table t = realm.where(Table.class)
                .equalTo("id",idTable)
                .findFirst();

        TextView txtP = findViewById(R.id.txtPrenom);
        TextView txtN = findViewById(R.id.txtNom);
        TextView txtT = findViewById(R.id.txtNoTable);
        TextView txtSalle = findViewById(R.id.txtSalle);
        txtP.setText("Prénom : "+prenom);
        txtN.setText("Nom : "+nom);
        txtT.setText("N° :"+t.getId()+" Nb place : "+t.getNbPlace());
        txtSalle.setText("Salle : "+t.getSalle());

    }
}
