package com.example.android.pokedex;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class LocationListAdapter extends RecyclerView.Adapter<LocationListAdapter.LocationViewHolder> {
    private Context context;
    private List<LocationData.Location> locationList;

    public LocationListAdapter(Context ctx, List<LocationData.Location> items) {
        context = ctx;
        locationList = items;
    }

    @NonNull
    @Override
    public LocationListAdapter.LocationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.locationlist_item, parent, false);
        return new LocationListAdapter.LocationViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LocationListAdapter.LocationViewHolder holder, int position) {
        final LocationData.Location location = locationList.get(position);
        holder.itemName.setText(location.getName());
    }

    @Override
    public int getItemCount() {
        return locationList.size();
    }

    public class LocationViewHolder extends RecyclerView.ViewHolder{
        ImageView itemImage;
        TextView itemName;

        public LocationViewHolder(@NonNull View itemView) {
            super(itemView);
            itemName = itemView.findViewById(R.id.itemName);
        }
    }
}
