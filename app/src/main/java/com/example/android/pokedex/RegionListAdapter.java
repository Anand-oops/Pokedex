package com.example.android.pokedex;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RegionListAdapter extends RecyclerView.Adapter<RegionListAdapter.RegionViewHolder> {
    private static final String TAG = "RA";
    private Context context;
    private List<String> regions;

    public RegionListAdapter(Context ctx, List<String> data) {
        context = ctx;
        regions = data;
    }

    @NonNull
    @Override
    public RegionListAdapter.RegionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.pokemontypes_item, parent, false);
        return new RegionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RegionListAdapter.RegionViewHolder holder, final int position) {
        final String region = regions.get(position);
        holder.pokemon_type.setText(region);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int ID = getRegionId(position + 1);
                Intent intent = new Intent(context, RegionSpecificPoke.class);
                intent.putExtra("id", ID);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    private int getRegionId(int x) {
        int result = 0;
        switch (x) {
            case 1:
                result = 2;
                break;
            case 2:
                result = 3;
                break;
            case 3:
                result = 4;
                break;
            case 4:
                result = 5;
                break;
            case 5:
                result = 8;
                break;
            case 6:
                result = 12;
                break;
            case 7:
                result = 16;
                break;
        }
        return result;
    }

    @Override
    public int getItemCount() {
        return regions.size();
    }


    public static class RegionViewHolder extends RecyclerView.ViewHolder {
        TextView pokemon_type;
        ImageView pokemon_image;

        public RegionViewHolder(@NonNull View itemView) {
            super(itemView);
            pokemon_type = itemView.findViewById(R.id.pokemon_type);
            pokemon_image = itemView.findViewById(R.id.type_ic);
            pokemon_image.setVisibility(View.GONE);
        }
    }
}
