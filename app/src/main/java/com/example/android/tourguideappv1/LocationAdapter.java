package com.example.android.tourguideappv1;

import android.app.Activity;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class LocationAdapter extends ArrayAdapter {
    private String mName;
    private String mDescription;
    private int mImageResourceId;
    public LocationAdapter(Activity context, int imageResourceId, ArrayList<LocationClass> words) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, words);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = (View) convertView;

        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        LocationClass location = (LocationClass) getItem(position);

        String name = location.getmName();
        String description = location.getmDescription();
        int imageResourceId = location.getmImageResourceId();

        TextView nameView = (TextView) listItemView.findViewById(R.id.name);
        nameView.setText(name);

        TextView descriptionView = (TextView) listItemView.findViewById(R.id.description);
        descriptionView.setText(description);

        ImageView imageView = (ImageView) listItemView.findViewById(R.id.location_image);
        imageView.setImageResource(imageResourceId);

        return listItemView;

    }
}
