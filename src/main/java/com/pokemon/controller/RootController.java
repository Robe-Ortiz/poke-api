package com.pokemon.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {

    @GetMapping({"", "/"})
    public String redirectToPokemon() {
        return "redirect:/pokemon/inicio";
    }
}
