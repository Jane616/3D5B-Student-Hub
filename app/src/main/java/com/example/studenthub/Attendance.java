package com.example.studenthub;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Attendance extends AppCompatActivity {

    int numAttended ;
    int numMissed ;
    TextView attendanceTextView;
    TextView moduleName;

    TextView mAttendancePercentageTextView;
    TextView mAttendMissView;
    Button mButtonMissed;
    Button mButtonAttended;



    DatabaseReference RootRef = FirebaseDatabase.getInstance().getReference();
    DatabaseReference mPercentageRef = RootRef.child("Percentage");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);
        mAttendancePercentageTextView=(TextView)findViewById(R.id.attendancePercentageTextView);
        mAttendMissView=(TextView)findViewById(R.id.toAttendMissView);
        mButtonMissed=(Button)findViewById(R.id.buttonMissed);
        mButtonAttended=(Button)findViewById(R.id.buttonAttended);


        moduleName = findViewById(R.id.ModuleNameText);
        Bundle bn = getIntent().getExtras();
        String modulename = bn.getString("modulename");
        moduleName.setText(String.valueOf(modulename));

        System.out.println("Activity started");
        attendanceTextView = findViewById(R.id.attendancePercentageTextView);

    }

    @Override
    protected void onStart(){
        super.onStart();

        mPercentageRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue(String.class);

                mAttendancePercentageTextView.setText(text);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        mButtonAttended.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numAttended++;
                double attendedPercentage = 100 * numAttended / (numAttended + numMissed);
                String attendedPercentageAsString = String.valueOf(attendedPercentage);
                mPercentageRef.setValue("Attendance: " + attendedPercentageAsString + "%");

                if(attendedPercentage<=75){
                    int toAttend = (3*numMissed)-numAttended;
                    String toAttendAsString = String.valueOf(toAttend);
                    mAttendMissView.setText("Attended: " + numAttended+ "\nMissed: " + numMissed + "\nTotal Lectures: " + (numAttended+numMissed) + "\nYou need to attend " + toAttendAsString + " more lectures to get even");
                }
                else if (attendedPercentage == 75 ){
                    mAttendMissView.setText("Attended: " + numAttended+ "\nMissed: " + numMissed + "\nTotal Lectures: " + (numAttended+numMissed) + "\nYou are even!!");
                }
                else{
                    int toMiss = (numAttended-(3*numMissed))/3;
                    String toMissAsString = String.valueOf(toMiss);
                    mAttendMissView.setText("Attended: " + numAttended+ "\nMissed: " + numMissed + "\nTotal Lectures: " + (numAttended+numMissed) + "\nYou can bunk " + toMissAsString + " lectures and still be even");
                }
            }
        });

        mButtonMissed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numMissed++;
                float attendedPercentage =100 * numAttended / (numAttended + numMissed);
                String attendedPercentageAsString = String.valueOf(attendedPercentage);
                mPercentageRef.setValue("Attendance: " + attendedPercentageAsString + "%");

                if(attendedPercentage<75){
                    int toAttend = (3*numMissed)-numAttended;
                    String toAttendAsString = String.valueOf(toAttend);
                    mAttendMissView.setText("Attended: " + numAttended+ "\nMissed: " + numMissed + "\nTotal Lectures: " + (numAttended+numMissed) + "\nYou need to attend " + toAttendAsString + " more lectures to get even");
                }
                else if (attendedPercentage == 75 ){
                    mAttendMissView.setText("Attended: " + numAttended+ "\nMissed: " + numMissed + "\nTotal Lectures: " + (numAttended+numMissed) + "\nYou are even!!");
                }
                else{
                    int toMiss = (numAttended-(3*numMissed))/3;
                    String toMissAsString = String.valueOf(toMiss);
                    mAttendMissView.setText("Attended: " + numAttended+ "\nMissed: " + numMissed + "\nTotal Lectures: " + (numAttended+numMissed) + "\nYou can bunk " + toMissAsString + " lectures and still be even");
                }

            }
        });

    }




}
