package com.example.android.pokedex;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TypePokemonData {
    @SerializedName("pokemon")
    private List<TypeData> pokemonList;

    public List<TypeData> getPokemonList() {
        return pokemonList;
    }

    public void setPokemonList(List<TypeData> pokemonList) {
        this.pokemonList = pokemonList;
    }

    class TypeData {
        @SerializedName("pokemon")
        private Poke pokemon;

        public Poke getPokemon() {
            return pokemon;
        }

        public void setPokemon(Poke pokemon) {
            this.pokemon = pokemon;
        }

        class Poke {
            @SerializedName("url")
            private String url;
            @SerializedName("name")
            private String name;

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}
