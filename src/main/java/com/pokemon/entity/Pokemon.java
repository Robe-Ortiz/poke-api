package com.pokemon.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Pokemon(
        Integer id,
        String name,
        double height,
        double weight,
        @JsonProperty("sprites") Sprites sprites
) {	
    public record Sprites(
            @JsonProperty("front_default") String frontDefault,
            @JsonProperty("back_default") String backDefault,
            @JsonProperty("front_shiny") String frontShiny,
            @JsonProperty("back_shiny") String backShiny,
            @JsonProperty("other") Other other 
    ) {
        public record Other(
                @JsonProperty("official-artwork") OfficialArtwork officialArtwork 
        ) {
            public record OfficialArtwork(
                    @JsonProperty("front_default") String frontDefault 
            ) {}
        }
    }
}
