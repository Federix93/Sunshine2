package com.example.android.sunshine2;

import android.app.Fragment;
import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public static class PlaceHolderFragment extends Fragment{

        @Nullable
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View root = inflater.inflate(R.layout.fragment_main, container);
            String[] forecast = {
                    "ciao pezzo di merda",
                    "ciao pezzo di fango",
                    "ciao pezzo di feccia",
                    "ciao pezzo di munnizza",
            };

            List<String> weekItem = new ArrayList<String>(Arrays.asList(forecast));
            return root;
        }
    }
}
