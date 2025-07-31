package br.com.andreluzzi.padroesprojetos.prototype;

class Circulo {
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

public class EditorGraficoSemPrototype {
    public static void main(String[] args) {
        Circulo c1 = new Circulo(10, "vermelho");
        c1.desenhar();

        // "Copiando" o círculo
        Circulo copia = new Circulo(c1.raio, c1.cor);
        copia.desenhar();
    }
}