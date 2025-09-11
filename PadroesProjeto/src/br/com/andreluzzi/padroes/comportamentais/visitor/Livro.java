package br.com.andreluzzi.padroes.comportamentais.visitor;

public class Livro implements Item {

    private String titulo;
    private double preco;

    public Livro(double preco, String titulo) {
        this.preco = preco;
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public void aceitar(Visitante visitante) {
        visitante.visitar(this);
    }
}
