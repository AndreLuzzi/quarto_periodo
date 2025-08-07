package br.com.andreluzzi.padroesestruturais.bridge.com;

public class Principal {

    public static void main(String[] args) {
        
        Dispositivo tv = new Televisao();
        Dispositivo radio = new Radio();
        Dispositivo projetor = new Projetor();

        //Criar Controle
        ControleRemoto controleBasicoTV = new ControleRemotoBasico(tv);
        ControleRemoto controleBasicoRadio = new ControleRemotoBasico(radio);
        ControleRemoto controleBasicoProjetor = new ControleRemotoAvancado(projetor);

        //usando controles
        controleBasicoTV.ligar();
        controleBasicoTV.aumentarVolume();

        controleBasicoRadio.ligar();
        controleBasicoRadio.desligar();
    }

}
