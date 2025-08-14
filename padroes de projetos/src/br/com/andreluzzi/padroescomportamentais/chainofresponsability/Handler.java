package br.com.andreluzzi.padroescomportamentais.chainofresponsability;

public interface Handler {
    
    public void setProximo(Handler proximo);
    public void processar(String usuario, double valor);
}
