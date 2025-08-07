package br.com.andreluzzi.padroesestruturais.composite;

public class Principal {

    public static void main(String[] args) {
        Produto leite = new Produto("Leite 1L", 5.00);
        Caixa caixaDeLeite = new Caixa("Caixa de leite", leite, 12);
        Fardo dardoLeite = new Fardo()

        double total = leite.getPreco() + caixaDeLeite.getPreco() + fardoLeite.getPreco();
        System.out.println("Total compra: R$" + total);
    }

}
