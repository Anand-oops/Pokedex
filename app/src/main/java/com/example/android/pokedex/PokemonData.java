package com.example.android.pokedex;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PokemonData {

    @SerializedName("results")
    private List<Pokemon> results;

    public List<Pokemon> getResults() {
        return results;
    }

    public void setResults(List<Pokemon> results) {
        this.results = results;
    }



    class Pokemon {

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

