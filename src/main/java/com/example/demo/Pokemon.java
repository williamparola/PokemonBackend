package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.util.Objects;

    
    @Entity  //oggetto entità (annotazione JPA)
        //jPA annotations are used in mapping java objects to the database tables, columns etc. 
class Pokemon {

  private @Id @GeneratedValue Long id;   
  // attributi dell'oggetto Employee, id ha + annotazioni jpa per indicare 
  // che è la chiave primaria
  //costurttore personalizzato?!?
  private String name;
  private String role;
  
  Pokemon() {}
  
  //tutti i metodi get e set di base
  Pokemon(String name, String role) {

    this.name = name;
    this.role = role;
  }

  public Long getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public String getRole() {
    return this.role;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setRole(String role) {
    this.role = role;
  }

  @Override
  public boolean equals(Object o) {

    if (this == o)
      return true;
    if (!(o instanceof Pokemon))
      return false;
    Pokemon pokemon = (Pokemon) o;
    return Objects.equals(this.id, pokemon.id) && Objects.equals(this.name, pokemon.name)
        && Objects.equals(this.role, pokemon.role);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id, this.name, this.role);
  }// produce una sequenza di bit, detta digest, (o una stringa) strettamente correlata con i dati in ingresso.

  @Override
  public String toString() {
    return "Pokemon{" + "id=" + this.id + ", name='" + this.name + '\'' + ", role='" + this.role + '\'' + '}';
  }
}
