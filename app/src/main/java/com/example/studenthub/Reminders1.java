package com.example.studenthub;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class Reminders1 extends AppCompatActivity {

    Spinner spinner;
    TextView tv1;
    TextView tv2;
    Calendar mCurrentDate;
    int day, month, year;
    Button mSet;
    EditText mMessage;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminders1);

        mSet = (Button) findViewById(R.id.setAlarm);
        mMessage = (EditText) findViewById(R.id.Message);

        tv1 = (TextView) findViewById(R.id.currentDate);
        mCurrentDate = Calendar.getInstance();
        day = mCurrentDate.get(Calendar.DAY_OF_MONTH);
        month = mCurrentDate.get(Calendar.MONTH);
        year = mCurrentDate.get(Calendar.YEAR);

        tv2 = (TextView) findViewById(R.id.currentTime);
        tv2.setText("12:00");

        tv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog TimePickerDialog = new TimePickerDialog(Reminders1.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                       tv2.setText(hourOfDay+":"+minute);
                    }
                },0,0,false);
                TimePickerDialog.show();
            }
        });

        month=month+1;
        tv1.setText(day+"/"+month+"/"+year);
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog DatePickerDialog = new DatePickerDialog(Reminders1.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month = month+1;
                        tv1.setText(dayOfMonth + "/" + month + "/" + year);

                    }
                }, year, month, day);
                DatePickerDialog.show();
            }
        });

        spinner= (Spinner) findViewById(R.id.ModuleList);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        mSet.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String moduleName = spinner.toString();
                String moduleText = mMessage.getText().toString();
                String doomDate = tv1.getText().toString();
                String doomTime = tv2.getText().toString();

                Intent setClicked = new Intent (Reminders1.this, AlarmPage.class);
                //setClicked.putExtra("moduleName", moduleName);
                //setClicked.putExtra("moduleText", moduleText);
                //setClicked.putExtra("doomDate", doomDate);
                //setClicked.putExtra("doomTime", doomTime);

                startActivity(setClicked);
            }
        });
    }
}
