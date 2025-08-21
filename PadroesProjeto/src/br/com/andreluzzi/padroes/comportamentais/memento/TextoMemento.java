package br.com.andreluzzi.padroes.comportamentais.memento;

public class TextoMemento {

    private final String estado;

    public TextoMemento(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }
}
