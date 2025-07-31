package br.com.andreluzzi.padroesprojetos.prototype;

public class Circulo {
    int raio;
    String cor;

    public Circulo(int raio, String cor) {
        this.raio = raio;
        this.cor = cor;
    }

    public void desenhar() {
        System.out.println("Desenhando círculo " + cor + " com raio " + raio);
    }
}