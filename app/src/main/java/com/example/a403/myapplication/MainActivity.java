package com.example.a403.myapplication;

import android.graphics.Color;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Chronometer c;
    Button b1,b2;
    RadioGroup rg;
    RadioButton r1,r2;
    CalendarView cl;
    TextView t;
    TimePicker tm;
    String date = "";
    String time = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button)findViewById(R.id.button);
        b2 = (Button)findViewById(R.id.button3);
        r1 = (RadioButton)findViewById(R.id.radioButton);
        r2 = (RadioButton)findViewById(R.id.radioButton2);
        t = (TextView)findViewById(R.id.textView);
        c = (Chronometer)findViewById(R.id.chronometer);
        tm = (TimePicker)findViewById(R.id.timePicker);
        cl = (CalendarView)findViewById(R.id.calendarView);
        rg = (RadioGroup)findViewById(R.id.radioGroup);


        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.radioButton){
                    cl.setVisibility(View.VISIBLE);
                    tm.setVisibility(View.INVISIBLE);
                }
                else if(checkedId == R.id.radioButton2){
                    cl.setVisibility(View.INVISIBLE);
                    tm.setVisibility(View.VISIBLE);
                }
            }
        });

        cl.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                date = year +"년"+ (month+1)+ "월" + dayOfMonth + "일";
            }
        });
        tm.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener(){
            public void onTimeChanged(TimePicker view, int hourOfday,int minute){
                time = hourOfday +"시" + minute +"분";
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c.setBase(SystemClock.elapsedRealtime());
                c.start();
                c.setTextColor(Color.RED);
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(time == null){
                    Toast.makeText(getApplicationContext(),"시간을 선택해주세요",Toast.LENGTH_SHORT).show();
                    return;
                }
                c.setBase(SystemClock.elapsedRealtime());
                c.stop();
                c.setTextColor(Color.BLUE);
                t.setText(date+time+"예약됨");
            }
        });
    }
}
