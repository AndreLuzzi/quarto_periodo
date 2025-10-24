package br.com.andreluzzi.filmes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.andreluzzi.filmes.model.Genero;

public interface GeneroRepository extends JpaRepository<Genero, Integer>{

}
