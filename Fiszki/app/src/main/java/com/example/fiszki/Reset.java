package com.example.fiszki;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Reset extends AppCompatActivity {

    File internalStorageDir;
    File file1,file2,file3;
    String angplik="angielski.txt";
    String niemplik="niemiecki.txt";
    String hiszplik="hiszpanski.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset);
        internalStorageDir = getFilesDir();
        file1=new File(internalStorageDir,angplik);
        file2=new File(internalStorageDir,niemplik);
        file3=new File(internalStorageDir,hiszplik);
    }
    public void back(View view){
        onBackPressed();
        this.finish();}

    public void resetAngielski(View view) throws IOException {
        FileOutputStream fos=new FileOutputStream(file1);
        fos.write("0 0 0 0 0 0 0 0 ".getBytes());
        fos.write("0 0 0 0 0 0 0 0 0 0 0 ".getBytes());
        fos.write("0 0 0 0 0 0 0 0 ".getBytes());
        fos.write("0 0 0 0 0 0 0 0 0 0 ".getBytes());
        fos.write("0 0 0 0 0 0 0 0 0 0 0 0 ".getBytes());
        fos.write("0 0 0 0 0 0 ".getBytes());
        fos.close();
        Toast.makeText(this,"Zresetowano progres w języku angielskim",Toast.LENGTH_SHORT).show();
    }
    public void resetNiemiecki(View view) throws IOException {
        FileOutputStream fos=new FileOutputStream(file2);
        fos.write("0 0 0 0 0 0 0 0 ".getBytes());
        fos.write("0 0 0 0 0 0 0 0 0 0 0 ".getBytes());
        fos.write("0 0 0 0 0 0 0 0 ".getBytes());
        fos.write("0 0 0 0 0 0 0 0 0 0 ".getBytes());
        fos.write("0 0 0 0 0 0 0 0 0 0 0 0 ".getBytes());
        fos.write("0 0 0 0 0 0 ".getBytes());
        fos.close();
        Toast.makeText(this,"Zresetowano progres w języku niemieckim",Toast.LENGTH_SHORT).show();
    }
    public void resetHiszpanski(View view) throws IOException {
        FileOutputStream fos=new FileOutputStream(file3);
        fos.write("0 0 0 0 0 0 0 0 ".getBytes());
        fos.write("0 0 0 0 0 0 0 0 0 0 0 ".getBytes());
        fos.write("0 0 0 0 0 0 0 0 ".getBytes());
        fos.write("0 0 0 0 0 0 0 0 0 0 ".getBytes());
        fos.write("0 0 0 0 0 0 0 0 0 0 0 0 ".getBytes());
        fos.write("0 0 0 0 0 0 ".getBytes());
        fos.close();
        Toast.makeText(this,"Zresetowano progres w języku hiszpańskim",Toast.LENGTH_SHORT).show();
    }
    public void resetAll(View view) throws IOException {
        resetAngielski(view);
        resetNiemiecki(view);
        resetHiszpanski(view);
        Toast.makeText(this,"Zresetowano progres",Toast.LENGTH_SHORT).show();
    }
}