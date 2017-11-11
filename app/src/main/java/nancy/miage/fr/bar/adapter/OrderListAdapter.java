package nancy.miage.fr.bar.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

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
        viewHolder.tvTable.setText(String.valueOf(o.getTable().getId())+" "+o.getTable().getSalle());
        viewHolder.tvInfo.setText(String.valueOf(o.getConsummables().size())+" "+String.valueOf(o.getTotal())+" € TTC");

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
            tvDate = view.findViewById(R.id.tv_type_c);
        }
    }

    public void updateList(List<Order> orders){
        this.orders = orders;
        notifyDataSetChanged();
    }

}
