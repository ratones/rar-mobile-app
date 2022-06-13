package rar.dtic.rarapplication.ui.pages;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.MenuItem;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import rar.dtic.rarapplication.R;

public class PreferencesActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener, TextWatcher {

    private Switch switchEmailNotif;
    private TextView emailTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        switchEmailNotif = (Switch) findViewById(R.id.switch1);
        emailTextView = (TextView) findViewById(R.id.txtEmailNotif);
        emailTextView.addTextChangedListener(this);
        switchEmailNotif.setOnCheckedChangeListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case android.R.id.home:
                finish();
                return true;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        switch (compoundButton.getId()){
            case R.id.switch1:
                if(b){
                    emailTextView.setVisibility(View.VISIBLE);
                }else{
                    emailTextView.setVisibility(View.GONE);
                }
                break;
        }
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        boolean isValid = (!TextUtils.isEmpty(charSequence) && Patterns.EMAIL_ADDRESS.matcher(charSequence).matches());
        if(!isValid){
            emailTextView.setError("Invalid email address!");
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}