package com.pokemon.service;

import java.util.List;

import com.pokemon.dto.NombreYUrlPokemonsDTO;
import com.pokemon.entity.Pokemon;


public interface IPokemonService {

	Pokemon getPokemon(String name);
	
	NombreYUrlPokemonsDTO getTodosLosPokemons();
	
	List<Pokemon> getPrimeraGeneracion();
	
	List<Pokemon> getSegundaGeneracion();
	
	List<Pokemon> getTerceraGeneracion();
	
	List<Pokemon> getCuartaGeneracion();
	
	List<Pokemon> getQuintaGeneracion();
	
	List<Pokemon> getSextaGeneracion();
}
