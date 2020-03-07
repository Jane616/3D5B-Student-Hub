package com.example.studenthub;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ModulesNewPage extends AppCompatActivity {
    private Button review;
    private Button attendance;
    DatabaseReference reff;
    EditText lectureName;
    EditText lectureEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modules_new_page);





        TextView Display = findViewById(R.id.textView2);
        Bundle bn = getIntent().getExtras();
        final String name = bn.getString("abc");
        Display.setText(String.valueOf(name));
        Display.setFocusable(false);
        Display.setCursorVisible(false);
        Display.setKeyListener(null);

        reff = FirebaseDatabase.getInstance().getReference().child("Modules").
                child("Computer Engineering").child("Year 3").child(name);

        lectureName = (EditText) findViewById(R.id.lectureName);
        disableEditText(lectureName);
        lectureEmail = (EditText) findViewById(R.id.lectureEmail);
        disableEditText(lectureEmail);



        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String lec_name = dataSnapshot.child("Lecture Name").getValue().toString();
                String lec_email = dataSnapshot.child("Lecture Email").getValue().toString();

                lectureName.setText(lec_name);
                lectureEmail.setText(lec_email);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        review = findViewById(R.id.ReviewBtn);
        review.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //startActivity(new Intent(ModulesNewPage.this, Review.class));
                Intent jumpToAttendance = new Intent(ModulesNewPage.this, Review.class);
                jumpToAttendance.putExtra("modulename",name);
                startActivity(jumpToAttendance);
            }

        });

        attendance = findViewById(R.id.AttendanceBtn);
        attendance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jumpToAttendance = new Intent(ModulesNewPage.this, Attendance.class);
                jumpToAttendance.putExtra("modulename",name);
                startActivity(jumpToAttendance);
            }
        });
    }

    private void disableEditText(EditText editText) {
        editText.setFocusable(false);
        //editText.setEnabled(false);
        editText.setCursorVisible(false);
        editText.setKeyListener(null);
    }
}
