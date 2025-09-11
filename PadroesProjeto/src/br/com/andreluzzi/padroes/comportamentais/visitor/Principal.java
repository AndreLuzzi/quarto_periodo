package br.com.andreluzzi.padroes.comportamentais.visitor;

public class Principal {

    public static void main(String[] args) {
        Item[] itens = new Item[]{
            new Livro(50.0, "Padrões de Projeto"),
            new Livro(30.0, "Programação Java"),
            new Fruta("Maçã", 2.5, 10.0),
            new Fruta("Banana", 1.5, 5.0)
        };

        Visitante visitante = new VisitanteCarrinhoCompras();
        for (Item item : itens) {
            item.aceitar(visitante);
        }
    }
}
