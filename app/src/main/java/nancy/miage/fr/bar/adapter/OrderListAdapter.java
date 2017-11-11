package nancy.miage.fr.bar.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.List;

import nancy.miage.fr.bar.R;
import nancy.miage.fr.bar.model.Order;

/**
 * Created by machin on 11/11/2017.
 */

public class OrderListAdapter extends BaseAdapter{
    private LayoutInflater inflater;
    private List<Order> orders = Collections.emptyList();

    public OrderListAdapter(Context context) {
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return orders.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Order o = orders.get(position);

        OrderListAdapter.ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item_order, null);
            viewHolder = new OrderListAdapter.ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (OrderListAdapter.ViewHolder) convertView.getTag();
        }

        viewHolder.tvClient.setText(o.getPrenom()+" "+o.getNom());
        Log.i("idTable",String.valueOf(o.getTable().getId()));
        Log.i("t",o.getTable().getSalle());

        viewHolder.tvTable.setText(String.valueOf("N°"+o.getTable().getId())+" Salle : "+o.getTable().getSalle());
        viewHolder.tvInfo.setText(String.valueOf("Nb Place : "+o.getConsummables().size())+". Total : "+String.valueOf(o.getTotal())+" € TTC");
        SimpleDateFormat s = new SimpleDateFormat("\"dd.MM.yyyy 'à' HH:mm:ss \"");
        viewHolder.tvDate.setText("Prise le : "+s.format(o.getDate()));

        return convertView;
    }

    static class ViewHolder {
        public TextView tvClient;

        public TextView tvInfo;

        public TextView tvDate;

        public TextView tvTable;

        public ViewHolder(View view){
            tvClient = view.findViewById(R.id.tvClient);
            tvInfo = view.findViewById(R.id.tv_info);
            tvDate = view.findViewById(R.id.tv_date);
            tvTable = view.findViewById(R.id.tv_table);
        }
    }

    public void updateList(List<Order> orders){
        this.orders = orders;
        notifyDataSetChanged();
    }

}
