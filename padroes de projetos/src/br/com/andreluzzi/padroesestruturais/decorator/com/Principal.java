package br.com.andreluzzi.padroesestruturais.decorator.com;

public class Principal {
 
    public static void main(String[] args) {
        
        Cafe cafe = new CafeSimples();
        System.out.println(cafe.getDescricao() + " R$" + cafe.getPreco());
    }
}
