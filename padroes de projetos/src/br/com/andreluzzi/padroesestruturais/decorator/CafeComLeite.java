package br.com.andreluzzi.padroesestruturais.decorator;

public class CafeComLeite extends Cafe{

     public double getPreco(){
        return super.getPreco() + 2.00;
    }

    public String getDescricao(){
        return super.getDescricao() + " Com Leite";
    }
}
