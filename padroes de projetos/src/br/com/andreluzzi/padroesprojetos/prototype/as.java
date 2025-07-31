package br.com.andreluzzi.padroesprojetos.prototype;

class Circulo implements Forma {
    int raio;
    String cor;

    public Circulo(int raio, String cor) {
        this.raio = raio;
        this.cor = cor;
    }

    @Override
    public void desenhar() {
        System.out.println("Desenhando círculo " + cor + " com raio " + raio);
    }

    @Override
    public Forma clonar() {
        return new Circulo(this.raio, this.cor);
    }
}
