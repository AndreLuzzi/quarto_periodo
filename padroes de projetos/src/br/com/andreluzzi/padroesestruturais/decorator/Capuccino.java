package br.com.andreluzzi.padroesestruturais.decorator;

public class Capuccino extends Cafe{

     public double getPreco(){
        return super.getPreco() + 4.00;
    }

    public String getDescricao(){
        return "Capuccino";
    }

}
