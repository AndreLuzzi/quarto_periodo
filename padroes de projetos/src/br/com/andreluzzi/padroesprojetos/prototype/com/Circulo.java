package br.com.andreluzzi.padroesprojetos.prototype.com;

public class Circulo implements Forma {
    int raio;
    String cor;

    public Circulo(int raio, String cor) {
        this.raio = raio;
        this.cor = cor;
    }

    @Override
    public void desenhar() {
        System.out.println("Desenhando circulo " + cor + " com raio " + raio);
    }

    @Override
    public Forma clonar() {
        return new Circulo(this.raio, this.cor);
    }
}
