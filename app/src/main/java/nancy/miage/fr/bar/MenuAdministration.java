package nancy.miage.fr.bar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuAdministration extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_administration);
    }

    public void showListConsummable(View view){
        Intent intent = new Intent(this, ListConsumable.class);
        startActivity(intent);
    }

    public void showListTable(View view){
        Intent intent = new Intent(this, ListTable.class);
        startActivity(intent);
    }

    public void formTable(View view){
        Intent intent = new Intent(this, FormTable.class);
        startActivity(intent);
    }

    public void formConsommable(View view){
        Intent intent = new Intent(this, FormConsumable.class);
        startActivity(intent);
    }

    public void updatePrice(View view){
        Intent intent = new Intent(this, PriceConsumable.class);
        startActivity(intent);
    }

}
