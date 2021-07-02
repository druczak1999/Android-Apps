package com.example.fiszki;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class CustomAdapter extends ArrayAdapter {
    private final Activity context;
    private final int[] sumy;
    private final String[] maxy;
    private final Integer[] obrazki;
    public CustomAdapter(Activity context, int[] sum,String[] max, Integer[] imgid) {
        super(context, R.layout.mylist, max);
        this.context=context;
        this.sumy =sum;
        this.maxy=max;
        this.obrazki=imgid;
    }
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        @SuppressLint("ViewHolder") View rowView = inflater.inflate(R.layout.mylist, null, true);

        TextView tytulPiosenki = (TextView) rowView.findViewById(R.id.tytul);
        ImageView obrazekPiosenki = (ImageView) rowView.findViewById(R.id.obrazek);
        TextView wykonawcaPiosenki = (TextView) rowView.findViewById(R.id.wykonawca);

        tytulPiosenki.setText(String.valueOf(sumy[position]));
        obrazekPiosenki.setImageResource(obrazki[position]);
        wykonawcaPiosenki.setText(maxy[position]);

        return rowView;
    }
}
