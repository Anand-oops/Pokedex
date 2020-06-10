package com.example.android.pokedex;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class PokemonListAdapter extends RecyclerView.Adapter<PokemonListAdapter.PokemonViewHolder> {

    private static final String TAG ="PokemonListAdapter" ;
    private Context context;
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
        Picasso.with(context).load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"+(position+1)+".png").into(holder.pokemonImage);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"Clicked",Toast.LENGTH_SHORT).show();
                Log.i(TAG, "onClick: position: "+(position+1));
                //Intent intent = new Intent(context, PokeDetailsActivity.class);
                //String url = pokemon.getUrl();
                //String result = null;
                //if((url!=null)&&(url.length()>0)){
                  //  result = url.substring(0,url.length()-1);
                //}
                //intent.putExtra("url",pokemon.getUrl());
                //context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return pokemonList.size();
    }

    public static class PokemonViewHolder extends RecyclerView.ViewHolder{
        ImageView pokemonImage;
        TextView pokemonName;
        public PokemonViewHolder(@NonNull View itemView) {
            super(itemView);
            pokemonImage = itemView.findViewById(R.id.pokemonImage);
            pokemonName = itemView.findViewById(R.id.pokemonName);
        }
    }
}
