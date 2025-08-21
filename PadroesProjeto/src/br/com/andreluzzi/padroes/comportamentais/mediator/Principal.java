package br.com.andreluzzi.padroes.comportamentais.mediator;

public class Principal {

    public static void main(String[] args) {
        Mediador mediador = new MediadorConcreto();

        Colaborador colaborador1 = new ColaboradorConcreto(mediador, "Guilherme");
        Colaborador colaborador2 = new ColaboradorConcreto(mediador, "Luís");
        Colaborador colaborador3 = new ColaboradorConcreto(mediador, "Heloisa");

        colaborador1.enviarMensagem("Olá a todos!");
        colaborador2.enviarMensagem("Oi, Guilherme!");
        colaborador3.enviarMensagem("Oi, pessoal!");
    }
}
