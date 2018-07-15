package com.example.android.tourguideappv1;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


public class MonumentFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_food, container, false);
        ArrayList<LocationClass> locationList = new ArrayList<LocationClass>();
        locationList.add(new LocationClass("name1", "desc1", R.drawable.baseline_account_balance_24));
        locationList.add(new LocationClass("name2", "desc2", R.drawable.baseline_favorite_black_48));

        LocationAdapter locationAdapter = new LocationAdapter(getActivity(), 0, locationList);

        final ListView listView = (ListView) rootView.findViewById(R.id.list);

        listView.setAdapter(locationAdapter);
        // Inflate the layout for this fragment
        return rootView;
    }
}


