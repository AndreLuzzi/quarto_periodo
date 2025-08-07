package br.com.andreluzzi.padroesestruturais.bridge;

public class TvcomControleAvancado {

    public void ligar(){
        System.out.println("TV Ligada");
    }
    
    public void desligar(){
        System.out.println("TV Desligada");
    }

    public void aumentarVolume(){
        System.out.println("Volume da TV aumentada");
    }

    public void mudarCanal(int canal){
        System.out.println("A TV mudou para o canal " + canal);
    }

}
