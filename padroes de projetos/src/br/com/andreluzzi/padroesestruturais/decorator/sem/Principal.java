package br.com.andreluzzi.padroesestruturais.decorator.sem;

public class Principal {

    public static void main(String[] args) {
        Cafe cafeSimples = new Cafe();
        System.out.println(cafeSimples.getDescricao() + " R$" + cafeSimples.getPreco());

        Cafe CafeComLeite = new CafeComLeite();
        System.out.println(CafeComLeite.getDescricao() + " R$" + CafeComLeite.getPreco());

        Capuccino capuccino = new Capuccino();
        System.out.println(capuccino.getDescricao() + " R$" + capuccino.getPreco());
    }

}
