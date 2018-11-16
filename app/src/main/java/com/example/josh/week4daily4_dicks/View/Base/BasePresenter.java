package com.example.josh.week4daily4_dicks.View.Base;

public interface BasePresenter<V extends BaseView> {

    void onAttach(V view);

    void onDetach();
}

