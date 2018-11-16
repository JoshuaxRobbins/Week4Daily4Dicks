package com.example.josh.week4daily4_dicks.View;

import android.util.Log;

import com.example.josh.week4daily4_dicks.Model.Data.DicksRepository;
import com.example.josh.week4daily4_dicks.Model.Data.DicksResponse.Venue;
import com.example.josh.week4daily4_dicks.Model.Data.LocationsCallback;
import com.example.josh.week4daily4_dicks.Model.RecyclerViewAdapter;

import java.util.List;

public class LocationsPresenter implements LocationsContract.Presenter{
    public static final String TAG = "_TAG";
    LocationsContract.View view;
    DicksRepository dicksRepository;

    public LocationsPresenter(DicksRepository dicksRepository) {
        this.dicksRepository = dicksRepository;
    }

    @Override
    public void getAdapterList() {

    }

    @Override
    public void onAttach(LocationsContract.View view) {
        this.view = view;
    }

    @Override
    public void onDetach() {
        this.view = null;
    }

    public void getDicksLocations(){
        dicksRepository.getDicksLocations("venue", new LocationsCallback() {
            @Override
            public void onSuccess(List<Venue> dicksList) {
                RecyclerViewAdapter adapter = new RecyclerViewAdapter(dicksList);
                view.setUpRecyclerView(adapter);
            }

            @Override
            public void onFailure(String error) {
                Log.d(TAG, "onFailure: " + error);
            }
        });
    }

}
