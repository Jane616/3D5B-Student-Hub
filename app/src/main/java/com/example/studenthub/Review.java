package com.example.studenthub;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Review extends AppCompatActivity {
    DatabaseReference reff;
    ModuleData moduleData;
    RatingBar ratingBar;
    EditText enterRatingText;
    EditText ratingInfo;
    Button submitRatingButton;
    Button updateRatingButton;
    float rating_sum = 0;
    float number_of_ratings = 0;
    float average_rating = 0;
    Button postCommentButton;
    EditText postCommentText;
    ListView commentThread;
    ArrayList<String> comments = new ArrayList<String>();
    ArrayAdapter myAdapter1;
    String activeUser = "Admin";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);


        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        enterRatingText = (EditText) findViewById(R.id.enterRatingText);
        submitRatingButton = (Button) findViewById(R.id.submitRatingButton);
        updateRatingButton = (Button) findViewById(R.id.updateRatingButton);
        ratingBar.setRating(0);
        ratingInfo = (EditText) findViewById(R.id.ratingInfo);
        commentThread = (ListView) findViewById(R.id.commentThread);
        postCommentButton = (Button) findViewById(R.id.postCommentButton);
        postCommentText = (EditText) findViewById(R.id.postCommentText);
        moduleData = new ModuleData();

        //Set up list view
        comments.add("Comment Section:");

        myAdapter1 = new ArrayAdapter<String>(
                this, android.R.layout.simple_list_item_1, comments);
        commentThread.setAdapter(myAdapter1);

        postCommentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String commentContent = postCommentText.getText().toString();
                Toast.makeText(Review.this, commentContent, Toast.LENGTH_SHORT).show();
                comments.add(activeUser + ": " + commentContent);
                myAdapter1.notifyDataSetChanged();

                postCommentText.setText("");
            }
        });

        updateRatingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reff = FirebaseDatabase.getInstance().getReference().child("Modules").child("3E3");
                reff.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        String name = dataSnapshot.child("Title").getValue().toString();
                        String rating = dataSnapshot.child("Rating").getValue().toString();
                        ratingInfo.setText("Overall Rating:" + rating);

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        ratingInfo.setText("Error updating");

                    }
                });
            }
        });

        submitRatingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rating_value = enterRatingText.getText().toString();
                Toast.makeText(Review.this, "Stars: " + rating_value, Toast.LENGTH_SHORT).show();
                float star_value = Float.parseFloat(rating_value);
                if(star_value < 0 || star_value > 5){
                    Toast.makeText(Review.this, "Error: Rating must be between 0 and 5", Toast.LENGTH_SHORT).show();
                }
                else{
                    rating_sum = rating_sum + star_value;
                    number_of_ratings++;
                    average_rating = rating_sum / number_of_ratings;
                    moduleData.setName("moduleName");
                    moduleData.setRating(average_rating);
                    reff.push().setValue(moduleData);
                    ratingBar.setRating(average_rating);
                    String string_rating = String.format("%.02f", average_rating);
                    ratingInfo.setText("Overall Rating:" + string_rating);
                }
            }
        });


        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(Review.this, "Stars: " + rating, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
