package br.com.andreluzzi.padroes.comportamentais.strategy;

public class CarrinhoDeCompras {

    private PagamentoStrategy estrategiaDePagamento;

    // Permite definir a estratégia de pagamento
    public void setEstrategiaDePagamento(PagamentoStrategy estrategiaDePagamento) {
        this.estrategiaDePagamento = estrategiaDePagamento;
    }

    // Executar o pagamento usando a estratégia definida
    public void pagar(double valor) {
        estrategiaDePagamento.pagar(valor);
    }
}
