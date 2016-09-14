package com.example.android.sunshine2;


import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.container, new PlaceHolderFragment()).commit();
        }
    }

    public static class PlaceHolderFragment extends Fragment{

        private ArrayAdapter<String> mForecastAdapter;

        public PlaceHolderFragment(){}

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View root = inflater.inflate(R.layout.fragment_main, container, false);
            String[] forecast = {
                    "ciao pezzo di merda",
                    "ciao pezzo di fango",
                    "ciao pezzo di feccia",
                    "ciao pezzo di munnizza",
            };

            List<String> weekItem = new ArrayList<String>(Arrays.asList(forecast));
            ListView listView = (ListView) root.findViewById(R.id.list_view_forecast);
            mForecastAdapter = new ArrayAdapter<String>(getActivity(), R.layout.list_item_forecast,
                    R.id.item_text_view, weekItem);
            listView.setAdapter(mForecastAdapter);
            return root;
        }
    }
}
