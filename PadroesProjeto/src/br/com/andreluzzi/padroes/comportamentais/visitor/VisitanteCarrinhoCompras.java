package br.com.andreluzzi.padroes.comportamentais.visitor;

public class VisitanteCarrinhoCompras implements Visitante {

    @Override
    public void visitar(Livro livro) {
        System.out.println("Livro: " + livro.getTitulo() + " custa " + livro.getPreco());
    }

    @Override
    public void visitar(Fruta fruta) {
        System.out.println("Fruta: " + fruta.getNome() + " custa " + fruta.getPeso() * fruta.getPrecoPorKg());        
    }
}
