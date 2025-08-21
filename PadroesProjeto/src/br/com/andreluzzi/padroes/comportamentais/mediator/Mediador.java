package br.com.andreluzzi.padroes.comportamentais.mediator;

public interface Mediador {

    void enviarMensagem(String mensagem, Colaborador colaborador);

    void adicionarColaborador(Colaborador colaborador);
}
