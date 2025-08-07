package br.com.andreluzzi.padroesestruturais.decorator.com;

public abstract class CafeDecorator implements Cafe{

    protected Cafe cafe;

    public CafeDecorator(Cafe cafe){
        this.cafe = cafe;
    }

    @Override
    public double getPreco(){
        return cafe.getPreco();
    }

    @Override
    public String getDescricao(){
        return cafe.getDescricao();
    }

}
