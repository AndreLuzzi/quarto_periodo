package br.com.andreluzzi.padroes.comportamentais.visitor;

public interface Visitante {

    void visitar(Livro livro);

    void visitar(Fruta fruta);
}
