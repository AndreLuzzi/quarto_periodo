package br.com.andreluzzi.padroes.comportamentais.interpreter;

public class Palavra implements Expressao{
    
    private String termo;

    public Palavra(String termo){
        this.termo = termo.toLowerCase();
    }

    @Override
    public boolean interpretar(Artigo artigo){
        return artigo.getTitulo().contains(termo);
    }
}
