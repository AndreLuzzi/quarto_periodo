package br.com.andreluzzi.padroesprojetos.prototype.sem;

public class EditorGraficoSemPrototype {
    public static void main(String[] args) {
        Circulo c1 = new Circulo(10, "vermelho");
        c1.desenhar();

        // "Copiando" o círculo
        Circulo copia = new Circulo(c1.raio, c1.cor);
        copia.desenhar();
    }
}
