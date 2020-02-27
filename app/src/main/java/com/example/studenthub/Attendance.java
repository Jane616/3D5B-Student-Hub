package com.example.studenthub;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Attendance extends AppCompatActivity {

    int numAttended = 13;
    int numMissed = 5;
    TextView attendanceTextView;
    TextView moduleName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);

        moduleName = findViewById(R.id.ModuleNameText);
        Bundle bn = getIntent().getExtras();
        String modulename = bn.getString("modulename");
        moduleName.setText(String.valueOf(modulename));



        int x = 5;
        System.out.println("Activity started");
        attendanceTextView = findViewById(R.id.attendancePercentageTextView);

        Button signOutBtn = (Button)findViewById(R.id.signOutBtn);
        signOutBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), Login.class);
                startActivity(startIntent);
            }
        });
    }
    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    */
/*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    */

    public void onAttendedClick(View view) {
        System.out.println("On attended was clicked");
        numAttended ++;
        updateAttendancePercentage();
        System.out.println("attended clicked");

    }


    public void onMissedClick(View view) {
        System.out.println("On missed was clicked");
        numMissed ++;
        updateAttendancePercentage();
        System.out.println("missed clicked");

    }

    private void updateAttendancePercentage() {
        double attendedPercentage = 100 * numAttended / (numAttended + numMissed);

        String attendedPercentageAsString = String.valueOf(attendedPercentage);

        attendanceTextView.setText("Attendance: " + attendedPercentageAsString + "%");


    }

}
