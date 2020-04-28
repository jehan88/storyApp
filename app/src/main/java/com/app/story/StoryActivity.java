package com.app.story;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

    //this view to display every full story in one screen

public class StoryActivity extends AppCompatActivity {
    //connect xml file with java code
ImageView image;
TextView Title,Story;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
      //connect by id
        image=findViewById(R.id.storyImage);
        Title=findViewById(R.id.stortTitle);
        Story=findViewById(R.id.StoryTV);

// get data from intent
        Intent i=this.getIntent();
        String title=i.getExtras().getString("TITLE");
        String url=i.getExtras().getString("URL");
        String story=i.getExtras().getString("STORY");

        //this function to display image

        Picasso.with(this)
                .load(url)
                .fit()
                .centerCrop()
                .into(image);
// this two line to display text (title / story)
        Title.setText(title);
        Story.setText(story);




    }
}
