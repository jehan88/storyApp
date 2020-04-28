package com.app.story;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

 //this Adapter to show our card item in list

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {


    private Context mContext;
    private List<Story> mStories;

    public ImageAdapter(Context context, List<Story> stories)
    {
        mContext = context;
        mStories = stories;

    }
    @Override
    public ImageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.story_item,parent,false);

        return new ImageViewHolder(v);
    }

   //connect data from our model to card and display it

    @Override
    public void onBindViewHolder(ImageViewHolder holder, int position) {

        final Story Current = mStories.get(position);
        holder.textViewName.setText(Current.getmName());
     //   holder.textViewStory.setText(uploadCurrent.getmDescription());
        Picasso.with(mContext)
                .load(Current.getImageUrl())
                .fit()
                .centerCrop()
                .into(holder.imageView);

        holder.viewBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent();

                Intent intent = new Intent(mContext, StoryActivity.class);
                intent.putExtra("TITLE",Current.getmName());
                intent.putExtra("URL",Current.getImageUrl());
                intent.putExtra("STORY",Current.getmDescription());
               mContext.startActivity(intent);
            }
        });
    }

    //this function to get number of items in listView

    @Override
    public int getItemCount() {
        return mStories.size();
    }

    //connect our adepter with xml filr (story_item.xml)

    public class ImageViewHolder extends RecyclerView.ViewHolder
    {

        public TextView textViewName,textViewStory;
        public ImageView imageView;
        public Button viewBt;


        public ImageViewHolder(View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.text_view_name);
            imageView = itemView.findViewById(R.id.image_view_upload);
            viewBt=itemView.findViewById(R.id.text_view_story);
        }
    }
}
