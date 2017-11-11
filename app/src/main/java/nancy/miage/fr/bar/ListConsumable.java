package nancy.miage.fr.bar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import io.realm.Realm;
import io.realm.RealmResults;
import nancy.miage.fr.bar.adapter.ConsumableListAdapter;
import nancy.miage.fr.bar.model.Consumable;

public class ListConsumable extends AppCompatActivity {

    ConsumableListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_consumable);

        Realm.init(getApplicationContext());
        Realm realm = Realm.getDefaultInstance();


        ListView lvConso = findViewById(R.id.lv);
        listAdapter = new ConsumableListAdapter(ListConsumable.this);
        lvConso.setAdapter(listAdapter);

        RealmResults<Consumable> Consumables = realm.where(Consumable.class).findAll();

        listAdapter.updateList(Consumables);
        listAdapter.notifyDataSetChanged();

    }
}
