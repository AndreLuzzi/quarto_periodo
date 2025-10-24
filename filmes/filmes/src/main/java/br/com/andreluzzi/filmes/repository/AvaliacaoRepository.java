package br.com.andreluzzi.filmes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.andreluzzi.filmes.model.Avaliacao;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Integer>{

}
