package com.example.josh.week4daily4_dicks.Model.Data;

import com.example.josh.week4daily4_dicks.Model.Data.DicksResponse.DicksResult;
import com.example.josh.week4daily4_dicks.Utils.NetworkHelper;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RemoteDataSource {

    private Retrofit createInstance(){
        return new Retrofit.Builder()
                .baseUrl(NetworkHelper.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    private RemoteService getRemoteService(){
        return createInstance().create(RemoteService.class);
    }

    public Observable<DicksResult> getDicksResult(String venue){
        return getRemoteService().getDicksLocations(venue);
    }
}
