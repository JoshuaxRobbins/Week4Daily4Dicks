package com.example.josh.week4daily4_dicks.Model.Data;

import com.example.josh.week4daily4_dicks.Model.Data.DicksResponse.DicksResult;
import com.example.josh.week4daily4_dicks.View.LocationsContract;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class RemoteObserver implements Observer<DicksResult> {
    LocationsCallback callback;

    public RemoteObserver(LocationsCallback callback) {
        this.callback = callback;
    }

    @Override
    public void onSubscribe(Disposable d) {

    }

    @Override
    public void onNext(DicksResult dicksResult) {
        callback.onSuccess(dicksResult.getVenues());
    }

    @Override
    public void onError(Throwable e) {
        callback.onFailure(e.getMessage());
    }

    @Override
    public void onComplete() {

    }
}
