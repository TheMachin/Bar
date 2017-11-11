package nancy.miage.fr.bar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import io.realm.Realm;
import io.realm.RealmResults;
import nancy.miage.fr.bar.adapter.TableListAdapter;
import nancy.miage.fr.bar.model.Table;

public class ListTable extends AppCompatActivity {

    TableListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_table);

        Realm.init(getApplicationContext());
        Realm realm = Realm.getDefaultInstance();

        ListView lv = findViewById(R.id.lv);
        listAdapter = new TableListAdapter(ListTable.this);
        lv.setAdapter(listAdapter);

        RealmResults<Table> tables = realm.where(Table.class).findAll();
        Log.i("size",String.valueOf(tables.size()));
        listAdapter.updateList(tables);
        listAdapter.notifyDataSetChanged();

    }
}
