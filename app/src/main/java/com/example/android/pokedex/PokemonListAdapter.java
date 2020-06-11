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

public class PokemonListAdapter extends RecyclerView.Adapter<PokemonListAdapter.PokemonViewHolder> {

    private static final String TAG ="PokemonListAdapter" ;
    private Context context;
    private String originalID = null;
    private List<PokemonData.Pokemon> pokemonList;
    public PokemonListAdapter(Context ctx,List<PokemonData.Pokemon> pokemons){
        context = ctx;
        pokemonList = pokemons;
    }
    @NonNull
    @Override
    public PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.pokemonlist_item,parent,false);
        return new PokemonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonViewHolder holder, final int position) {
        final PokemonData.Pokemon pokemon = pokemonList.get(position);
        holder.pokemonName.setText(pokemon.getName());
        final String urlId = pokemon.getUrl();
        if (urlId.length() > 0) {
            originalID = urlId.substring(34, urlId.length() - 1);
        }
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
        return pokemonList.size();
    }

    public void filterList(List<PokemonData.Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
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
