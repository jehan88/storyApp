package com.app.story;

//this model enable user get and send data by easy way

public class Story {

    //this is our model value

    private String mName;
    private String mImageUrl;
    private  String mDescription;

    public Story()
    {
        //empty constractor needed in any class
    }

    //custom constractor as you need to send data

    public Story(String name, String imageUrl, String Des)
    {
        if(name.trim().equals(""))
        {
            name = "No Name";

        }
        mName = name;
        mImageUrl = imageUrl;
        mDescription=Des;
    }

    // next three function to get data as story model

 public String getmName()
 {
     return mName;
 }
 public void setName(String name)
 {
     mName=name;
 }
 public String getImageUrl()
 {
     return mImageUrl;
 }
 public void setImageUrl(String imageUrl)
 {
     mImageUrl=imageUrl;
 }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }
}
