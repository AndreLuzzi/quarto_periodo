package br.com.andreluzzi.padroescomportamentais.memento;

public class TextoMemento {

    private final String estado;

    public TextoMemento(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }
}
