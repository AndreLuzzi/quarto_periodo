package br.com.andreluzzi.padroes.comportamentais.strategy;

public class Principal {

    public static void main(String[] args) {

        CarrinhoDeCompras carrinho = new CarrinhoDeCompras();

        PagamentoStrategy debito = new PagamentoCartaoDebito("123-456", "Andre");
        carrinho.setEstrategiaDePagamento(debito);
        carrinho.pagar(520.00);

        PagamentoStrategy credito = new PagamentoCartaoCredito("1234-5678-9101-1121", "Henrique Leonardo");
        carrinho.setEstrategiaDePagamento(credito);
        carrinho.pagar(1890.00);
        
        PagamentoStrategy pix = new PagamentoPix("Andre@outlook.com", "Andre Luzzi");
        carrinho.setEstrategiaDePagamento(pix);
        carrinho.pagar(500.0);
    }
}
