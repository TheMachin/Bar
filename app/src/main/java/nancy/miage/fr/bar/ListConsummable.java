package nancy.miage.fr.bar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;
import nancy.miage.fr.bar.adapter.ConsummableListAdapter;
import nancy.miage.fr.bar.model.Consommable;
import nancy.miage.fr.bar.model.TypeConsommable;

public class ListConsummable extends AppCompatActivity {

    ConsummableListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_consummable);

        Realm.init(getApplicationContext());
        Realm realm = Realm.getDefaultInstance();


        ListView lvConso = findViewById(R.id.lv);
        listAdapter = new ConsummableListAdapter(ListConsummable.this);
        lvConso.setAdapter(listAdapter);

        RealmResults<Consommable> consommables = realm.where(Consommable.class).findAll();

        listAdapter.updateList(consommables);
        listAdapter.notifyDataSetChanged();

    }
}
