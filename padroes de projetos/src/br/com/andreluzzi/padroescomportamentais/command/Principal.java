package br.com.andreluzzi.padroescomportamentais.command;

public class Principal {

    public static void main(String[] args) {
        Cozinheiro cozinheiro = new Cozinheiro();
        Pedido pizza = new PedidoPizza(cozinheiro);
        Pedido hamburguer = new PedidoHamburguer(cozinheiro);

        Garcom garcom = new Garcom();
        //usar o command
        garcom.enviarPedidos(pizza);
        garcom.enviarPedidos(hamburguer);
    }
}
