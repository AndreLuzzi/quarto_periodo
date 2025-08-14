package br.com.andreluzzi.padroescomportamentais.chainofresponsability;

public class VerificarSaldoHandler extends AbstractHandler {

    @Override
    public void processar(String usuario, double valor){
        if(valor > 1000){
            System.out.println("Erro: Saldo insuficiente para " + usuario);
            return;
        }
        chamarProximo(usuario, valor);
    }

}
