package br.com.andreluzzi.padroesestruturais.composite;

public class Fardo {

    private String nome;
    private Caixa caixa;
    private int quantidade;

    public Fardo(){
        this.nome = nome;
        this.caixa = caixa;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco(){
        return caixa.getPreco() * quantidade;
    }

    

}
