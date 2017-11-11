package nancy.miage.fr.bar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void order(View view){
        Intent intent= new Intent(this, FormOrder.class);
        startActivity(intent);
    }

    public void menuAdministration(View view){
        Intent intent= new Intent(this, MenuAdministration.class);
        startActivity(intent);
    }

    public void showListConsummable(View view){
        Intent intent = new Intent(this, ListConsumable.class);
        startActivity(intent);
    }

}
