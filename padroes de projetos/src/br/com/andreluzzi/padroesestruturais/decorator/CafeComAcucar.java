package br.com.andreluzzi.padroesestruturais.decorator;

public class CafeComAcucar extends Cafe{

    public double getPreco(){
        return super.getPreco() + 1.00;
    }

    public String getDescricao(){
        return super.getDescricao() + "Com Acucar";
    }

}
