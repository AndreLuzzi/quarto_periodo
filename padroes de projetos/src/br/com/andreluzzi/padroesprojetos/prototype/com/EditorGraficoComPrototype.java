package br.com.andreluzzi.padroesprojetos.prototype.com;

public class EditorGraficoComPrototype {
    public static void main(String[] args) {
        Forma original = new Circulo(15, "azul");
        original.desenhar();

        Forma copia = original.clonar(); // não importa o tipo concreto
        copia.desenhar();

        Forma copia = original.clonar(); // não importa o tipo concreto
        copia.desenhar();

        Forma retangulo = new Retangulo(30, 20, "verde");
        Forma retanguloCopia = retangulo.clonar();
        retanguloCopia.desenhar();
    }
}
