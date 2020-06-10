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

public class ItemList extends AppCompatActivity {
    private static final String TAG = "ItemList";
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
        Call<ItemData> data= PokemonApi.getPokeService().getItemsList();
        data.enqueue(new Callback<ItemData>() {
            @Override
            public void onResponse(@NonNull Call<ItemData> call, @NonNull Response<ItemData> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"Server Error !",Toast.LENGTH_SHORT).show();
                    return;
                }
                ItemData itemData = response.body();
                recyclerView.setAdapter(new ItemListAdapter(getApplicationContext(),itemData.getResults()));
            }

            @Override
            public void onFailure(@NonNull Call<ItemData> call,@NonNull Throwable t) {
                Toast.makeText(getApplicationContext(),"Error! Check Connectivity",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
