package com.example.android.pokedex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void pokemons(View view){
        Intent intent= new Intent(getApplicationContext(), PokemonList.class);
        startActivity(intent);
    }

    public void items(View view){
        Intent intent = new Intent(getApplicationContext(),ItemList.class);
        startActivity(intent);
    }

    public void locations(View view){
        Intent intent = new Intent(getApplicationContext(),LocationList.class);
        startActivity(intent);
    }

    public void types(View view){
        Intent intent = new Intent(getApplicationContext(),PokemonType.class);
        startActivity(intent);
    }

    public void region(View view){
        Intent intent = new Intent(getApplicationContext(), PokemonRegion.class);
        startActivity(intent);
    }
}