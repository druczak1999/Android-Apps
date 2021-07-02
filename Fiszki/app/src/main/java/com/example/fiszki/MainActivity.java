package com.example.fiszki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    String[] języki={"Wybierz język","Angielski","Niemiecki","Hiszpański"};
    int posSpinner;
    Spinner opcje;
    SpinnerAdapter sadapter;
    int[] images={R.drawable.poland,R.drawable.grbrit,R.drawable.germany,R.drawable.spain};
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DB=new DBHelper(this);
        opcje= (Spinner) findViewById(R.id.spinner);
        sadapter=new SpinnerAdapter(this,języki,images);
        if(opcje!= null){
            opcje.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);

            opcje.setAdapter(sadapter);

        }

        final Intent infoint=new Intent(this,MainSlide.class);
        FloatingActionButton but= (FloatingActionButton) findViewById(R.id.floatingActionButton);
        but.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                startActivity(infoint);
            }
        });

        Button osobyButA=findViewById(R.id.buttonOs);
        Button zwierzetaButt=findViewById(R.id.buttonZw);
        Button liczbyButt=findViewById(R.id.buttonLi);
        Button jedzenieButt=findViewById(R.id.buttonJe);
        Button czescicButt=findViewById(R.id.buttonCzcz);
        Button sportButt=findViewById(R.id.buttonSp);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.info:
                Intent intent = new Intent(this,Info.class);
                startActivity(intent);
                return true;
            case R.id.progres:
                Intent intent2 = new Intent(this,Progres.class);
                startActivity(intent2);
                return true;
            case R.id.zamknij:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
    public void uruchomslide(View view){
        final Intent intencja=new Intent(this, MainSlide.class);
        startActivity(intencja);
    }
    public void uruchomsFragOs(View view){
        int[]val;
        if(opcje.getSelectedItemPosition()==1) {
            Bundle przycisk=new Bundle();
            val= new int[]{1, 1};
            przycisk.putIntArray("przycisk",val);
            final Intent intencja=new Intent(this, Fiszki.class);
            intencja.putExtras(przycisk);
            startActivity(intencja);
        }
        if (opcje.getSelectedItemPosition()==2){
            Bundle przycisk=new Bundle();
            val= new int[]{1, 2};
            przycisk.putIntArray("przycisk",val);
            final Intent intencja=new Intent(this, Fiszki.class);
            intencja.putExtras(przycisk);
            startActivity(intencja);
        }
        if (opcje.getSelectedItemPosition()==3){
            Bundle przycisk=new Bundle();
            val= new int[]{1, 3};
            przycisk.putIntArray("przycisk",val);
            final Intent intencja=new Intent(this, Fiszki.class);
            intencja.putExtras(przycisk);
            startActivity(intencja);
        }
    }
    public void uruchomsFragLiczby(View view){

        int[]val;
        if(opcje.getSelectedItemPosition()==1) {
            Bundle przycisk=new Bundle();
            val= new int[]{2, 1};
            przycisk.putIntArray("przycisk",val);
            final Intent intencja=new Intent(this, Fiszki.class);
            intencja.putExtras(przycisk);
            startActivity(intencja);
        }
        if (opcje.getSelectedItemPosition()==2){
            Bundle przycisk=new Bundle();
            val= new int[]{2, 2};
            przycisk.putIntArray("przycisk",val);
            final Intent intencja=new Intent(this, Fiszki.class);
            intencja.putExtras(przycisk);
            startActivity(intencja);
        }
        if (opcje.getSelectedItemPosition()==3){
            Bundle przycisk=new Bundle();
            val= new int[]{2, 3};
            przycisk.putIntArray("przycisk",val);
            final Intent intencja=new Intent(this, Fiszki.class);
            intencja.putExtras(przycisk);
            startActivity(intencja);
        }
    }
    public void uruchomsFragZwierzeta(View view){

        int[]val;
        if(opcje.getSelectedItemPosition()==1) {
            Bundle przycisk=new Bundle();
            val= new int[]{3, 1};
            przycisk.putIntArray("przycisk",val);
            final Intent intencja=new Intent(this, Fiszki.class);
            intencja.putExtras(przycisk);
            startActivity(intencja);
        }
        if (opcje.getSelectedItemPosition()==2){
            Bundle przycisk=new Bundle();
            val= new int[]{3, 2};
            przycisk.putIntArray("przycisk",val);
            final Intent intencja=new Intent(this, Fiszki.class);
            intencja.putExtras(przycisk);
            startActivity(intencja);
        }
        if (opcje.getSelectedItemPosition()==3){
            Bundle przycisk=new Bundle();
            val= new int[]{3, 3};
            przycisk.putIntArray("przycisk",val);
            final Intent intencja=new Intent(this, Fiszki.class);
            intencja.putExtras(przycisk);
            startActivity(intencja);
        }
    }
    public void uruchomsFragJedzenie(View view){

        int[]val;
        if(opcje.getSelectedItemPosition()==1) {
            Bundle przycisk=new Bundle();
            val= new int[]{4, 1};
            przycisk.putIntArray("przycisk",val);
            final Intent intencja=new Intent(this, Fiszki.class);
            intencja.putExtras(przycisk);
            startActivity(intencja);
        }
        if (opcje.getSelectedItemPosition()==2){
            Bundle przycisk=new Bundle();
            val= new int[]{4, 2};
            przycisk.putIntArray("przycisk",val);
            final Intent intencja=new Intent(this, Fiszki.class);
            intencja.putExtras(przycisk);
            startActivity(intencja);
        }
        if (opcje.getSelectedItemPosition()==3){
            Bundle przycisk=new Bundle();
            val= new int[]{4, 3};
            przycisk.putIntArray("przycisk",val);
            final Intent intencja=new Intent(this, Fiszki.class);
            intencja.putExtras(przycisk);
            startActivity(intencja);
        }
    }
    public void uruchomsFragCialo(View view){

        int[]val;
        if(opcje.getSelectedItemPosition()==1) {
            Bundle przycisk=new Bundle();
            val= new int[]{5, 1};
            przycisk.putIntArray("przycisk",val);
            final Intent intencja=new Intent(this, Fiszki.class);
            intencja.putExtras(przycisk);
            startActivity(intencja);
        }
        if (opcje.getSelectedItemPosition()==2){
            Bundle przycisk=new Bundle();
            val= new int[]{5, 2};
            przycisk.putIntArray("przycisk",val);
            final Intent intencja=new Intent(this, Fiszki.class);
            intencja.putExtras(przycisk);
            startActivity(intencja);
        }
        if (opcje.getSelectedItemPosition()==3){
            Bundle przycisk=new Bundle();
            val= new int[]{5, 3};
            przycisk.putIntArray("przycisk",val);
            final Intent intencja=new Intent(this, Fiszki.class);
            intencja.putExtras(przycisk);
            startActivity(intencja);
        }
    }
    public void uruchomsFragSport(View view){

        int[]val;
        if(opcje.getSelectedItemPosition()==1) {
            Bundle przycisk=new Bundle();
            val= new int[]{6, 1};
            przycisk.putIntArray("przycisk",val);
            final Intent intencja=new Intent(this, Fiszki.class);
            intencja.putExtras(przycisk);
            startActivity(intencja);
        }
        if (opcje.getSelectedItemPosition()==2){
            Bundle przycisk=new Bundle();
            val= new int[]{6, 2};
            przycisk.putIntArray("przycisk",val);
            final Intent intencja=new Intent(this, Fiszki.class);
            intencja.putExtras(przycisk);
            startActivity(intencja);
        }
        if (opcje.getSelectedItemPosition()==3){
            Bundle przycisk=new Bundle();
            val= new int[]{6, 3};
            przycisk.putIntArray("przycisk",val);
            final Intent intencja=new Intent(this, Fiszki.class);
            intencja.putExtras(przycisk);
            startActivity(intencja);
        }
    }
    public void ocen(View view){
        Toast.makeText(this,"Oceń aplikację w sklepie Google play",Toast.LENGTH_SHORT).show();
    }
}