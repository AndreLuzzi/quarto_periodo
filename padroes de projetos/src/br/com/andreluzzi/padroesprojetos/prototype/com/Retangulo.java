package br.com.andreluzzi.padroesprojetos.prototype.com;

public class Retangulo implements Forma {
    int largura;
    int altura;
    String cor;

    public Retangulo(int largura, int altura, String cor) {
        this.largura = largura;
        this.altura = altura;
        this.cor = cor;
    }

    @Override
    public void desenhar() {
        System.out.println("Desenhando retangulo " + cor + " de " + largura + "x" + altura);
    }

    @Override
    public Forma clonar() {
        return new Retangulo(this.largura, this.altura, this.cor);
    }
}