package br.com.andreluzzi.padroesestruturais.decorator.com;

public class Principal {
 
    public static void main(String[] args) {
        
        Cafe cafe = new CafeSimples();
        System.out.println(cafe.getDescricao() + " R$" + cafe.getPreco());

        Cafe cafeComLeiteAcucar = new Acucar(new Leite(new cafeSimples()));
        System.out.println(cafeComLeiteAcucar.getDescricao() + " R$" + cafeComLeiteAcucar.getPreco());
    }
}
