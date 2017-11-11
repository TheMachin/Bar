package nancy.miage.fr.bar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.Sort;
import nancy.miage.fr.bar.adapter.OrderListAdapter;
import nancy.miage.fr.bar.adapter.TableListAdapter;
import nancy.miage.fr.bar.model.Order;
import nancy.miage.fr.bar.model.Table;

public class ListOrder extends AppCompatActivity {

    OrderListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_order);
        Realm.init(getApplicationContext());
        Realm realm = Realm.getDefaultInstance();

        ListView lv = findViewById(R.id.lv);
        listAdapter = new OrderListAdapter(ListOrder.this);
        lv.setAdapter(listAdapter);

        RealmResults<Order> orders = realm.where(Order.class).findAll();
        orders.sort("date", Sort.DESCENDING);
        Log.i("size",String.valueOf(orders.size()));
        listAdapter.updateList(orders);
        listAdapter.notifyDataSetChanged();

    }
}
