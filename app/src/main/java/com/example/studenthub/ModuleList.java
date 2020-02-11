package com.example.studenthub;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ModuleList extends AppCompatActivity {
    private Button module1;
    private Button module2;
    private Button module3;
    private Button module4;
    private Button module5;
    private Button module6;
    private Button module7;
    private Button module8;
    private Button module9;
    private Button module10;
    private Button module11;
    private Button module12;
    private Button module13;
    private Button module14;
    private Button module15;
    private Button module16;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_list);

        module1 = findViewById(R.id.button2);
        module2 = findViewById(R.id.button3);
        module3 = findViewById(R.id.button4);
        module4 = findViewById(R.id.button5);
        module5 = findViewById(R.id.button6);
        module6 = findViewById(R.id.button7);
        module7 = findViewById(R.id.button8);
        module8 = findViewById(R.id.button9);
        module9 = findViewById(R.id.button10);
        module10 = findViewById(R.id.button11);
        module11 = findViewById(R.id.button12);
        module12 = findViewById(R.id.button13);
        module13 = findViewById(R.id.button14);
        module14 = findViewById(R.id.button15);
        module15 = findViewById(R.id.button16);
        module16 = findViewById(R.id.button17);



        module1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jumpToModule = new Intent(ModuleList.this, ModulesNewPage.class);
                jumpToModule.putExtra("abc",module1.getText().toString());
                startActivity(jumpToModule);
                finish();
            }
        });

        module2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jumpToModule = new Intent(ModuleList.this, ModulesNewPage.class);
                jumpToModule.putExtra("abc",module2.getText().toString());
                startActivity(jumpToModule);
                finish();
            }
        });

        module3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jumpToModule = new Intent(ModuleList.this, ModulesNewPage.class);
                jumpToModule.putExtra("abc",module3.getText().toString());
                startActivity(jumpToModule);
                finish();
            }
        });

        module4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jumpToModule = new Intent(ModuleList.this, ModulesNewPage.class);
                jumpToModule.putExtra("abc",module4.getText().toString());
                startActivity(jumpToModule);
                finish();
            }
        });

        module5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jumpToModule = new Intent(ModuleList.this, ModulesNewPage.class);
                jumpToModule.putExtra("abc",module5.getText().toString());
                startActivity(jumpToModule);
                finish();
            }
        });

        module6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jumpToModule = new Intent(ModuleList.this, ModulesNewPage.class);
                jumpToModule.putExtra("abc",module6.getText().toString());
                startActivity(jumpToModule);
                finish();
            }
        });

        module7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jumpToModule = new Intent(ModuleList.this, ModulesNewPage.class);
                jumpToModule.putExtra("abc",module7.getText().toString());
                startActivity(jumpToModule);
                finish();
            }
        });

        module8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jumpToModule = new Intent(ModuleList.this, ModulesNewPage.class);
                jumpToModule.putExtra("abc",module8.getText().toString());
                startActivity(jumpToModule);
                finish();
            }
        });

        module9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jumpToModule = new Intent(ModuleList.this, ModulesNewPage.class);
                jumpToModule.putExtra("abc",module9.getText().toString());
                startActivity(jumpToModule);
                finish();
            }
        });

        module10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jumpToModule = new Intent(ModuleList.this, ModulesNewPage.class);
                jumpToModule.putExtra("abc",module10.getText().toString());
                startActivity(jumpToModule);
                finish();
            }
        });

        module11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jumpToModule = new Intent(ModuleList.this, ModulesNewPage.class);
                jumpToModule.putExtra("abc",module11.getText().toString());
                startActivity(jumpToModule);
                finish();
            }
        });

        module12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jumpToModule = new Intent(ModuleList.this, ModulesNewPage.class);
                jumpToModule.putExtra("abc",module12.getText().toString());
                startActivity(jumpToModule);
                finish();
            }
        });

        module13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jumpToModule = new Intent(ModuleList.this, ModulesNewPage.class);
                jumpToModule.putExtra("abc",module13.getText().toString());
                startActivity(jumpToModule);
                finish();
            }
        });

        module14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jumpToModule = new Intent(ModuleList.this, ModulesNewPage.class);
                jumpToModule.putExtra("abc",module14.getText().toString());
                startActivity(jumpToModule);
                finish();
            }
        });

        module15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jumpToModule = new Intent(ModuleList.this, ModulesNewPage.class);
                jumpToModule.putExtra("abc",module15.getText().toString());
                startActivity(jumpToModule);
                finish();
            }
        });

        module16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jumpToModule = new Intent(ModuleList.this, ModulesNewPage.class);
                jumpToModule.putExtra("abc",module16.getText().toString());
                startActivity(jumpToModule);
                finish();
            }
        });



    }
}
