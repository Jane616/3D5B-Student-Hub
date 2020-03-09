package com.example.studenthub;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class AlarmPage extends AppCompatActivity {

    TextView m1, m2, m3, m4;
    ImageView mAddAlarm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm_page);

        mAddAlarm = (ImageView) findViewById(R.id.remindersPage);
        mAddAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent backButton = new Intent (AlarmPage.this, Reminders1.class);
                startActivity(backButton);
            }
        });

        m1 = (TextView) findViewById(R.id.h1);
        m2 = (TextView) findViewById(R.id.h2);
        m3 = (TextView) findViewById(R.id.h3);
        m4 = (TextView) findViewById(R.id.h4);

        //m1.setText(getIntent().getStringExtra("moduleName"));
        //m2.setText(getIntent().getStringExtra("moduleText"));
        //m3.setText(getIntent().getStringExtra("doomDate"));
        //m4.setText(getIntent().getStringExtra("doomTime"));
    }
}
