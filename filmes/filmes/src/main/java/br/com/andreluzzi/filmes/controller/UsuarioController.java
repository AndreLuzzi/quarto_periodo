package br.com.andreluzzi.filmes.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.andreluzzi.filmes.model.LoginDTO;
import br.com.andreluzzi.filmes.model.Usuario;
import br.com.andreluzzi.filmes.repository.AvaliacaoRepository;
import br.com.andreluzzi.filmes.repository.UsuarioRepository;

@RestController
@RequestMapping(value="usuario")
public class UsuarioController {

    private final AvaliacaoRepository avaliacaoRepository;

    /*
    * C Create = novo
    * R Read = listar e listar por id
    * U Update = atualizar
    * D Delete = remover
    */

    @Autowired
    UsuarioRepository usuarioRepository;

    UsuarioController(AvaliacaoRepository avaliacaoRepository) {
        this.avaliacaoRepository = avaliacaoRepository;
    }

    @RequestMapping(value="listar", method= RequestMethod.GET)
    public ResponseEntity<List<Usuario>> listar(){
        return ResponseEntity.ok((List<Usuario>) usuarioRepository.findAll());

    }

     //localhost: 8080/usuario/listar/10
    @RequestMapping(value = "listar/{id}", method = RequestMethod.GET)
    public ResponseEntity<Usuario> getById(@PathVariable(value="id") Integer id){
        Optional<Usuario> object = usuarioRepository.findById(id);
        if(object.isPresent()){
            return new ResponseEntity<>(object.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value="novo", method=RequestMethod.POST)
    public ResponseEntity<Usuario> novo(@RequestBody Usuario usuario){
        return new ResponseEntity<Usuario>(usuarioRepository.save(usuario), HttpStatus.OK);
    }

    @RequestMapping(value="remover/(id)", method=RequestMethod.DELETE)
    public ResponseEntity<Usuario> remover (@PathVariable(value= "id") Integer id) {
        Optional<Usuario> object = usuarioRepository.findById(id);
        if(object.isPresent()){
            usuarioRepository.delete(object.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "atualizar/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Usuario> atualizar(@PathVariable(value= "id") Integer id, Usuario novUsuario){
        Optional<Usuario> object = usuarioRepository.findById(id);
        if(object.isPresent()){
            return new ResponseEntity<>(usuarioRepository.save(novUsuario), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody LoginDTO login) {

        // Busca o usuário pelo email
        Usuario usuario = usuarioRepository.findByEmail(login.email);

        // Se existe e a senha confere
        if (usuario != null && usuario.getSenha().equals(login.senha)) {
            return ResponseEntity.ok(usuario); // ou token futuramente
        }

        // Caso inválido
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                            .body("Email ou senha inválidos");
    }
}
