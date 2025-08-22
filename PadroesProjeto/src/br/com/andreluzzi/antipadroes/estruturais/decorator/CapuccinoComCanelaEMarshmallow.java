package br.com.andreluzzi.antipadroes.estruturais.decorator;

public class CapuccinoComCanelaEMarshmallow extends CapuccinoComCanela {
    @Override
    public double getPreco() {
        return super.getPreco() + 2.00;
    }

    @Override
    public String getDescricao() {
        return super.getDescricao() + " com marshmallow";
    }
}