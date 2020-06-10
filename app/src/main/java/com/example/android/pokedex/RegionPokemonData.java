package com.example.android.pokedex;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RegionPokemonData {

    @SerializedName("pokemon_entries")
    private List<PokemonData.Pokemon> pokemonList;

    public List<PokemonData.Pokemon> getPokemonList() {
        return pokemonList;
    }
    public void setPokemonList(List<PokemonData.Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
    }
}

