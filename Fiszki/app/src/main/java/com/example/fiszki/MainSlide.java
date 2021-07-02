package com.example.fiszki;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.TextView;

public class MainSlide extends AppCompatActivity {

    ViewPager viewPager;
    TextView pagecounter;
    int total=3, count =1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_slide);
        viewPager=findViewById(R.id.viewpager);
        pagecounter=findViewById(R.id.pagecounter);
        //t_next=findViewById(R.id.t_next);
        pagecounter.setText(count+"/"+total);

        viewPager.setAdapter(new SliderAdapter(getSupportFragmentManager()));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                count=0;
                count=position+1;
                pagecounter.setText(count+"/"+total);
                //if(count==total){
                //    t_next.setText("Continue");
                //}
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}