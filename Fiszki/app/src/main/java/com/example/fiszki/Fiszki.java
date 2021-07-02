package com.example.fiszki;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Fiszki extends AppCompatActivity {

    String[] osobyPL;
    String[] osobyAng;
    ArrayList<Integer> listaOsob;
    int ind = 0;
    private SensorManager sensorManager;
    private float acelVal, acelLast, shake;
    private int licznikFiszek = 0;
    int ktora = 0;
    TextView t1;
    int parz=1;
    private Vibrator vibrator;
    Contener cont;
    Switch switchDone;
    int dobrze=0;
    String angplik="angielski.txt";
    String niemplik="niemiecki.txt";
    String hiszplik="hiszpanski.txt";
    String plik;
    int kategoria;
    String tabela;
    File internalStorageDir;
    File file1,file2,file3;
    int jezyk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ktora=0;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fiszki);
        switchDone=findViewById(R.id.switchDone);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensorManager.registerListener(sensorListener,sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),SensorManager.SENSOR_DELAY_NORMAL);
        vibrator= (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        t1 = findViewById(R.id.tekst1);
        cont=new Contener();
        Bundle bundle=getIntent().getExtras();
        int[]params=bundle.getIntArray("przycisk");
        if(params[1]==1){
            plik=angplik;
            jezyk=1;
        }
        else if(params[1]==2){
            jezyk=2;
            plik=niemplik;
        }
        else {
            jezyk=3;
            plik=hiszplik;
        }
        kategoria=params[0];
        if(params[1]==1) tabela="Angielski";
        else if(params[1]==2)tabela="Niemiecki";
        else tabela="Hiszpanski";
        cont.setPrzycisk(params[0]);
        cont.setJezyk(params[1]);
        osobyPL=cont.zwrocTablicePL();
        osobyAng=cont.zwrocTabliceJezyk();
        listaOsob=cont.zwrocIloscArray();
        Collections.shuffle(listaOsob);
        acelVal=SensorManager.GRAVITY_EARTH;
        acelLast=SensorManager.GRAVITY_EARTH;
        shake=0.00f;
        ind=listaOsob.get(ktora);
        t1.setText(osobyPL[ind]);
        licznikFiszek++;
        ktora++;
        internalStorageDir = getFilesDir();
        file1=new File(internalStorageDir,angplik);
        file2=new File(internalStorageDir,niemplik);
        file3=new File(internalStorageDir,hiszplik);

    }

    public void back(View view) {
        ktora=0;
        this.finish();
        onBackPressed();
    }

    public void zmienJezyk(View view) {
        t1 = findViewById(R.id.tekst1);
        if (osobyPL[ind] == t1.getText().toString()) t1.setText(osobyAng[ind]);
        else t1.setText(osobyPL[ind]);
    }

    private final SensorEventListener sensorListener = new SensorEventListener() {
        @RequiresApi(api = Build.VERSION_CODES.KITKAT)
        @Override
        public void onSensorChanged(final SensorEvent event) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];
            acelLast = acelVal;
            acelVal = (float) Math.sqrt((double) (x * x + y * y + z * z));
            float delta = acelVal - acelLast;
            shake = shake * 0.9f + delta;
            if (shake > 20) parz++;
            if (parz == 6) {
                if (switchDone.isChecked()) {
                    String[]linie = new String[6];
                    for (int i=0;i<6;i++)linie[i]=" ";
                    try {
                        linie=odczytEXS();
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
                    for (int i=0;i<linie2.length;i++) System.out.println("linia"+i+" "+linie2[i]);
                    String pojedyncze = " ";
                    for(int i=0;i<linie2[kategoria-1].length();i++){
                        if(i!=ind)pojedyncze+= linie2[kategoria - 1].charAt(i);
                        else pojedyncze+="1";
                    }
                    linie2[kategoria-1]=" ";
                    linie2[kategoria-1]=pojedyncze;
                    for (int i=0;i<linie2.length;i++) System.out.println("linia"+i+" "+linie2[i]);
                    try {
                        zapisEXS(linie2);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    dobrze += 1;
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    vibrator.vibrate(VibrationEffect.createOneShot(200, VibrationEffect.DEFAULT_AMPLITUDE));
                } else vibrator.vibrate(200);
                if (licznikFiszek != osobyPL.length) {
                    switchDone.setChecked(false);
                    t1.setText(osobyPL[listaOsob.get(ktora)]);
                    ind = listaOsob.get(ktora);
                    licznikFiszek++;
                    ktora++;
                    parz = 0;

                } else {
                    Intent intent = new Intent(Fiszki.this, Podsumowanie.class);
                    Bundle git = new Bundle();
                    int suma=0;
                    String[]linie = new String[6];
                    for (int i=0;i<6;i++)linie[i]=" ";
                    try {
                        linie=odczytEXS();
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
                    for(int i=0;i<linie2[kategoria-1].length();i++)suma+=Integer.parseInt(String.valueOf(linie2[kategoria-1].charAt(i)));
                    git.putInt("ile", dobrze);
                    git.putInt("suma", suma);
                    intent.putExtras(git);
                    startActivity(intent);
                    Fiszki.this.finish();
                    parz = 0;
                    licznikFiszek = 0;
                    ktora=0;
                    suma=0;


                }
            }
        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }
    };

    public String[] odczytEXS() throws FileNotFoundException {
        String[]linie=new String[6];
        Scanner odczyt = null;
        if(jezyk==1) {
                odczyt=new Scanner(file1);
        }
        else if(jezyk==2) {
                odczyt=new Scanner(file2);
        }
        else {
                odczyt=new Scanner(file3);
        }
        int[]wymiary=new int[]{8,11,8,10,12,6};
        for(int i=0;i<6;i++){
            for(int j=0;j<wymiary[i];j++){
                if(odczyt.hasNext())linie[i]+= odczyt.next();
            }
        }
        odczyt.close();
        return linie;
    }

    public void zapisEXS(String [] linie) throws IOException {
        FileOutputStream fos;
        if(jezyk==1)fos=new FileOutputStream(file1);
        else if(jezyk==2)fos=new FileOutputStream(file2);
        else  fos=new FileOutputStream(file3);
        for(int i=0;i<linie.length;i++){
                for (int j = 0; j < linie[i].length(); j++) {

                    fos.write(linie[i].charAt(j));
                    fos.write(" ".getBytes());
                }
        }

        fos.close();
    }

}