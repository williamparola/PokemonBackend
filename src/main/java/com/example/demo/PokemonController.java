package com.example.demo;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
class PokemonController {

  private final PokemonRepository repository;

  PokemonController(PokemonRepository repository) {
    this.repository = repository;
  }
// controllo generale per le azioni ( controller )

  // Aggregate root
  // tag::get-aggregate-root[]
  @GetMapping("/pokemon")
  List<Pokemon> all() {
    return repository.findAll();
  }
  // end::get-aggregate-root[]

  @PostMapping("/pokemon")
  Pokemon newPokemon(@RequestBody Pokemon newPokemon) {
    return repository.save(newPokemon);
  }

  // Single item
  
  @GetMapping("/pokemon/{id}")
  Pokemon one(@PathVariable Long id) {
    
    return repository.findById(id)
      .orElseThrow(() -> new PokemonNotFoundException(id));
  }

  @PutMapping("/pokemon/{id}")
  Pokemon replacePokemon(@RequestBody Pokemon newPokemon, @PathVariable Long id) {
    
    return repository.findById(id)
      .map(pokemon -> {
        pokemon.setName(newPokemon.getName());
        pokemon.setRole(newPokemon.getRole());
        return repository.save(pokemon);
      })
      .orElseGet(() -> {
        newPokemon.setId(id);
        return repository.save(newPokemon);
      });
  }

  @DeleteMapping("/pokemon/{id}")
  void deletePokemon(@PathVariable Long id) {
    repository.deleteById(id);
  }
}