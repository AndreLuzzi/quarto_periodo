package br.com.andreluzzi.antipadroes.criacionais.factorymethod;

// Implementação específica para transporte via caminhão
public class Caminhao extends Transporte {
    @Override
    public void entregar() {
        System.out.println("Entrega sendo feita por caminhão.");
    }
}
