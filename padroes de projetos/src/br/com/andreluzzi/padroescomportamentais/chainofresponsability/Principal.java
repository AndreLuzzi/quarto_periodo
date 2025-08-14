package br.com.andreluzzi.padroescomportamentais.chainofresponsability;

public class Principal {
    public static void main(String[] args) {
        //Criar os Handlers
        Handler validacao = new ValidacaoValorHandler();
        Handler saldo = new VerificarSaldoHandler();
        Handler limite = new VerificarLimiteHandler();
        Handler banco = new VerificarBancoHandler();
        Handler processarPagamento = new ProcessarPagamentoHandler();

        //Encadear os Handlers
        validacao.setProximo(saldo);
        saldo.setProximo(limite);
        limite.setProximo(banco);
        banco.setProximo(processarPagamento);


        //Testar o Chain Of Responsability
        System.out.println("Tentando processar pagamento de R$300 para João");
        validacao.processar("João", 300);

        System.out.println("------------------------");
        System.out.println("Tentando processar pagamento de R$700 para Maria");
        validacao.processar("Maria", 700);

    }
}
