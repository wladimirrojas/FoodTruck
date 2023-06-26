package com.foodapp.foodtruck.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PokemonDto {

    private int id;
    private String name;
    @JsonProperty("base_experience")
    private int baseExperience;
    private int height;
    @JsonProperty("is_default")
    private boolean isDefault;
    private int order;
    private int weight;
    private List<Object> abilities;
    private List<Object> forms;
    @JsonProperty("game_indices")
    private List<Object> gameIndices;
    @JsonProperty("held_items")
    private List<Object> heldItems;
    @JsonProperty("location_area_encounters")
    private String locationAreaEncounters;
    private List<Object> moves;
    private Object species;
    private Object sprites;
    private List<Object> stats;
    private List<Object> types;
    @JsonProperty("past_types")
    private List<Object> pastTypes;
}
