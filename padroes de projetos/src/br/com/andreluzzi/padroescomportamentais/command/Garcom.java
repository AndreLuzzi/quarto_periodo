package br.com.andreluzzi.padroescomportamentais.command;

public class Garcom {

    public void enviarPedidos(Pedido pedido){
        pedido.executar();
    }
}
