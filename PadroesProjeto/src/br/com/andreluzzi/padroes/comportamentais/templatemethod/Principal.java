package br.com.andreluzzi.padroes.comportamentais.templatemethod;

public class Principal {

    public static void main(String[] args) {
        Bebida cha = new Cha();
        System.out.println("Preparando Chá:");
        cha.preparar();

        Bebida cafe = new Cafe();
        System.out.println("Preparando Café:");
        cafe.preparar();
    }
}
