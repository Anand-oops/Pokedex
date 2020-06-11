package com.example.android.pokedex;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ItemData {
    @SerializedName("results")
    private List<Items> results;

    public List<Items> getResults() {   return results; }
    public void setResults(List<Items> results) {   this.results = results; }

    public static class Items {
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
