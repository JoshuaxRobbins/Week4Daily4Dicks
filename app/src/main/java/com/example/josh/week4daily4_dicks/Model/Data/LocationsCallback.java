package com.example.josh.week4daily4_dicks.Model.Data;

import com.example.josh.week4daily4_dicks.Model.Data.DicksResponse.Venue;

import java.util.List;

public interface LocationsCallback {

    void onSuccess(List<Venue> dicksList);

    void onFailure(String error);
}
