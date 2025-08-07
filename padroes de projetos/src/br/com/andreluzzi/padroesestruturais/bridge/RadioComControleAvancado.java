package br.com.andreluzzi.padroesestruturais.bridge;

public class RadioComControleAvancado {

       public void ligar(){
        System.out.println("Radio Ligado");
    }
    
    public void desligar(){
        System.out.println("Radio Desligado");
    }

    public void aumentarVolume(){
        System.out.println("Volume do Radio aumentado");
    }

    public void mudarEstacao(double estacao){
        System.out.println("Radio sintonizado na estacao " + estacao + "MHz");
    }

}
