package br.com.andreluzzi.antipadroes.criacionais.builder;
public class Principal {
    public static void main(String[] args) {
        // Criando uma casa (muito confuso!)
        Casa casa = new Casa("Paredes de tijolo", "Telhado de cerâmica", 2, 4);

        casa.mostrarDetalhes();
    }
}