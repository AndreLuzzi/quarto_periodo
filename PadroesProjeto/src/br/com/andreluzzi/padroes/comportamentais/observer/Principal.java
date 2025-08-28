package br.com.andreluzzi.padroes.comportamentais.observer;

public class Principal {

    public static void main(String[] args) {

        // Criando o produto
        Produto produto = new Produto("Notebook", 500);

        // Criando observadores
        Cliente cliente1 = new Cliente("André");
        Cliente cliente2 = new Cliente("Leonardo");
        Cliente cliente3 = new Cliente("Henrique");
        Cliente cliente4 = new Cliente("Alan");
        Cliente cliente5 = new Cliente("Letícia");

        // Registrando os clientes para receber notificações sobre o produto
        produto.adicionarObservador(cliente1);
        produto.adicionarObservador(cliente2);
        produto.adicionarObservador(cliente3);
        produto.adicionarObservador(cliente4);
        produto.adicionarObservador(cliente5);

        // Modificar estado do produto
        produto.setQuantidade(450);

        // Remover observador
        produto.removerObservador(cliente3);
        produto.setQuantidade(357);
    }
}
