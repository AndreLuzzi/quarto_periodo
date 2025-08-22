package br.com.andreluzzi.padroes.comportamentais.chainofresponsability;

interface Handler {
    void setProximo(Handler proximo);
    void processar(String usuario, double valor);
}








