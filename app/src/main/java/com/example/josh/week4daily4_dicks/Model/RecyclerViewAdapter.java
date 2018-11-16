package com.example.josh.week4daily4_dicks.Model;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.josh.week4daily4_dicks.Model.Data.DicksResponse.Contact;
import com.example.josh.week4daily4_dicks.Model.Data.DicksResponse.Venue;
import com.example.josh.week4daily4_dicks.R;

import org.w3c.dom.Text;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    List<Venue> dicksList;
    public static final String TAG = "_TAG";

    public RecyclerViewAdapter(List<Venue> dicksList) {
        this.dicksList = dicksList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        int itemViewLayout = R.layout.recycler_layout;
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(itemViewLayout,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Venue dick = dicksList.get(position);
        viewHolder.tvRating.setText("Rating: " + dick.getRating() + "");
        if(dick.getContacts().size() != 0)
            viewHolder.tvPhone.setText("#: " +dick.getContacts().get(0).getPhone());

        else
            viewHolder.tvPhone.setText("No Phone Number");
        try{
            viewHolder.tvAddress.setText("Address: " + dick.getLocation().getAddress());
            viewHolder.tvState.setText("State: " + dick.getLocation().getState());
            viewHolder.tvCity.setText("City: " + dick.getLocation().getCity());
        }
        catch (Exception e){
            viewHolder.tvAddress.setText("Location Not Found");
        }





    }

    @Override
    public int getItemCount() {
        return dicksList.size();
    }

    public void add(Venue dick){
        dicksList.add(dick);
        this.notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private final TextView tvRating;
        private final TextView tvPhone;
        private final TextView tvAddress;
        private final TextView tvCity;
        private final TextView tvState;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvRating = itemView.findViewById(R.id.tvRating);
            tvPhone = itemView.findViewById(R.id.tvPhone);
            tvAddress = itemView.findViewById(R.id.tvAddress);
            tvCity = itemView.findViewById(R.id.tvCity);
            tvState = itemView.findViewById(R.id.tvState);


        }

    }
}
