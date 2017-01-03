package com.optimalcities.hackmyride.ui.activity;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.optimalcities.hackmyride.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class TripPlanFragment extends Fragment {

    final String MAP_TYPE = "map_poi";
    final String POI_TYPE = "poi_type";

    String poi_search = null;
    boolean map_frag = false;

    public TripPlanFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        map_frag = getArguments().getBoolean(MAP_TYPE,false);
        poi_search = getArguments().getString(POI_TYPE);
        View current_view = inflater.inflate(R.layout.fragment_trip_plan, container, false);
        return current_view;
    }
}
