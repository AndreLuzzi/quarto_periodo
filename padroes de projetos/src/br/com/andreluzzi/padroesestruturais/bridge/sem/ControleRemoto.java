package br.com.andreluzzi.padroesestruturais.bridge.sem;

public class ControleRemoto {

        protected Dispositivo dispositivo;

        public ControleRemoto(Dispositivo dispositivo){
            this.dispositivo = dispositivo;
        }

        public void ligar(){
            dispositivo.ligar();
        }

        public void desligar(){
            dispositivo.desligar();
        }

        public void aumentarVolume(){
            dispositivo.aumentarVolume();
        }
}
