package com.example.android.tourguideappv1;

public class LocationClass {
    private String mName;
    private String mDescription;
    private int mImageResourceId;

    public LocationClass(String name){
        mName = name;
    }

    public LocationClass(String name, String description){
        mName = name;
        mDescription = description;
    }

    public LocationClass(String name, String description, int imageResourceId){
        mName = name;
        mDescription = description;
        mImageResourceId = imageResourceId;
    }

    public int getmImageResourceId() {
        return mImageResourceId;
    }

    public String getmName() {
        return mName;
    }

    public String getmDescription() {
        return mDescription;
    }


}
