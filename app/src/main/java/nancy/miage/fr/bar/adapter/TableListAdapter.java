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
import nancy.miage.fr.bar.model.Consommable;
import nancy.miage.fr.bar.model.Table;

/**
 * Created by machin on 10/11/2017.
 */

public class TableListAdapter extends BaseAdapter {

    private LayoutInflater inflater;
    private List<Table> tables = Collections.emptyList();

    public TableListAdapter(Context context) {
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return tables.size();
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
        Table t = tables.get(position);

        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item_table, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.tvIdTable.setText("N° "+String.valueOf(t.getId()));
        viewHolder.tvSalle.setText("Nb Place : "+String.valueOf(t.getNbPlace()));
        viewHolder.tvNbPlace.setText("Salle : "+t.getSalle());

        return convertView;
    }

    static class ViewHolder {
        public TextView tvIdTable;

        public TextView tvNbPlace;

        public TextView tvSalle;

        public ViewHolder(View view){
            tvIdTable = view.findViewById(R.id.tv_no_table);
            tvNbPlace = view.findViewById(R.id.tv_nbPlace);
            tvSalle = view.findViewById(R.id.tv_salle);
        }
    }

    public void updateList(List<Table> tables){
        this.tables = tables;
        notifyDataSetChanged();
    }

}
