package com.example.a403.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {

    Chronometer c;
    Button b1,b2;
    RadioGroup rg;
    RadioButton r1,r2;
    CalendarView cl;
    TextView t;
    TimePicker tm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button)findViewById(R.id.button);
        b2 = (Button)findViewById(R.id.button3);
        rg = (RadioGroup)findViewById(R.id.radioGroup);
        r1 = (RadioButton)findViewById(R.id.radioButton);
        r2 = (RadioButton)findViewById(R.id.radioButton2);
        cl = (CalendarView)findViewById(R.id.calendarView);
        t = (TextView)findViewById(R.id.textView);
        c = (Chronometer)findViewById(R.id.chronometer);
        tm = (TimePicker)findViewById(R.id.timePicker);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c.start();
            }
        });
    }
}
