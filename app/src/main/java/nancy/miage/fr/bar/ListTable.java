package nancy.miage.fr.bar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import nancy.miage.fr.bar.adapter.ConsummableListAdapter;
import nancy.miage.fr.bar.adapter.TableListAdapter;
import nancy.miage.fr.bar.model.Consommable;
import nancy.miage.fr.bar.model.Table;
import nancy.miage.fr.bar.model.TypeConsommable;

public class ListTable extends AppCompatActivity {

    TableListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_table);


        ListView lv = findViewById(R.id.lv);
        listAdapter = new TableListAdapter(ListTable.this);
        lv.setAdapter(listAdapter);

        List<Table> tables = new ArrayList<Table>();

        tables.add(new Table(1,2,"Haut"));
        tables.add(new Table(2,4,"Bas"));
        tables.add(new Table(3,8,"Cours"));
        tables.add(new Table(4,2,"Haut"));

        listAdapter.updateList(tables);
        listAdapter.notifyDataSetChanged();

    }
}
