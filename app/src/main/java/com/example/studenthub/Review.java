package com.example.studenthub;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

public class Review extends AppCompatActivity {
    RatingBar ratingBar;
    EditText enterRatingText;
    EditText ratingInfo;
    Button submitRatingButton;
    int rating_sum = 0;
    int number_of_ratings = 0;
    int average_rating = 0;

    Button postCommentButton;
    EditText postCommentText;
    RecyclerView commentDisplay;
    DatabaseReference mDatabase;
    MyRecyclerViewAdapter adapter;
    ListView commentThread;
    ArrayList<String> comments = new ArrayList<String>();
    ArrayAdapter myAdapter1;
    Integer indexVal;
    String item;
    String activeUser = "Admin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);

        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        enterRatingText = (EditText) findViewById(R.id.enterRatingText);
        submitRatingButton = (Button) findViewById(R.id.submitRatingButton);
        ratingBar.setRating(0);
        ratingInfo = (EditText) findViewById(R.id.ratingInfo);
        //commentThread = (ListView) findViewById(R.id.commentThread);
        postCommentButton = (Button) findViewById(R.id.postCommentButton);
        postCommentText = (EditText) findViewById(R.id.postCommentText);
        commentDisplay = (RecyclerView) findViewById(R.id.CommentRecycler);
        commentDisplay.setHasFixedSize(true);
        commentDisplay.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<ReviewDisplay> comments = new ArrayList<>();
        ReviewDisplay comment1 = new ReviewDisplay("user1", "great module", 5);
        ReviewDisplay comment2 = new ReviewDisplay("user2", "lab assignment is too hard", 3);
        ReviewDisplay comment3 = new ReviewDisplay("user3", "worst module of the year", 1);
        comments.add(comment1);
        comments.add(comment2);
        comments.add(comment3);

        adapter = new MyRecyclerViewAdapter(this, comments);
        commentDisplay.setAdapter(adapter);


        //fetch();

        //Set up list view
        /*
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
        */

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
                ratingInfo.setText("Overall Rating:" + average_rating);


            }
        });


        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(Review.this, "Stars: " + rating, Toast.LENGTH_SHORT).show();
            }
        });
    }
/*
    @Override
    protected void onStart(){
        super.onStart();
        adapter.startListening();
    }

    private void fetch() {
        Query query = FirebaseDatabase.getInstance()
                .getReference()
                .child("ReviewTest");

        FirebaseRecyclerOptions<ReviewDisplay> options =
                new FirebaseRecyclerOptions.Builder<ReviewDisplay>()
                        .setQuery(query, new SnapshotParser<ReviewDisplay>() {
                            @NonNull
                            @Override
                            public ReviewDisplay parseSnapshot(@NonNull DataSnapshot snapshot) {
                                return new ReviewDisplay("Admin", "great module", 5.0);
                                //return new ReviewDisplay(snapshot.child("username").getValue().toString(),
                                 //       snapshot.child("comment").getValue().toString(),
                                 //       Double.parseDouble(snapshot.child("rating").getValue().toString()));
                            }
                        })
                        .build();

        adapter = new FirebaseRecyclerAdapter<ReviewDisplay, ReviewDisplayViewHolder>(options) {
            @Override
            public ReviewDisplayViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.review_row, parent, false);

                return new ReviewDisplayViewHolder(view);
            }


            @Override
            protected void onBindViewHolder(ReviewDisplayViewHolder holder, final int position, ReviewDisplay model) {
                holder.setUsername(model.getUsername());
                holder.setRating(model.getRating());
                holder.setComment(model.getComment());

                /*
                holder.root.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(Review.this, String.valueOf(position), Toast.LENGTH_SHORT).show();
                    }
                });


            }

        };
        commentDisplay.setAdapter(adapter);
    }*/
/*
    public static class ReviewDisplayViewHolder extends RecyclerView.ViewHolder{
        View mView;

        public ReviewDisplayViewHolder(@NonNull View itemView) {
            super(itemView);
            mView = itemView;
        }

        public void setUsername(String name){
            TextView username = (TextView) mView.findViewById(R.id.review_username);
            username.setText(name);
        }

        public void setRating(double rate){
            RatingBar rating = (RatingBar) mView.findViewById(R.id.review_rating);
            rating.setRating((int)rate);
        }

        public void setComment(String comm){
            TextView comment = (TextView) mView.findViewById(R.id.review_comment);
            comment.setText(comm);
        }
    }
    */
}
