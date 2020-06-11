package com.example.android.pokedex;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RegionPokemonData {

    @SerializedName("pokemon_entries")
    private List<Species> pokemonEntry;

    public List<Species> getPokemonEntry() {
        return pokemonEntry;
    }

    public void setPokemonEntry(List<Species> pokemonEntry) {
        this.pokemonEntry = pokemonEntry;
    }

    class Species {
        @SerializedName("entry_number")
        private int entryNumber;
        @SerializedName("pokemon_species")
        private Entry pokemonSpecies;

        public int getEntryNumber() {
            return entryNumber;
        }

        public void setEntryNumber(int entryNumber) {
            this.entryNumber = entryNumber;
        }

        public Entry getPokemonSpecies() {
            return pokemonSpecies;
        }

        public void setPokemonSpecies(Entry pokemonSpecies) {
            this.pokemonSpecies = pokemonSpecies;
        }

        class Entry {
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


