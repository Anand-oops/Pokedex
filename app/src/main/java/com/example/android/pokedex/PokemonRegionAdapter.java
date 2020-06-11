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

import com.squareup.picasso.Picasso;

import java.util.List;

public class PokemonRegionAdapter extends RecyclerView.Adapter<PokemonRegionAdapter.PokemonViewHolder> {

    private Context context;
    private List<RegionPokemonData.Species> regionPokemonData;
    private String originalID = null;

    public PokemonRegionAdapter(Context ctx, List<RegionPokemonData.Species> pokemons) {
        context = ctx;
        regionPokemonData = pokemons;
    }

    @NonNull
    @Override
    public PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.pokemonlist_item, parent, false);
        return new PokemonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonViewHolder holder, final int position) {
        final String urlId = regionPokemonData.get(position).getPokemonSpecies().getUrl();
        if (urlId.length() > 0) {
            originalID = urlId.substring(42, urlId.length() - 1);
        }
        holder.pokemonName.setText(regionPokemonData.get(position).getPokemonSpecies().getName());
        Picasso.with(context).load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/" + originalID + ".png").into(holder.pokemonImage);
        final String result = originalID;
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PokemonDetails.class);
                intent.putExtra("ID", result);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return regionPokemonData.size();
    }

    public void filterList(List<RegionPokemonData.Species> pokemonList) {
        this.regionPokemonData = pokemonList;
        notifyDataSetChanged();
    }

    public static class PokemonViewHolder extends RecyclerView.ViewHolder {
        ImageView pokemonImage;
        TextView pokemonName;

        public PokemonViewHolder(@NonNull View itemView) {
            super(itemView);
            pokemonImage = itemView.findViewById(R.id.pokemonImage);
            pokemonName = itemView.findViewById(R.id.pokemonName);
        }
    }
}
