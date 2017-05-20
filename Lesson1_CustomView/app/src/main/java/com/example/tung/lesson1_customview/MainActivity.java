package com.example.tung.lesson1_customview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.tung.lesson1_customview.customview.MyCustomview;

public class MainActivity extends AppCompatActivity {

    MyCustomview myView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidget();
    }

    private void initWidget(){
        myView = (MyCustomview) findViewById(R.id.my_view);
        CharSequence subjects[] = { "PHP", "Ruby", "Android", "C#" };
        myView.setValues(subjects);
        myView.setSelectedIndex(1);
    }
}
