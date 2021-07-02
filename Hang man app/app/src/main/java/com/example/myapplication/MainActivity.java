package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    String searchWord;
    String inSearching;
    ImageView img;
    TextView word,wynik, tempT;
    int licznik;
    String [] slowa={"komputer","lalka","zabawka","onomatopeja","motocykl","cyberbezpieczeństwo","państwo","wielkanoc"};
    Random rand;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       rand=new Random();
        searchWord=slowa[rand.nextInt(slowa.length-1)];
        word=findViewById(R.id.wordToSearch);
        wynik=findViewById(R.id.stan);
       inSearching="";
        licznik=0;
        for(int i=0;i<searchWord.length();i++) inSearching+='?';
        word.setText(inSearching.toString());
        img=findViewById(R.id.imageView);

    }
    @SuppressLint("UseCompatLoadingForDrawables")
    public void changeWord(View view){
            boolean czyjuz = false;
            for (int i = 0; i < inSearching.length(); i++)
                if (inSearching.charAt(i) == '?') czyjuz = true;
            @SuppressLint("ResourceType") String IDletter = getResources().getResourceEntryName(view.getId());
            //tu
            Character letter = IDletter.charAt(IDletter.length() - 1);
            if (searchWord.contains(letter.toString())) {
                String temp1 = "";

                for (int i = 0; i < searchWord.length(); i++) {
                    if (searchWord.toCharArray()[i] == letter) temp1 += letter;
                    else {
                        temp1 += inSearching.charAt(i);
                    }
                }
                inSearching = temp1;
                word.setText(inSearching);
            } else licznik += 1;

            String res = "wisielec" + licznik;
            int resID = getResources().getIdentifier(res, "drawable", getPackageName());
            img.setImageResource(resID);
        if (!inSearching.contains("?")) {
            wynik.setText("Wygrałeś");
            inSearching="";
            licznik=0;
            searchWord=slowa[rand.nextInt(slowa.length-1)];
            for(int i=0;i<searchWord.length();i++) inSearching+='?';
            word.setText(inSearching.toString());
            String res1 = "wisielec" + licznik;
            int resID1 = getResources().getIdentifier(res1, "drawable", getPackageName());
            img.setImageResource(resID1);
        }
        if (licznik == 10 && czyjuz){
            wynik.setText("Przegrałeś");
            inSearching="";
            licznik=0;
            searchWord=slowa[rand.nextInt(slowa.length-1)];
            for(int i=0;i<searchWord.length();i++) inSearching+='?';
            word.setText(inSearching.toString());
            String res1 = "wisielec" + licznik;
            int resID1 = getResources().getIdentifier(res1, "drawable", getPackageName());
            img.setImageResource(resID1);
        }

    }
}