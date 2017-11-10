package nancy.miage.fr.bar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuGestion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_gestion);
    }

    public void showListConsummable(View view){
        Intent intent = new Intent(this, ListConsummable.class);
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
        Intent intent = new Intent(this, FormConsommable.class);
        startActivity(intent);
    }

}
