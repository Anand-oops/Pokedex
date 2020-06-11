package com.example.android.pokedex;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.agrawalsuneet.dotsloader.loaders.LazyLoader;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LocationList extends AppCompatActivity {
    RecyclerView recyclerView;
    LazyLoader lazyLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemonlist);
        lazyLoader = findViewById(R.id.loader);
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
                lazyLoader.setVisibility(View.GONE);
                LocationData locationData = response.body();
                recyclerView.setAdapter(new LocationListAdapter(getApplicationContext(),locationData.getResults()));
            }

            @Override
            public void onFailure(@NonNull Call<LocationData> call, @NonNull Throwable t) {
                lazyLoader.setVisibility(View.GONE);
                AlertDialog.Builder dialog = new AlertDialog.Builder(LocationList.this);
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
}
