package nancy.miage.fr.bar;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import io.realm.Realm;
import io.realm.RealmResults;
import nancy.miage.fr.bar.adapter.ConsumableListAdapter;
import nancy.miage.fr.bar.adapter.ConsumableSelectableListAdapter;
import nancy.miage.fr.bar.model.Consumable;

public class SelectConsoActivity extends AppCompatActivity {
    ConsumableSelectableListAdapter listAdapter;

    RealmResults<Consumable> consumables;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_consumable);

        setTitle("Select your conso");

        Realm realm = Realm.getDefaultInstance();

        ListView lvConso = findViewById(R.id.lv);
        listAdapter = new ConsumableSelectableListAdapter(SelectConsoActivity.this);
        lvConso.setAdapter(listAdapter);

        consumables = realm.where(Consumable.class).findAll();
        listAdapter.updateList(consumables);
    }
}
