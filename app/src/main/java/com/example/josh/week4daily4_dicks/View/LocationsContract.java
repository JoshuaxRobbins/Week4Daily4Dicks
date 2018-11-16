package com.example.josh.week4daily4_dicks.View;


import com.example.josh.week4daily4_dicks.Model.Data.DicksResponse.Venue;
import com.example.josh.week4daily4_dicks.Model.RecyclerViewAdapter;
import com.example.josh.week4daily4_dicks.View.Base.BasePresenter;
import com.example.josh.week4daily4_dicks.View.Base.BaseView;

import java.util.List;

public interface LocationsContract {

    interface View extends BaseView {
        void setUpRecyclerView(RecyclerViewAdapter recyclerViewAdapter);

    }

    interface Presenter extends BasePresenter<View> {
        void getAdapterList();
    }
}
