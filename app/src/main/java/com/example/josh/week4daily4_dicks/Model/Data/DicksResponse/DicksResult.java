
package com.example.josh.week4daily4_dicks.Model.Data.DicksResponse;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DicksResult {

    @SerializedName("venues")
    @Expose
    private List<Venue> venues = null;

    public List<Venue> getVenues() {
        return venues;
    }

    public void setVenues(List<Venue> venues) {
        this.venues = venues;
    }

}
