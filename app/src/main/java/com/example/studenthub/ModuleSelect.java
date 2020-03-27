package com.example.studenthub;



import java.util.ArrayList;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ListView;
import android.view.View;

public class ModuleSelect extends Activity {


    ArrayList<String> selectedItems;
    protected void onCreate(Bundle savedInstanceState) {
        //TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.moduleselect);
        //create an ArrayList object to store selected items it
        selectedItems=new ArrayList<String>();



        //test
        ListView chl=(ListView) findViewById(R.id.checkable_list);
        //set multiple selection mode
        chl.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        String[] items={"Module 1","Module 2","Module 3","Module 4","Module 5","Module 6"};
        //supply data itmes to ListView
        ArrayAdapter<String> aa=new ArrayAdapter<String>(this,R.layout.checkable_list_layout,R.id.txt_title,items);
        chl.setAdapter(aa);
        //set OnItemClickListener
        chl.setOnItemClickListener(new OnItemClickListener(){
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // selected item
                String selectedItem = ((TextView) view).getText().toString();
                if(selectedItems.contains(selectedItem))
                    selectedItems.remove(selectedItem); //remove deselected item from the list of selected items
                else
                    selectedItems.add(selectedItem); //add selected item to the list of selected items

            }

        });

    }

    public void showSelectedItems(View view){
        String selItems="";
        for(String item:selectedItems){
            if(selItems=="")
                selItems=item;
            else
                selItems+="/"+item;
        }
        Toast.makeText(this, selItems, Toast.LENGTH_LONG).show();
    }

}
