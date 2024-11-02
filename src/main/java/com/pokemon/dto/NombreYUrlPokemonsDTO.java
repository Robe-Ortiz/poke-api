package com.pokemon.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public record NombreYUrlPokemonsDTO(@JsonProperty("results")List<Result> results) {

	public record Result(String name) {}
	
}
