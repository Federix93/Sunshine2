package com.example.android.sunshine2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Federico on 22/09/2016.
 */
public class ForecastFragment extends Fragment {

    private ArrayAdapter<String> mForecastAdapter;
    private static final String urlForecastString = "http://api.openweathermap.org/data/2.5/forecast/daily?q=Palermo,it&mode=json&units=metric&cnt=7&appid=41aa007b2c175fad44ef9bead55ff34b";

    public ForecastFragment(){}

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

        HttpURLConnection httpURLConnection = null;
        BufferedReader bufferedReader = null;
        String[] forecastJsonString = null;

        try {
            URL url = new URL(urlForecastString);
            try {
                httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.connect();
                InputStream inputStream = httpURLConnection.getInputStream();
                StringBuffer buffer = new StringBuffer();
                if (inputStream == null){
                    return null;
                }
                bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String line;
                int count = 0;
                while((line = bufferedReader.readLine()) != null){
                    forecastJsonString[count] = line;
                    count++;
                }

                if (buffer.length() == 0){
                    return null;
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (final IOException e) {
                        Log.e("PlaceholderFragment", "Error closing stream", e);
                    }
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        List<String> weekItem = new ArrayList<String>(Arrays.asList(forecast));
        ListView listView = (ListView) root.findViewById(R.id.list_view_forecast);
        mForecastAdapter = new ArrayAdapter<String>(getActivity(), R.layout.list_item_forecast,
                R.id.item_text_view, forecastJsonString);
        listView.setAdapter(mForecastAdapter);
        return root;
    }
}