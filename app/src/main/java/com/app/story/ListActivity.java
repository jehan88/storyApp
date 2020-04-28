package com.app.story;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {

    //connect every item in (activity_list) with java code
    // and connect adapter with java code to display list of custom card

    private ImageAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private Button addBT;
    private ProgressBar mProgressCircle;

    private DatabaseReference mDatabaseRef;
    private List<Story> mStories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        // every item in (activity_list) have id we get it to connect with view

        addBT = findViewById(R.id.add_bt);
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        mProgressCircle = findViewById(R.id.progress_circle);
        mStories = new ArrayList<>();

        //this line to get reference from Firebase_DATABASE
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("uploads");

        //get stories item from database
        mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Story story = postSnapshot.getValue(Story.class);
                    mStories.add(story);
                }
                mAdapter = new ImageAdapter(ListActivity.this, mStories);

                mRecyclerView.setAdapter(mAdapter);
                mProgressCircle.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(ListActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                mProgressCircle.setVisibility(View.INVISIBLE);
            }
        });


        //with click on add Button you will go to Upload Screen

        addBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            startActivity(new Intent(ListActivity.this, UploadStory.class));
            }
        });
    }


}
