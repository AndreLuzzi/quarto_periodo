package br.com.andreluzzi.padroes.comportamentais.visitor;

public class Principal {

    public static void main(String[] args) {
        Item[] itens = new Item[]{
            new Livro("Padrões de Projeto", 50.0),
            new Livro("Programação Java", 30.0),
            new Fruta("Maçã", 2.5, 10.0),
            new Fruta("Banana", 1.5, 5.0)
        };

        Visitante visitante = new VisitanteCarrinhoCompras();
        for (Item item : itens) {
            item.aceitar(visitante);
        }
    }
}
