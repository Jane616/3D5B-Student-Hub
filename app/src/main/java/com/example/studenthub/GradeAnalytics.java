package com.example.studenthub;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class GradeAnalytics extends AppCompatActivity {
    TextView ModuleNameGradeAnalytics, GradeAnalyticsTxt, AverageTxt, averageTxt, NoFailsTxt, noFailsTxt;
    Spinner spinner;
    ListView assesmentListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade_analytics);

        Bundle bn = getIntent().getExtras();
        final String name = bn.getString("module_name");

        spinner = (Spinner) findViewById(R.id.YearSpinner);
        ModuleNameGradeAnalytics = (TextView) findViewById(R.id.ModuleNameGradeAnalytics);
        ModuleNameGradeAnalytics.setText(String.valueOf(name));

        AverageTxt = (TextView) findViewById(R.id.AverageTxt);
        averageTxt = (TextView) findViewById(R.id.averageTxt);
        NoFailsTxt = (TextView) findViewById(R.id.NoFailsTxt);
        noFailsTxt = (TextView) findViewById(R.id.noFailsTxt);
        setTextDisable(ModuleNameGradeAnalytics);

        setTextDisable(AverageTxt);
        setTextDisable(averageTxt);
        setTextDisable(NoFailsTxt);
        setTextDisable(noFailsTxt);


        ArrayList<String> arrayList_year = new ArrayList<>();
        arrayList_year.add("2019/2020");
        arrayList_year.add("2018/2019");
        arrayList_year.add("2017/2018");
        arrayList_year.add("2016/2017");

        ArrayAdapter<String> arrayAdapter_year;
        arrayAdapter_year = new ArrayAdapter<>(getApplicationContext(), R.layout.spinner_item, arrayList_year);
        spinner.setAdapter(arrayAdapter_year);

        assesmentListView = (ListView) findViewById(R.id.assesmentListView);
        ArrayList<AssesmentRow> assesments = new ArrayList<>();
        assesments.add(new AssesmentRow("Homework 1", "85%"));
        assesments.add(new AssesmentRow("Homework 2", "70%"));
        assesments.add(new AssesmentRow("Homework 3", "60%"));
        assesments.add(new AssesmentRow("Homework 4", "67%"));
        assesments.add(new AssesmentRow("Project 0", "60%"));

        AssesmentCustomAdapter adapter = new AssesmentCustomAdapter(this, assesments);
        assesmentListView.setAdapter(adapter);

    }

    private void setTextDisable(TextView text){
        text.setFocusable(false);
        text.setCursorVisible(false);
        text.setKeyListener(null);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.menuLogout:
                Intent startIntent = new Intent(getApplicationContext(), Login.class);
                startActivity(startIntent);
                break;
            case R.id.menuReminders:
                Intent otherIntent = new Intent(getApplicationContext(), AlarmPage.class);
                startActivity(otherIntent);
                break;
            case R.id.menuContactUs:
                Intent anotherIntent = new Intent(getApplicationContext(), ContactPage.class);
                startActivity(anotherIntent);
                break;
        }
        return true;
    }
}
