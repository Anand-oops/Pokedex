package com.example.android.pokedex;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PokemonTypeAdapter extends RecyclerView.Adapter<PokemonTypeAdapter.TypeViewHolder> {
    private static final String TAG ="PTA" ;
    private Context context;
    private List<String> pokemonType;

    public PokemonTypeAdapter(Context ctx, List<String> data) {
        context = ctx;
        pokemonType = data;
    }

    @NonNull
    @Override
    public PokemonTypeAdapter.TypeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.pokemontypes_item, parent, false);
        return new TypeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonTypeAdapter.TypeViewHolder holder, final int position) {
        final String type = pokemonType.get(position);
        holder.pokemon_type.setText(type);
        switch (position){
            case 0:holder.type_icon.setImageResource(R.drawable.normal);   break;
            case 1:holder.type_icon.setImageResource(R.drawable.fighting);   break;
            case 2:holder.type_icon.setImageResource(R.drawable.flying);   break;
            case 3:holder.type_icon.setImageResource(R.drawable.poison);   break;
            case 4:holder.type_icon.setImageResource(R.drawable.ground);   break;
            case 5:holder.type_icon.setImageResource(R.drawable.rock);   break;
            case 6:holder.type_icon.setImageResource(R.drawable.bug);   break;
            case 7:holder.type_icon.setImageResource(R.drawable.ghost);   break;
            case 8:holder.type_icon.setImageResource(R.drawable.steel);   break;
            case 9:holder.type_icon.setImageResource(R.drawable.fire);   break;
            case 10:holder.type_icon.setImageResource(R.drawable.water);   break;
            case 11:holder.type_icon.setImageResource(R.drawable.grass);   break;
            case 12:holder.type_icon.setImageResource(R.drawable.electric);   break;
            case 13:holder.type_icon.setImageResource(R.drawable.psychic);   break;
            case 14:holder.type_icon.setImageResource(R.drawable.ice);   break;
            case 15:holder.type_icon.setImageResource(R.drawable.dragon);   break;
            case 16:holder.type_icon.setImageResource(R.drawable.dark);   break;
            case 17:holder.type_icon.setImageResource(R.drawable.fairy);   break;
        }
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(context,RegionSpecificPoke.class);
                intent.putExtra("id",position+1);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return pokemonType.size();
    }

    public static class TypeViewHolder extends RecyclerView.ViewHolder{
        ImageView type_icon;
        TextView pokemon_type;

        public TypeViewHolder(@NonNull View itemView) {
            super(itemView);
            pokemon_type = itemView.findViewById(R.id.pokemon_type);
            type_icon= itemView.findViewById(R.id.type_ic);
        }
    }
}
