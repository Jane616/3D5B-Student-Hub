package com.example.studenthub;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ModuleList extends AppCompatActivity {
    DatabaseReference reff;
    //ListView moduleList;
    //String items[] = new String [] {"Module List", "Module 1"};
    //ArrayList<String> moduleItem = new ArrayList<String>();
    ArrayList<String> items = new ArrayList<String>();
    //ArrayAdapter myAdapter1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_module_list);
        ListView listView = (ListView) findViewById(R.id.modulesList);
        final ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(adapter);

        //items.add("Module 1");
        //items.add("Module 2");



        //moduleList = (ListView) findViewById(R.id.modulesList);
        //myAdapter1 = new ArrayAdapter<String>(
                //this, android.R.layout.simple_list_item_1, moduleItem);
        //moduleList.setAdapter(myAdapter1);

        TextView topMsg = findViewById(R.id.modulesTextView);
        String username = "no username";
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null){
            username = user.getDisplayName();
        }
        topMsg.setText(username + "'s Modules");

        reff = FirebaseDatabase.getInstance().getReference().child("User").
                child("User1").child("C_Modules");

        reff.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                if(dataSnapshot.child("Module1").getValue() != null){
                   items.add(dataSnapshot.child("Module1").getValue().toString());
                   adapter.notifyDataSetChanged();

                }

                if(dataSnapshot.child("Module2").getValue() != null){
                    items.add(dataSnapshot.child("Module2").getValue().toString());
                    adapter.notifyDataSetChanged();

                }

                if(dataSnapshot.child("Module3").getValue() != null){
                    items.add(dataSnapshot.child("Module3").getValue().toString());
                    adapter.notifyDataSetChanged();

                }

                if(dataSnapshot.child("Module4").getValue() != null){
                    items.add(dataSnapshot.child("Module4").getValue().toString());
                    adapter.notifyDataSetChanged();

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }


        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Toast.makeText(ModuleList.this, items.get(position), Toast.LENGTH_SHORT).show();
                Intent jumpToModule = new Intent(ModuleList.this, ModulesNewPage.class);
                jumpToModule.putExtra("abc", items.get(position));
                startActivity(jumpToModule);
                finish();

            }
        });


        /*
        module1 = findViewById(R.id.buttonMissed);
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

         */

    }


}
