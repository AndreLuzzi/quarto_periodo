package br.com.andreluzzi.padroescomportamentais.chainofresponsability;

public class VerificarBancoHandler extends AbstractHandler{

    @Override
    public void processar(String usuario, double valor){
        if(bancoDisponivel()){
            System.out.println("Erro: Banco indisponivel para transações");
            return;
        }
        chamarProximo(usuario, valor);
    }

    private boolean bancoDisponivel(){
        return true;//simular banco sempre disponivel
    }

}
