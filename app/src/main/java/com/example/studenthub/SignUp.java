package com.example.studenthub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class SignUp extends AppCompatActivity {  //implements AdapterView.OnItemSelectedListener {

    Spinner year,Course;
    ArrayList<String> arrayList_year;
    ArrayAdapter<String> arrayAdapter_year;

    ArrayList<String> arrayList_year1,arrayList_year2,arrayList_year3,arrayList_year4,arrayList_year5;
    ArrayAdapter<String> arrayAdapter_Course;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        year=(Spinner)findViewById(R.id.year);
        Course=(Spinner)findViewById(R.id.spinner);
        arrayList_year= new ArrayList<>();
        arrayList_year.add("Select Year");
        arrayList_year.add("Year 1");
        arrayList_year.add("Year 2");
        arrayList_year.add("Year 3");
        arrayList_year.add("Year 4");
        arrayList_year.add("Year 5");

        arrayAdapter_year = new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,arrayList_year);
        year.setAdapter(arrayAdapter_year);

        //Course Spinner process connected with year
        arrayList_year1=new ArrayList<>();
        arrayList_year1.add("Select Course");
        arrayList_year1.add("Engineering");
        arrayList_year1.add("BESS");
        arrayList_year1.add("Global Business");
        arrayList_year1.add("Law ");
        arrayList_year1.add("Arts");

        arrayList_year2=new ArrayList<>();
        arrayList_year2.add("Select Course");
        arrayList_year2.add("Dual BA");
        arrayList_year2.add("Sociology");
        arrayList_year2.add("Computer Science");
        arrayList_year2.add("Clinical Studies");
        arrayList_year2.add("Speech Language");

        arrayList_year3=new ArrayList<>();
        arrayList_year3.add("Select Course");
        arrayList_year3.add("Engineering");
        arrayList_year3.add("BESS");
        arrayList_year3.add("Global Business");
        arrayList_year3.add("Law ");
        arrayList_year3.add("Arts");

        arrayList_year4=new ArrayList<>();
        arrayList_year4.add("Select Course");
        arrayList_year4.add("Dual BA");
        arrayList_year4.add("Sociology");
        arrayList_year4.add("Computer Science");
        arrayList_year4.add("Clinical Studies");
        arrayList_year4.add("Speech Language");


        arrayList_year5=new ArrayList<>();
        arrayList_year5.add("Select Course");
        arrayList_year5.add("Engineering MAI");
        arrayList_year5.add("MSc Finance");
        arrayList_year5.add("MSc Marketing");
        arrayList_year5.add("MSc Management");
        arrayList_year5.add("PHD");

        year.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if(position==0)
                {
                    arrayAdapter_Course=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,arrayList_year1);
                }

                if(position==1)
                {
                    arrayAdapter_Course=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,arrayList_year2);
                }

                if(position==2)
                {
                    arrayAdapter_Course=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,arrayList_year3);
                }

                if(position==3)
                {
                    arrayAdapter_Course=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,arrayList_year4);
                }

                if(position==4)
                {
                    arrayAdapter_Course=new ArrayAdapter<>(getApplicationContext(),android.R.layout.simple_spinner_item,arrayList_year5);
                }

                Course.setAdapter(arrayAdapter_Course);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Course spinner ends


       /* Spinner spinner= findViewById(R.id.year);
        ArrayAdapter<CharSequence> adapter= ArrayAdapter.createFromResource(this,R.array.Year,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemClickListener((AdapterView.OnItemClickListener) this); */
    }

   /* @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text=parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),text,Toast.LENGTH_SHORT) .show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }*/
}