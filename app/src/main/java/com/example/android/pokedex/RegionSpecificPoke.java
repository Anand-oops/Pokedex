package com.example.android.pokedex;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.agrawalsuneet.dotsloader.loaders.LazyLoader;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegionSpecificPoke extends AppCompatActivity {

    private static final String TAG = "RegionSpecificPoke";
    private int ID;
    RecyclerView recyclerView;
    EditText searchText;
    RegionPokemonData pokemon;
    PokemonRegionAdapter pokemonRegionAdapter;
    LazyLoader lazyLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemonlist);
        lazyLoader = findViewById(R.id.loader);
        ID = getIntent().getIntExtra("id", 0);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        searchText = findViewById(R.id.search_text);
        getData();
        searchText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.i(TAG, "afterTextChanged: " + s);
                searchAction(s.toString());
            }
        });
    }

    public void getData(){
        final Call<RegionPokemonData> data= PokemonApi.getPokeService().getRegionPokemonList(ID);
        data.enqueue(new Callback<RegionPokemonData>() {
            @Override
            public void onResponse(@NonNull Call<RegionPokemonData> call, @NonNull Response<RegionPokemonData> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getApplicationContext(), "Server Error !", Toast.LENGTH_SHORT).show();
                    return;
                }
                lazyLoader.setVisibility(View.GONE);
                searchText.setVisibility(View.VISIBLE);
                pokemon = response.body();
                pokemonRegionAdapter = new PokemonRegionAdapter(getApplicationContext(), pokemon.getPokemonEntry());
                recyclerView.setAdapter(pokemonRegionAdapter);
            }

            @Override
            public void onFailure(@NonNull Call<RegionPokemonData> call, @NonNull Throwable t) {
                lazyLoader.setVisibility(View.GONE);
                AlertDialog.Builder dialog = new AlertDialog.Builder(RegionSpecificPoke.this);
                dialog.setMessage("Internet not available, Cross check your internet connectivity and try again");
                dialog.setTitle("Alert !!!");
                dialog.setIcon(android.R.drawable.ic_dialog_alert);
                dialog.setPositiveButton("OK",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int which) {
                                finish();
                            }
                        });
                AlertDialog alertDialog = dialog.create();
                alertDialog.setCancelable(false);
                alertDialog.show();
            }
        });
    }

    public void searchAction(String text) {
        ArrayList<RegionPokemonData.Species> filteredList = new ArrayList<>();
        for (RegionPokemonData.Species pok : pokemon.getPokemonEntry()) {
            if (pok.getPokemonSpecies().getName().toLowerCase().contains(text.toLowerCase())) {
                filteredList.add(pok);
            }
        }
        pokemonRegionAdapter.filterList(filteredList);
    }
}
