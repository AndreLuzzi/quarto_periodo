package br.com.andreluzzi.padroes.comportamentais.strategy;

public class PagamentoCartaoDebito implements PagamentoStrategy {

    private String numeroConta;
    private String nomeTitular;

    public PagamentoCartaoDebito(String numeroConta, String nomeTitular) {
        this.numeroConta = numeroConta;
        this.nomeTitular = nomeTitular;
    }

    @Override
    public void pagar(double valor) {
        System.out.println("Pagamento de R$" + valor + " realizado com Débito. Titular: " + nomeTitular + " Conta " + numeroConta);
    }
}
