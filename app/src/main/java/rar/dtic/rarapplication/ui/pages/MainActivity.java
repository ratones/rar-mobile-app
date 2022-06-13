package rar.dtic.rarapplication.ui.pages;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import rar.dtic.rarapplication.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FloatingActionButton addVeh = findViewById(R.id.floatingActionButton);
        addVeh.setOnClickListener(this);
        CardView vehCardMenu = findViewById(R.id.listVehMenuAction);
        vehCardMenu.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.app_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case android.R.id.home:
                finish();
                return true;
            case R.id.action_settings:
                System.out.println("Preferences hit!");
                Intent intent = new Intent(this, PreferencesActivity.class);
                startActivity(intent);
                break;
            case R.id.user_menu:
                System.out.println("User menu hit");
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.floatingActionButton:
                Intent intent = new Intent(this, AddVehicleActivity.class);
                startActivity(intent);
                break;
            case R.id.listVehMenuAction:
                Intent listVehicles = new Intent(this, VehiclesActivity.class);
                startActivity(listVehicles);
//                Toast.makeText(this, "Clicked Menu List", Toast.LENGTH_SHORT).show();
                break;
        }

    }
}