package com.example.josh.week4daily4_dicks.Model.Data;

import com.example.josh.week4daily4_dicks.Model.Data.DicksResponse.DicksResult;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface RemoteService {

    @GET("api/{venue}")
    Observable<DicksResult> getDicksLocations(@Path("venue") String venue);
}
