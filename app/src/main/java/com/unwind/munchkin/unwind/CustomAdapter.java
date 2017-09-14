package com.unwind.munchkin.unwind;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Munchkin on 9/11/2017.
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder>{

    private Context context;
    private List<currentBooking> booking;

    public CustomAdapter(Context context, List<currentBooking> booking) {
        this.context = context;
        this.booking = booking;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.card, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        holder.checkin.setText(booking.get(position).getCheckIn());
        holder.checkout.setText(booking.get(position).getCheckOut());
    }
    @Override
    public int getItemCount(){
        return booking.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageView;
        public TextView checkin;
        public TextView checkout;

        public ViewHolder(View itemView){
            super(itemView);

            checkin = (TextView) itemView.findViewById(R.id.checkinText);
            checkout = (TextView) itemView.findViewById(R.id.checkoutText);
            imageView = (ImageView) itemView.findViewById(R.id.image);
        }
    }
}
