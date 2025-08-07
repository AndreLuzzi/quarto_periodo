package br.com.andreluzzi.padroesestruturais.decorator;

public class CapuccinoComCanela extends Capuccino{

     public double getPreco(){
        return super.getPreco() + 1.50;
    }

    public String getDescricao(){
        return super.getDescricao() + " Com Canela";
    }

}
