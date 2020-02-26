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
    RatingBar ratingBar;
    EditText enterRatingText;
    EditText ratingInfo;
    EditText ModuleName;
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

        Bundle bn = getIntent().getExtras();
        String modulename = bn.getString("modulename");


        ModuleName = (EditText) findViewById(R.id.ModuleName);
        ModuleName.setText(String.valueOf(modulename));
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        enterRatingText = (EditText) findViewById(R.id.enterRatingText);
        submitRatingButton = (Button) findViewById(R.id.submitRatingButton);
        updateRatingButton = (Button) findViewById(R.id.updateRatingButton);
        ratingBar.setRating(0);
        ratingInfo = (EditText) findViewById(R.id.ratingInfo);
        commentThread = (ListView) findViewById(R.id.commentThread);
        postCommentButton = (Button) findViewById(R.id.postCommentButton);
        postCommentText = (EditText) findViewById(R.id.postCommentText);

        reff = FirebaseDatabase.getInstance().getReference().child("Modules").
                child("Computer Engineering").child("Year 3").child(modulename).
                child("Reviews Page").child("Rating");

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
                reff.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        rating_sum = Float.parseFloat(dataSnapshot.child("Rating Sum").getValue().toString());
                        average_rating = Float.parseFloat(dataSnapshot.child("Average Rating").getValue().toString());
                        String rating_string = dataSnapshot.child("Average Rating").getValue().toString();
                        number_of_ratings = Float.parseFloat(dataSnapshot.child("Number of Ratings").getValue().toString());
                        ratingInfo.setText("Overall Rating:" + rating_string);
                        ratingBar.setRating(average_rating);

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
                    ratingBar.setRating(average_rating);
                    String string_rating = String.format("%.02f", average_rating);
                    ratingInfo.setText("Overall Rating:" + string_rating);
                    reff.child("Average Rating").setValue(average_rating);
                    reff.child("Number of Ratings").setValue(number_of_ratings);
                    reff.child("Rating Sum").setValue(rating_sum);

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
