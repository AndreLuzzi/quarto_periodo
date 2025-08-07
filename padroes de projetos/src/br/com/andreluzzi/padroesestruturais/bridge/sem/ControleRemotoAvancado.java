package br.com.andreluzzi.padroesestruturais.bridge.com;

public class ControleRemotoAvancado extends ControleRemoto {

    public ControleRemotoAvancado(Dispositivo dispositivo){
        super(dispositivo);
    }

    public void silenciar(){
        System.out.println("Dispositivo silenciado");
    }
    
}
