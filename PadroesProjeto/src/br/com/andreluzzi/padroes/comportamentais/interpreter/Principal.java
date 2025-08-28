package br.com.andreluzzi.padroes.comportamentais.interpreter;

import java.util.Arrays;
import java.util.List;

public class Principal {

    public static void main(String[] args) {
        List<Artigo> artigos = Arrays.asList(
            new Artigo("Arquitetura de Software Moderna"),
            new Artigo("Padrão MVC na Web"),
            new Artigo("Model View Controller explicado"),
            new Artigo("Introdução e Inteligência Artificial"),
            new Artigo("Arquitetura de Software e MVC"),        
            new Artigo("Arquitetura de Software e Model View Controller")
        );

        //Expressão0 da query
        //"arquitetura de software & (mvc or model view controller)"
        Expressao termo1 = new Palavra("arquitetura de software");
        Expressao termo2 = new Palavra("mvc");
        Expressao termo3 = new Palavra("model view controller");

        Expressao or = new OrExpressao(termo2, termo3);
        Expressao query = new AndExpressao(termo1, or);

        //busca de artigos
        for(Artigo artigo: artigos){
            if(query.interpretar(artigo)){
                System.out.println("Encontrado " + artigo.getTitulo());
            }
        }
    }

}
