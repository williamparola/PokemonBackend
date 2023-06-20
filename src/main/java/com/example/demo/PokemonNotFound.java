package com.example.demo;

class PokemonNotFoundException extends RuntimeException {

	PokemonNotFoundException(Long id) {
	    super("Could not find Pokemon " + id);
	  }
	//segnale di not found
	}
