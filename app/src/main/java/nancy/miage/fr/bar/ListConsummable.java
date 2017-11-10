package nancy.miage.fr.bar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import nancy.miage.fr.bar.adapter.ConsummableListAdapter;
import nancy.miage.fr.bar.model.Consommable;
import nancy.miage.fr.bar.model.TypeConsommable;

public class ListConsummable extends AppCompatActivity {

    ConsummableListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_consummable);

        //Realm.init(getApplicationContext());

        ListView lvConso = findViewById(R.id.lv);
        listAdapter = new ConsummableListAdapter(ListConsummable.this);
        lvConso.setAdapter(listAdapter);

        List<Consommable> consommables = new ArrayList<Consommable>();


        Consommable c = new Consommable("Eau", TypeConsommable.BOISSON,1.0);
        Consommable c2 = new Consommable("Café", TypeConsommable.BOISSON,1.0);
        Consommable c3 = new Consommable("Tarte flambé", TypeConsommable.APERITIF,10.0);

        consommables.add(c);
        consommables.add(c2);
        consommables.add(c3);
        listAdapter.updateList(consommables);
        listAdapter.notifyDataSetChanged();

        /*Realm realm = Realm.getDefaultInstance();

        RealmResults<Consommable> offres = realm.where(Offre.class).findAll();
        listAdapter.updateList(offres);

        realm.executeTransactionAsync(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Entreprise entreprise = realm.createObject(Entreprise.class, UUID.randomUUID().toString());
                entreprise.setNom("CapGemini");
                entreprise.setAdresse("6 avenue Foch");
                entreprise.setEmail("capge@gmail.com");
                entreprise.setTelephone("038724457");

                Offre offre = realm.createObject(Offre.class, UUID.randomUUID().toString());
                offre.setLibelle("Developpeur Android");
                offre.setDateMiseEnLigne(new Date());
                offre.setTypeContrat("Stage");
                offre.setEntreprise(entreprise);
                offre.setActif(true);
            }
        }, new Realm.Transaction.OnSuccess() {
            @Override
            public void onSuccess() {
                if(listAdapter!=null){
                    listAdapter.notifyDataSetChanged();
                }
            }
        });*/

    }
}
