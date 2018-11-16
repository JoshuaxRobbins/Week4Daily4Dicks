package com.example.josh.week4daily4_dicks.View;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.josh.week4daily4_dicks.Model.Data.DicksRepository;
import com.example.josh.week4daily4_dicks.Model.Data.DicksResponse.Venue;
import com.example.josh.week4daily4_dicks.Model.Data.RemoteDataSource;
import com.example.josh.week4daily4_dicks.Model.RecyclerViewAdapter;
import com.example.josh.week4daily4_dicks.R;

import java.util.List;

public class LocationsActivity extends AppCompatActivity implements LocationsContract.View {
    public static final String TAG = "_TAG";
    private RecyclerView rvLocations;
    private LocationsPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locations);
        presenter = new LocationsPresenter(new DicksRepository(new RemoteDataSource()));


    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.onAttach(this);
        presenter.getDicksLocations();

    }

    public void setUpRecyclerView(RecyclerViewAdapter recyclerViewAdapter){
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvLocations = findViewById(R.id.rvLocations);
        rvLocations.setAdapter(recyclerViewAdapter);
        rvLocations.setLayoutManager(layoutManager);
    }


    @Override
    public void showError(String error) {

    }

}
