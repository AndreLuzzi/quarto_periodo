package br.com.andreluzzi.padroesestruturais.decorator.com;

public class Adocante extends CafeDecorator{

    public Adocante(Cafe cafe){
        super(cafe);
    }

    public double getPreco(){
        return super.getPreco() + 1.50;
    }

    public String getDescricao(){
        return super.getDescricao() + " com adocante";
    }

}
