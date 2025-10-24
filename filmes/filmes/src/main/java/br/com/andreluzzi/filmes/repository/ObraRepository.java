package br.com.andreluzzi.filmes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.andreluzzi.filmes.model.Obra;

public interface ObraRepository extends JpaRepository<Obra, Integer>{

}
