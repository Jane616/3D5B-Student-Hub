package com.example.studenthub;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ModulesNewPage extends AppCompatActivity {
    private Button review;
    private Button attendance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modules_new_page);

        TextView Display = findViewById(R.id.textView2);
        Bundle bn = getIntent().getExtras();
        final String name = bn.getString("abc");
        Display.setText(String.valueOf(name));

        review = findViewById(R.id.ReviewBtn);
        review.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                startActivity(new Intent(ModulesNewPage.this, Review.class));
            }

        });

        attendance = findViewById(R.id.AttendanceBtn);
        attendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jumpToAttendance = new Intent(ModulesNewPage.this, Attendance.class);
                jumpToAttendance.putExtra("modulename",name);
                startActivity(jumpToAttendance);
                finish();
            }
        });

        Button signOutBtn = (Button)findViewById(R.id.signOutBtn);
        signOutBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), Login.class);
                startActivity(startIntent);
            }
        });
    }
}
