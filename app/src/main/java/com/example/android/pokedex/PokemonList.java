package com.example.android.pokedex;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PokemonList extends AppCompatActivity {

    private static final String TAG = "PokemonList";
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemonlist);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        getData();
    }

    public void getData(){
        final Call<PokemonData> data= PokemonApi.getPokeService().getPokemonList();
        data.enqueue(new Callback<PokemonData>() {
            @Override
            public void onResponse(@NonNull Call<PokemonData> call, @NonNull Response<PokemonData> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"Server Error !",Toast.LENGTH_SHORT).show();
                    return;
                }
                PokemonData pokemon = response.body();
                recyclerView.setAdapter(new PokemonListAdapter(getApplicationContext(),pokemon.getResults()));
            }

            @Override
            public void onFailure(@NonNull Call<PokemonData> call, @NonNull Throwable t) {
                Toast.makeText(getApplicationContext(),"Error! Check Connectivity",Toast.LENGTH_SHORT).show();
                }
        });
    }
}