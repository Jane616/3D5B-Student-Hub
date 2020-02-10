package com.example.studenthub;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ModulesNewPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modules_new_page);

        TextView Display = findViewById(R.id.textView);
        Bundle bn = getIntent().getExtras();
        String name = bn.getString("abc");
        Display.setText(String.valueOf(name));
    }
}
