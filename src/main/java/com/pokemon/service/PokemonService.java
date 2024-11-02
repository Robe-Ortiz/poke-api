package com.pokemon.service;

import java.util.Comparator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.pokemon.dto.NombreYUrlPokemonsDTO;
import com.pokemon.entity.Pokemon;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PokemonService implements IPokemonService {

	private final WebClient webClient;

	@Autowired
	public PokemonService(WebClient.Builder webClientBuilder) {
		this.webClient = webClientBuilder.codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(1048576))
				.build();
	}
	
	private Mono<Pokemon> extraerPokemonDeJson(String url) {
		return webClient.get().uri(url).retrieve().bodyToMono(Pokemon.class);
	}

	public Pokemon getPokemon(String name) {
		String url = "https://pokeapi.co/api/v2/pokemon/" + name;
		return extraerPokemonDeJson(url).block();
	}
	
	public NombreYUrlPokemonsDTO getTodosLosPokemons(){
		String url = "https://pokeapi.co/api/v2/pokemon?limit=100000&offset=0";
		return  webClient.get().uri(url).retrieve().bodyToMono(NombreYUrlPokemonsDTO.class).block();
	}

	public List<Pokemon> getPrimeraGeneracion() {
		return getListaDePokemon(1, 151);
	}
	
	public List<Pokemon> getSegundaGeneracion(){
		return getListaDePokemon(152, 100);
	}
	
	public List<Pokemon> getTerceraGeneracion(){
		return getListaDePokemon(252, 135);
	}
	
	public List<Pokemon> getCuartaGeneracion(){
		return getListaDePokemon(387, 107);
	}
	
	public List<Pokemon> getQuintaGeneracion(){
		return getListaDePokemon(494, 156);
	}
	
	public List<Pokemon> getSextaGeneracion(){
		return getListaDePokemon(650, 72);
	}
	
	private List<Pokemon> getListaDePokemon(int desde, int hasta){
	    List<Pokemon> listaDePokemons = Flux.range(desde, hasta)
		        .flatMap(id -> extraerPokemonDeJson("https://pokeapi.co/api/v2/pokemon/" + id))
		        .collectList()
		        .block(); 	   
	    listaDePokemons.sort(Comparator.comparingInt(Pokemon::id));		    
	    return listaDePokemons;
	}
	
}
