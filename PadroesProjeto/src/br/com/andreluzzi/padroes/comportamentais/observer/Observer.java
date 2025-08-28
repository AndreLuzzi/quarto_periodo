package br.com.andreluzzi.padroes.comportamentais.observer;

// Interface Observer que define o método de notificação
public interface Observer {

    void atualizar(String nomeProduto, int quantidade);
}
