package br.com.andreluzzi.padroes.comportamentais.iterator;

public interface ColecaoAgregada<T> {

    Iterador<T> criarIterador();
}
