package com.cindea.pothub.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.cindea.pothub.R;
import com.cindea.pothub.entities.Pothole;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    Context context;
    List<Pothole> potholes;

    public RecyclerViewAdapter(Context context, List<Pothole> potholes) {

        this.context = context;
        this.potholes = potholes;

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Pothole pothole = potholes.get(position);

        setupItem(pothole, holder);

    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return potholes.size();
    }

    private void setupItem(Pothole pothole, MyViewHolder holder) {

        double lat = round(pothole.getLatitude(), 5);
        double lng = round(pothole.getLongitude(), 5);


        String address = pothole.getAddress().replace("#", ", ");
        if (address.length() > 16)
            address = address.substring(0, 15) + ".";
        holder.address.setText(address);
        holder.latlng.setText(lat + ",  " + lng);
        holder.date.setText(pothole.getTimestamp());

        switch (pothole.getIntensity()) {

            case 1:
                holder.icon.setImageResource(R.drawable.ic_green_alert);
                break;
            case 2:
                holder.icon.setImageResource(R.drawable.ic_yellow_alert);
                break;
            case 3:
                holder.icon.setImageResource(R.drawable.ic_red_alert);
                break;
            default:
                break;

        }

    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView address;
        TextView latlng;
        TextView date;
        ImageView icon;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            address = itemView.findViewById(R.id.item_address);
            latlng = itemView.findViewById(R.id.item_latlng);
            date = itemView.findViewById(R.id.item_date);
            icon = itemView.findViewById(R.id.item_icon);

        }
    }

    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

}
