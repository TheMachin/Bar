package nancy.miage.fr.bar.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import nancy.miage.fr.bar.R;
import nancy.miage.fr.bar.model.Consumable;

/**
 * Created by machin on 10/11/2017.
 */

public class ConsumableSelectableListAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private List<Consumable> consumables = Collections.emptyList();
    private List<Integer> quantities = Collections.emptyList();

    public ConsumableSelectableListAdapter(Context context) {
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
    public View getView(final int position, View convertView, ViewGroup parent) {
        Consumable c = consumables.get(position);

        final ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item_selectable_consumable, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.tvLibelleCnso.setText(c.getName());
        viewHolder.tvTypeConso.setText(c.getType());
        viewHolder.tvPrice.setText(String.valueOf(c.getPrice())+" € TTC");

        if(quantities.size() > 0){
            Integer quantity = quantities.get(position);
            viewHolder.tvQuantity.setText(quantities.get(position)+"");
        }

        viewHolder.addQuantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantities.set(position, quantities.get(position) + 1);
                viewHolder.tvQuantity.setText(String.valueOf(quantities.get(position)));
            }
        });

        viewHolder.removeQuantity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quantities.set(position, quantities.get(position) - 1);
                viewHolder.tvQuantity.setText(String.valueOf(quantities.get(position)));
            }
        });

        return convertView;
    }

    static class ViewHolder {
        public TextView tvLibelleCnso;

        public TextView tvPrice;

        public TextView tvTypeConso;

        ImageView addQuantity;
        ImageView removeQuantity;
        TextView tvQuantity;

        public ViewHolder(View view){
            tvLibelleCnso = view.findViewById(R.id.tv_c_libelle);
            tvPrice = view.findViewById(R.id.tv_price);
            tvTypeConso = view.findViewById(R.id.tv_type_c);
            addQuantity = view.findViewById(R.id.add_quantity);
            removeQuantity = view.findViewById(R.id.remove_quantity);
            tvQuantity = view.findViewById(R.id.tv_quantity);
        }
    }

    public void updateList(List<Consumable> Consumables){
        this.consumables = Consumables;
        this.quantities = new ArrayList<>();
        for(int i=0; i<consumables.size();i++){
            this.quantities.add(0);
        }
        notifyDataSetChanged();
    }

}
