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
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ListView;
import android.view.View;

public class ModuleSelect extends Activity {
    private Button b1;
    Spinner year, Course;
    ArrayList<String> arrayList_year;
    ArrayAdapter<String> arrayAdapter_year;

    ArrayList<String> arrayList_year1, arrayList_year2, arrayList_year3, arrayList_year4, arrayList_year5;
    ArrayAdapter<String> arrayAdapter_Course;



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
        b1 = (Button) findViewById(R.id.gb);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Mor = new Intent(ModuleSelect.this, Login.class);
                startActivity(Mor);
            }
        });
        year = (Spinner) findViewById(R.id.year);
        Course = (Spinner) findViewById(R.id.course);
        arrayList_year = new ArrayList<>();
        arrayList_year.add("Select Year");
        arrayList_year.add("Year 1");
        arrayList_year.add("Year 2");
        arrayList_year.add("Year 3");
        arrayList_year.add("Year 4");
        arrayList_year.add("Year 5");

        arrayAdapter_year = new ArrayAdapter<>(getApplicationContext(), R.layout.textview_black, arrayList_year);
        year.setAdapter(arrayAdapter_year);

        //Course Spinner process connected with year
        arrayList_year1 = new ArrayList<>();
        arrayList_year1.add("Course");
        arrayList_year1.add("Engineering");
        arrayList_year1.add("BESS");
        arrayList_year1.add("Global Business");
        arrayList_year1.add("Law ");
        arrayList_year1.add("Arts");

        arrayList_year2 = new ArrayList<>();
        arrayList_year2.add("Course");
        arrayList_year2.add("Dual BA");
        arrayList_year2.add("Sociology");
        arrayList_year2.add("Computer Science");
        arrayList_year2.add("Clinical Studies");
        arrayList_year2.add("Speech Language");

        arrayList_year3 = new ArrayList<>();
        arrayList_year3.add("Course");
        arrayList_year3.add("Engineering");
        arrayList_year3.add("BESS");
        arrayList_year3.add("Global Business");
        arrayList_year3.add("Law ");
        arrayList_year3.add("Arts");

        arrayList_year4 = new ArrayList<>();
        arrayList_year4.add("Course");
        arrayList_year4.add("Dual BA");
        arrayList_year4.add("Sociology");
        arrayList_year4.add("Computer Science");
        arrayList_year4.add("Clinical Studies");
        arrayList_year4.add("Speech Language");


        arrayList_year5 = new ArrayList<>();
        arrayList_year5.add("Course");
        arrayList_year5.add("Engineering MAI");
        arrayList_year5.add("MSc Finance");
        arrayList_year5.add("MSc Marketing");
        arrayList_year5.add("MSc Management");
        arrayList_year5.add("PHD");

        year.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (position == 1) {
                    arrayAdapter_Course = new ArrayAdapter<>(getApplicationContext(), R.layout.textview_black, arrayList_year1);
                }

                if (position == 2) {
                    arrayAdapter_Course = new ArrayAdapter<>(getApplicationContext(), R.layout.textview_black, arrayList_year2);
                }

                if (position == 3) {
                    arrayAdapter_Course = new ArrayAdapter<>(getApplicationContext(), R.layout.textview_black, arrayList_year3);
                }

                if (position == 4) {
                    arrayAdapter_Course = new ArrayAdapter<>(getApplicationContext(), R.layout.textview_black, arrayList_year4);
                }

                if (position == 5) {
                    arrayAdapter_Course = new ArrayAdapter<>(getApplicationContext(), R.layout.textview_black, arrayList_year5);
                }

                Course.setAdapter(arrayAdapter_Course);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

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

