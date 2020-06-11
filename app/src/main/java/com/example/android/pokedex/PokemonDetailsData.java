package com.example.android.pokedex;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import PokeDetails.Ability;
import PokeDetails.Move;
import PokeDetails.Stat;
import PokeDetails.Type;

public class PokemonDetailsData {
    @SerializedName("abilities")
    private List<Ability> abilities;
    @SerializedName("moves")
    private List<Move> moves;
    @SerializedName("base_experience")
    private Integer baseEx;
    @SerializedName("height")
    private Integer height;
    @SerializedName("id")
    private Integer id;
    @SerializedName("name")
    private String name;
    @SerializedName("order")
    private Integer order;
    @SerializedName("stats")
    private List<Stat> stats = null;
    @SerializedName("types")
    private List<Type> types = null;
    @SerializedName("weight")
    private Integer weight;

    public List<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public Integer getBaseEx() {
        return baseEx;
    }

    public void setBaseEx(Integer baseEx) {
        this.baseEx = baseEx;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public List<Stat> getStats() {
        return stats;
    }

    public void setStats(List<Stat> stats) {
        this.stats = stats;
    }

    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }
}
