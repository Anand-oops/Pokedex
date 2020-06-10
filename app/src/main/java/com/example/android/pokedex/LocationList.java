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

public class LocationList extends AppCompatActivity {
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
        Call<LocationData> data= PokemonApi.getPokeService().getLocationList();
        data.enqueue(new Callback<LocationData>() {
            @Override
            public void onResponse(@NonNull Call<LocationData> call, @NonNull Response<LocationData> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"Server Error !",Toast.LENGTH_SHORT).show();
                    return;
                }
                LocationData locationData = response.body();
                recyclerView.setAdapter(new LocationListAdapter(getApplicationContext(),locationData.getResults()));
            }

            @Override
            public void onFailure(@NonNull Call<LocationData> call, @NonNull Throwable t) {
                Toast.makeText(getApplicationContext(),"Error! Check Connectivity",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
