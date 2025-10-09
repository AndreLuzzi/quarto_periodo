package br.com.andreluzzi.imdb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OlaController {

    //localhost:8080/ola
    //http://www.andreluzzi.com.br/ola
    @GetMapping("/ola")
    public String ola(){
        return "Olá Mundo! Projeto Springboot";
    }
}
