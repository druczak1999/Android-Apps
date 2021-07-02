package com.example.fiszki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Podsumowanie extends AppCompatActivity {

    TextView dobrze;
    TextView suma;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_podsumowanie);
        dobrze=findViewById(R.id.wartoscgit);
        suma=findViewById(R.id.wsumie);
        Bundle bundle=getIntent().getExtras();
        int iledobrze=bundle.getInt("ile");
        dobrze.setText(String.valueOf(iledobrze));
        suma.setText(String.valueOf(bundle.getInt("suma")));
    }
    public void back(View view){
       onBackPressed();
        }
    public void jeszczeraz(View view){

        Intent intent=new Intent(this,Fiszki.class);
        startActivity(intent);
    }
}