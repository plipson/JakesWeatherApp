package com.plipson.jakesweatherapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class ForecastFragment extends Fragment {

    private ArrayAdapter<String> mForecastAdapter;

    public ForecastFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        // fake list
        String[] dummy = {
                "Today - Sunny - 87/66",
                "Tomorrow - Rainy - 87/66",
                "Wednesday - Snowy - 87/66",
                "AnotherDay - Dark - 87/66",
                "SomeDay - Dingy - 87/66"
        };
        // real data at:
        // http://api.openweathermap.org/data/2.5/forecast/daily?q=San%20Francisco&mode=json&units=metric&cnt=16

        List<String> dummyList = new ArrayList<String>(Arrays.asList(dummy));

        // ArrayAdapter(Context context, int resource, int textViewResourceId, List<T> objects)
        // list_item_forecast_textview  list_view_forecast
        // the 'list_item_forecast' isn't an XML object, it's an XML file??
        mForecastAdapter = new ArrayAdapter<String>(getActivity(),
                R.layout.list_item_forecast, R.id.list_item_forecast_textview, dummyList);

        // ok, so who USES the adapter?
        ListView lv = (ListView)rootView.findViewById(R.id.list_view_forecast);
        lv.setAdapter(mForecastAdapter);

//        URL url = new URL("http://api.openweathermap.org/data/2.5/forecast/daily?q=San%20Francisco&mode=json&units=metric&cnt=16");
        getWeatherData gwd = new getWeatherData();
        gwd.execute("http://api.openweathermap.org/data/2.5/forecast/daily?q=San%20Francisco&mode=json&units=metric&cnt=16");

        return rootView;

    }
}