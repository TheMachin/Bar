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
import nancy.miage.fr.bar.model.Consumable;

/**
 * Created by machin on 10/11/2017.
 */

public class ConsumableListAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private List<Consumable> consumables = Collections.emptyList();

    public ConsumableListAdapter(Context context) {
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return consumables.size();
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
        Consumable c = consumables.get(position);

        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item_consumable, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.tvLibelleCnso.setText(c.getName());
        viewHolder.tvTypeConso.setText(c.getType());
        viewHolder.tvPrice.setText(String.valueOf(c.getPrice())+" € TTC");

        return convertView;
    }

    static class ViewHolder {
        public TextView tvLibelleCnso;

        public TextView tvPrice;

        public TextView tvTypeConso;

        public ViewHolder(View view){
            tvLibelleCnso = view.findViewById(R.id.tv_c_libelle);
            tvPrice = view.findViewById(R.id.tv_price);
            tvTypeConso = view.findViewById(R.id.tv_type_c);
        }
    }

    public void updateList(List<Consumable> Consumables){
        this.consumables = Consumables;
        notifyDataSetChanged();
    }

}
