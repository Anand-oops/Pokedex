package com.example.android.pokedex;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TypeSpecificPoke extends AppCompatActivity {
    private static final String TAG = "TypeSpecific";
    private int ID;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemonlist);

        ID = getIntent().getIntExtra("regionId",0);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        getData();
    }

    public void getData(){
        final Call<TypePokemonData> data= PokemonApi.getPokeService().getTypePokemonList(ID);
        data.enqueue(new Callback<TypePokemonData>() {
            @Override
            public void onResponse(@NonNull Call<TypePokemonData> call, @NonNull Response<TypePokemonData> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"Server Error !",Toast.LENGTH_SHORT).show();
                    return;
                }
                TypePokemonData pokemon = response.body();
                recyclerView.setAdapter(new PokemonListAdapter(getApplicationContext(),pokemon.getPokemonList()));
            }

            @Override
            public void onFailure(@NonNull Call<TypePokemonData> call, @NonNull Throwable t) {
                Toast.makeText(getApplicationContext(),"Error! Check Connectivity",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
