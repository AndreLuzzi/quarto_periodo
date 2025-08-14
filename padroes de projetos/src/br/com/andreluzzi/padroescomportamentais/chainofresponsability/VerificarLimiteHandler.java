package br.com.andreluzzi.padroescomportamentais.chainofresponsability;

public class VerificarLimiteHandler extends AbstractHandler{

    @Override
    public void processar(String usuario, double valor){
        if(valor > 500){
            System.out.println("Erro: Pagamento excede o limite permitido");
        }
        chamarProximo(usuario, valor);
    }

}
