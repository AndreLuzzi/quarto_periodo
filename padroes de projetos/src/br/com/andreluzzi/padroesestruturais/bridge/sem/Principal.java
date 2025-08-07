package br.com.andreluzzi.padroesestruturais.bridge.sem;

public class Principal {

    public static void main(String[] args) {
        TVcomControleBasico tvbasica = new TVcomControleBasico();
        tvbasica.ligar();
        tvbasica.aumentarVolume();

        RadioComControleAvancado radioAvancado = new RadioComControleAvancado();
        radioAvancado.ligar();
        radioAvancado.mudarEstacao(102.7);
    }
}
