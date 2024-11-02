package com.pokemon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pokemon.dto.NombreYUrlPokemonsDTO;
import com.pokemon.entity.Pokemon;
import com.pokemon.service.IPokemonService;

@Controller
@RequestMapping("/pokemon")
public class PokemonController {

	@Autowired
	private IPokemonService pokemonService;

	@ModelAttribute("titulo")
	public String titulo() {
		return "Página de Pokémon";
	}

	@GetMapping("{name}")
	public String getPokemon(@PathVariable String name, Model model) {
		try {
			model.addAttribute("titulo", "Información de "+name);
	    	name = name.toLowerCase();
			Pokemon pokemon = pokemonService.getPokemon(name);
			model.addAttribute("pokemon", pokemonService.getPokemon(name));	
		}catch (Exception e) {
			model.addAttribute("pokemonNull", "Lo siento, el pokémon "+name+" no se ha encontrado.");
		}		
		return "pokemon/pokemon-info";
	}

	@GetMapping("/search")
	public String buscarPokemon(@RequestParam("name") String name, Model model) {

		return getPokemon(name, model);
	}

	@GetMapping("inicio")
	public String getInicio(Model model) {
		model.addAttribute("titulo", "Inicio");
		return "pokemon/index.html";
	}

	@GetMapping("primera-generacion")
	public String getPrimeraGeneracion(Model model) {
		model.addAttribute("pokemons", pokemonService.getPrimeraGeneracion());
		model.addAttribute("titulo", "Primera generación");
		return "pokemon/pokemons-info";
	}

	@GetMapping("segunda-generacion")
	public String getSegundaGeneracion(Model model) {
		model.addAttribute("pokemons", pokemonService.getSegundaGeneracion());
		model.addAttribute("titulo", "Segunda generación");
		return "pokemon/pokemons-info";
	}

	@GetMapping("tercera-generacion")
	public String getTerceraGeneracion(Model model) {
		model.addAttribute("pokemons", pokemonService.getTerceraGeneracion());
		model.addAttribute("titulo", "Tercera generación");
		return "pokemon/pokemons-info";
	}
	
	@GetMapping("cuarta-generacion")
	public String getCuartaGeneracion(Model model) {
		model.addAttribute("pokemons", pokemonService.getCuartaGeneracion());
		model.addAttribute("titulo", "Cuarta generación");
		return "pokemon/pokemons-info";
	}
	
	@GetMapping("quinta-generacion")
	public String getQuintaGeneracion(Model model) {
		model.addAttribute("pokemons", pokemonService.getQuintaGeneracion());
		model.addAttribute("titulo", "Quinta generación");
		return "pokemon/pokemons-info";
	}
	
	@GetMapping("sexta-generacion")
	public String getSextaGeneracion(Model model) {
		model.addAttribute("pokemons", pokemonService.getSextaGeneracion());
		model.addAttribute("titulo", "Sexta generación");
		return "pokemon/pokemons-info";
	}

	@GetMapping("lista-pokemons")
	public String getListaPokemons(Model model) {
		NombreYUrlPokemonsDTO pokemons = pokemonService.getTodosLosPokemons();
		model.addAttribute("titulo", "Lista Pokemons");
		model.addAttribute("pokemons", pokemons.results());
		return "pokemon/lista-pokemons";
	}
}
