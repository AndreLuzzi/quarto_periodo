package br.com.andreluzzi.padroesprojetos.prototype;

public interface Forma extends Cloneable {
    Forma clonar();
    void desenhar();
}