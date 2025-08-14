package br.com.andreluzzi.padroescomportamentais.chainofresponsability;

public class ProcessarPagamentoHandler extends AbstractHandler{

    @Override
    public  void processar(String usuario, double valor){
        System.out.println("Pagamento de R$ " + valor + " realizado com sucesso para " + usuario);
    }

}
