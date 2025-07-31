package br.com.andreluzzi.padroesprojetos.prototype.sem;

public class Circulo {
    int raio;
    String cor;

    public Circulo(int raio, String cor) {
        this.raio = raio;
        this.cor = cor;
    }

    public void desenhar() {
        System.out.println("Desenhando circulo " + cor + " com raio " + raio);
    }
}