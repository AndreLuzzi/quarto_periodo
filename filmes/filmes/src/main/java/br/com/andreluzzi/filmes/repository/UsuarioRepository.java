package br.com.andreluzzi.filmes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.andreluzzi.filmes.model.Usuario;


public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{


}
