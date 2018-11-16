package com.example.josh.week4daily4_dicks.Model.Data;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class DicksRepository {

    RemoteDataSource remoteDataSource;

    public DicksRepository(RemoteDataSource remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
    }

    public void getDicksLocations(String venue,final LocationsCallback callback){

        remoteDataSource.getDicksResult(venue)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new RemoteObserver(callback));
    }
}
