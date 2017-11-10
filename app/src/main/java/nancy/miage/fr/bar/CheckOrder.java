package nancy.miage.fr.bar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import nancy.miage.fr.bar.model.Table;

public class CheckOrder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_order);

        Intent intent = getIntent();
        String prenom = intent.getStringExtra("prenom");
        String nom = intent.getStringExtra("nom");
        String idTable = intent.getStringExtra("idTable");
        Table t =new Table(1,2,"Haut");



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
