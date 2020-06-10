package com.example.android.pokedex;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LocationData {
    @SerializedName("results")
    private List<LocationData.Location> results;

    public List<LocationData.Location> getResults() {   return results; }
    public void setResults(List<LocationData.Location> results) {   this.results = results; }

    public class Location{

        @SerializedName("name")
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
