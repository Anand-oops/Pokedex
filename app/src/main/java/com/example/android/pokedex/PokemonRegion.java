package com.example.android.pokedex;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.agrawalsuneet.dotsloader.loaders.LazyLoader;

import java.util.ArrayList;
import java.util.List;

public class PokemonRegion extends AppCompatActivity {
    private List<String> regions=new ArrayList<>();
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
        regions.add("kanto");
        regions.add("johto");
        regions.add("hoenn");
        regions.add("sinnoh");
        regions.add("unova");
        regions.add("kalos");
        regions.add("alola");

        recyclerView.setAdapter(new RegionListAdapter(getApplicationContext(), regions));
    }
}
