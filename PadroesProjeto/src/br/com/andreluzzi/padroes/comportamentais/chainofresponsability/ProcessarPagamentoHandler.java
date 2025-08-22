package br.com.andreluzzi.padroes.comportamentais.chainofresponsability;

public class ProcessarPagamentoHandler extends AbstractHandler {
    @Override
    public void processar(String usuario, double valor) {
        System.out.println("Pagamento de R$" + valor + " processado com sucesso para " + usuario);
    }
}