package br.com.andreluzzi.padroescomportamentais.chainofresponsability;

public class ValidacaoValorHandler extends AbstractHandler {

    @Override
    public void processar(String usuario, double valor){
        if(valor <= 0){
            System.out.println("Erro: O valor do pagamento deve ser maior que 0.");
            return;
        }
        chamarProximo(usuario, valor);
    }

}
