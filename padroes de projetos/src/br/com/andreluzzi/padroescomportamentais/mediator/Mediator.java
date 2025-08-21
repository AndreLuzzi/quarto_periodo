package br.com.andreluzzi.padroescomportamentais.mediator;

public interface Mediator {

    void enviarMensagem(String mensagem, Colaborador colaborador);

    void adicionarColaborador (Colaborador colaborador);
}
