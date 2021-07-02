package com.example.fiszki;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class SpinnerAdapter extends ArrayAdapter<String> {

    Context context;
    String[] jezyk;
    int[]images;

    public SpinnerAdapter(@NonNull Context context, String[]jezyki, int[]images) {
        super(context,R.layout.spinner_item,jezyki);
        this.context=context;
        this.jezyk=jezyki;
        this.images=images;
    }
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent){

            LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row=inflater.inflate(R.layout.spinner_item,null);
            TextView t1=row.findViewById(R.id.textJeezyk);
            ImageView im=row.findViewById(R.id.imageFlaga);

            t1.setText(jezyk[position]);
            im.setImageResource(images[position]);

        return row;

    }
    @Override
    public View getView(int position, View convertVoew, ViewGroup parent){
        LayoutInflater inflater= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row=inflater.inflate(R.layout.spinner_item,null);
        TextView t1=row.findViewById(R.id.textJeezyk);
        ImageView im=row.findViewById(R.id.imageFlaga);

        t1.setText(jezyk[position]);
        im.setImageResource(images[position]);

        return row;
    }
}
