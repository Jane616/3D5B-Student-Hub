package com.example.studenthub;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Review extends AppCompatActivity {
    RatingBar ratingBar;
    Button checkButton;
    EditText enterRatingText;
    EditText ratingInfo;
    Button submitRatingButton;
    int rating_sum = 0;
    int number_of_ratings = 0;
    int average_rating = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        checkButton = (Button) findViewById(R.id.checkButton);
        enterRatingText = (EditText) findViewById(R.id.enterRatingText);
        submitRatingButton = (Button) findViewById(R.id.submitRatingButton);
        ratingBar.setRating(0);
        ratingInfo = (EditText) findViewById(R.id.ratingInfo);

        submitRatingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String rating_value = enterRatingText.getText().toString();
                Toast.makeText(Review.this, "Stars: " + rating_value, Toast.LENGTH_SHORT).show();
                int star_value = Integer.parseInt(rating_value);
                rating_sum = rating_sum + star_value;
                number_of_ratings++;
                average_rating = rating_sum / number_of_ratings;
                ratingBar.setRating(average_rating);
                ratingInfo.setText("Average Rating:" + average_rating);


            }
        });


        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(Review.this, "Stars: " + rating, Toast.LENGTH_SHORT).show();
            }
        });

        checkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Review.this, "Stars: " + ratingBar.getRating(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
