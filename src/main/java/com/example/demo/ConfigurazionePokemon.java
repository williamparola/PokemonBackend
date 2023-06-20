package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
  //dati salvati direttamente nell'applicazione

  @Bean
  CommandLineRunner initDatabase(PokemonRepository repository) {

    return args -> {
      log.info("Preloading " + repository.save(new Pokemon("Bulbasaur", "Erba, Veleno")));
      log.info("Preloading " + repository.save(new Pokemon("Ivysaur", "Erba, Veleno")));
      log.info("Preloading " + repository.save(new Pokemon("Venusaur", "Erba, Veleno")));
      log.info("Preloading " + repository.save(new Pokemon("Charmander", "Fuoco")));
      log.info("Preloading " + repository.save(new Pokemon("Charmeleon", "Fuoco")));
      log.info("Preloading " + repository.save(new Pokemon("Charizard", "Fuoco, Volante")));
      log.info("Preloading " + repository.save(new Pokemon("Squirtle", "Acqua")));
      log.info("Preloading " + repository.save(new Pokemon("Wartortle", "Acqua")));
      log.info("Preloading " + repository.save(new Pokemon("Blastoid", "Acqua")));
    };
  }
  //tutti i pokemon messi
}