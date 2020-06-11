package com.example.android.pokedex;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public class PokemonApi {
    public static final String BASE_URL="https://pokeapi.co/api/v2/";

    public static PokemonAPiInterface pokeService = null;
    public static PokemonAPiInterface getPokeService(){
        if(pokeService==null){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            pokeService = retrofit.create(PokemonAPiInterface.class);
        }
        return pokeService;
    }

    public interface PokemonAPiInterface {

        @GET("pokemon/?limit=964&offset=0")
        Call<PokemonData> getPokemonList();

        @GET("pokemon/{id}/")
        Call<PokemonDetailsData> getPokemonDetails(@Path("id") String id);

        @GET("item/?limit=1000")
        Call<ItemData> getItemsList();

        @GET("location/?limit=781")
        Call<LocationData> getLocationList();

        @GET("pokedex/{id}/")
        Call<RegionPokemonData> getRegionPokemonList(@Path("id") int ID);

        @GET("type/{id}/")
        Call<TypePokemonData> getTypePokemonList(@Path("id") int ID);
    }
}
