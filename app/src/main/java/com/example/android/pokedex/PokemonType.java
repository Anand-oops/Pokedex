package com.example.android.pokedex;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.agrawalsuneet.dotsloader.loaders.LazyLoader;

import java.util.ArrayList;
import java.util.List;

public class PokemonType extends AppCompatActivity {
    private List<String> pokemonTypes=new ArrayList<>();
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemonlist);
        LazyLoader lazyLoader = findViewById(R.id.loader);
        lazyLoader.setVisibility(View.GONE);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        getData();
    }

    public void getData(){
        pokemonTypes.add("normal");
        pokemonTypes.add("fighting");
        pokemonTypes.add("flying");
        pokemonTypes.add("poison");
        pokemonTypes.add("ground");
        pokemonTypes.add("rock");
        pokemonTypes.add("bug");
        pokemonTypes.add("ghost");
        pokemonTypes.add("steel");
        pokemonTypes.add("fire");
        pokemonTypes.add("water");
        pokemonTypes.add("grass");
        pokemonTypes.add("electric");
        pokemonTypes.add("psychic");
        pokemonTypes.add("ice");
        pokemonTypes.add("dragon");
        pokemonTypes.add("dark");
        pokemonTypes.add("fairy");

        recyclerView.setAdapter(new TypeListAdapter(getApplicationContext(), pokemonTypes));
    }
}
