package com.example.fiszki;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Progres extends AppCompatActivity {

    ListView list1,list2,list3;
    public Integer[] obrazki={R.drawable.baseline_perm_identity_black_18dp,R.drawable.baseline_filter_1_black_18dp,R.drawable.baseline_pets_black_18dp,R.drawable.baseline_food_bank_black_18dp,R.drawable.baseline_accessibility_new_black_18dp,R.drawable.baseline_directions_bike_black_18dp};
    String[]max={"na 8","na 11", "na 8","na 10","na 12","na 6"};
    int[]sumy1,sumy2,sumy3;
    File internalStorageDir;
    File file1,file2,file3;
    String angplik="angielski.txt";
    String niemplik="niemiecki.txt";
    String hiszplik="hiszpanski.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progres);
        Button butt=findViewById(R.id.buttonPowrot);
        Fiszki f=new Fiszki();
        list1=findViewById(R.id.lista1);
        list2=findViewById(R.id.lista2);
        list3=findViewById(R.id.lista3);
        internalStorageDir = getFilesDir();
        file1=new File(internalStorageDir,angplik);
        file2=new File(internalStorageDir,niemplik);
        file3=new File(internalStorageDir,hiszplik);
        System.out.println("Progres tu");
        String[]linie = new String[6];
        for (int i=0;i<6;i++)linie[i]=" ";
        try {
            linie=odczytEXS(file1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String[]linie2=new String[6];
        for (int i=0;i<6;i++){
            linie2[i] = "";
            for(int j=4;j<linie[i].length();j++) {

                linie2[i] += linie[i].charAt(j);
            }
        }
        String[]linie3 = new String[6];
        for (int i=0;i<6;i++)linie3[i]=" ";
        try {
            linie3=odczytEXS(file2);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String[]linie4=new String[6];
        for (int i=0;i<6;i++){
            linie4[i] = "";
            for(int j=4;j<linie3[i].length();j++) {

                linie4[i] += linie3[i].charAt(j);
            }
        }
        String[]linie5 = new String[6];
        for (int i=0;i<6;i++)linie5[i]=" ";
        try {
            linie5=odczytEXS(file3);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String[]linie6=new String[6];
        for (int i=0;i<6;i++){
            linie6[i] = "";
            for(int j=4;j<linie5[i].length();j++) {

                linie6[i] += linie5[i].charAt(j);
            }
        }
        sumy1=new int[6];
        sumy2=new int[6];
        sumy3=new int[6];
        for(int i=0;i<6;i++){
            for(int j=0;j<linie2[i].length();j++){

                sumy1[i]+=Integer.parseInt(String.valueOf(linie2[i].charAt(j)));
                sumy2[i]+=Integer.parseInt(String.valueOf(linie4[i].charAt(j)));
                sumy3[i]+=Integer.parseInt(String.valueOf(linie6[i].charAt(j)));
            }
        }
        CustomAdapter adapter1=new CustomAdapter(this,sumy1,max,obrazki);
        list1.setAdapter(adapter1);
        CustomAdapter adapter2=new CustomAdapter(this,sumy2,max,obrazki);
        list2.setAdapter(adapter2);
        CustomAdapter adapter3=new CustomAdapter(this,sumy3,max,obrazki);
        list3.setAdapter(adapter3);

    }
    public void back(View view){onBackPressed();}

    public String[] odczytEXS(File file) throws FileNotFoundException {
        String[]linie=new String[6];
        Scanner odczyt = null;
        odczyt=new Scanner(file);
        int[]wymiary=new int[]{8,11,8,10,12,6};
        for(int i=0;i<6;i++){
            for(int j=0;j<wymiary[i];j++){
                if(odczyt.hasNext())linie[i]+= odczyt.next();
            }
        }
        odczyt.close();
        return linie;
    }
    public void toReset(View view){
        Intent intent=new Intent(this,Reset.class);
        startActivity(intent);
        this.finish();
    }
}