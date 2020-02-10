package com.example.studenthub;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ModuleList extends AppCompatActivity {
    private Button resultButton;

    private ArrayList<String> result;
    private CheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6, checkBox7, checkBox8, checkBox9, checkBox10,
            checkBox11, checkBox12, checkBox13, checkBox14, checkBox15, checkBox16, checkBox17, checkBox18;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_list);
        resultButton = findViewById(R.id.proceedButton);

        result = new ArrayList<>();

        // initiate views
        checkBox1 = (CheckBox) findViewById(R.id.checkBox);
        checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        checkBox3 = (CheckBox) findViewById(R.id.checkBox3);
        checkBox4 = (CheckBox) findViewById(R.id.checkBox4);
        checkBox5 = (CheckBox) findViewById(R.id.checkBox5);
        checkBox6 = (CheckBox) findViewById(R.id.checkBox6);
        checkBox7 = (CheckBox) findViewById(R.id.checkBox7);
        checkBox8 = (CheckBox) findViewById(R.id.checkBox8);
        checkBox9 = (CheckBox) findViewById(R.id.checkBox9);
        checkBox10 = (CheckBox) findViewById(R.id.checkBox10);
        checkBox11 = (CheckBox) findViewById(R.id.checkBox11);
        checkBox12 = (CheckBox) findViewById(R.id.checkBox12);
        checkBox13 = (CheckBox) findViewById(R.id.checkBox13);
        checkBox14 = (CheckBox) findViewById(R.id.checkBox14);
        checkBox15 = (CheckBox) findViewById(R.id.checkBox15);
        checkBox16 = (CheckBox) findViewById(R.id.checkBox16);
        checkBox17 = (CheckBox) findViewById(R.id.checkBox17);
        checkBox18 = (CheckBox) findViewById(R.id.checkBox18);

        checkBox1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox1.isChecked())
                    result.add("Hello");
                else
                    result.remove("Hello");
            }
        });

        checkBox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox2.isChecked())
                    result.add("2");
                else
                    result.remove("2");
            }
        });
        checkBox3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox3.isChecked())
                    result.add("3");
                else
                    result.remove("3");
            }
        });
        checkBox4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox4.isChecked())
                    result.add("4");
                else
                    result.remove("4");
            }
        });
        checkBox5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox5.isChecked())
                    result.add("5");
                else
                    result.remove("5");
            }
        });
        checkBox6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox6.isChecked())
                    result.add("6");
                else
                    result.remove("6");
            }
        });
        checkBox7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox7.isChecked())
                    result.add("7");
                else
                    result.remove("7");
            }
        });
        checkBox8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox8.isChecked())
                    result.add("8");
                else
                    result.remove("8");
            }
        });
        checkBox9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox9.isChecked())
                    result.add("9");
                else
                    result.remove("9");
            }
        });
        checkBox10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox10.isChecked())
                    result.add("10");
                else
                    result.remove("10");
            }
        });
        checkBox11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox11.isChecked())
                    result.add("11");
                else
                    result.remove("11");
            }
        });
        checkBox12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox12.isChecked())
                    result.add("12");
                else
                    result.remove("12");
            }
        });
        checkBox13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox13.isChecked())
                    result.add("13");
                else
                    result.remove("13");
            }
        });
        checkBox14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox14.isChecked())
                    result.add("14");
                else
                    result.remove("14");
            }
        });
        checkBox15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox15.isChecked())
                    result.add("15");
                else
                    result.remove("15");
            }
        });
        checkBox16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox16.isChecked())
                    result.add("16");
                else
                    result.remove("16");
            }
        });
        checkBox17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox17.isChecked())
                    result.add("17");
                else
                    result.remove("17");
            }
        });
        checkBox18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBox18.isChecked())
                    result.add("18");
                else
                    result.remove("18");
            }
        });

        resultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder stringBuilder = new StringBuilder();
                for (String s : result)
                    stringBuilder.append(s).append("\n");

                Intent intent = new Intent(ModuleList.this, ModulesNewPage.class);
                intent.putExtra("abc",result.toString());
                startActivity(intent);
                finish();

            }
        });
    }
}
