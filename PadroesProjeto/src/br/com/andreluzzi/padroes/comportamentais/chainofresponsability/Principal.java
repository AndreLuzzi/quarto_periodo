package br.com.andreluzzi.padroes.comportamentais.chainofresponsability;

public class Principal {
// Classe principal para testar
    public static void main(String[] args) {
        // Criando os handlers
        Handler validacao = new ValidacaoValorHandler();
        Handler saldo = new VerificarSaldoHandler();
        Handler limite = new VerificarLimiteHandler();
        Handler banco = new VerificarBancoHandler();
        Handler processador = new ProcessarPagamentoHandler();

        // Encadeando os handlers na ordem correta
        validacao.setProximo(saldo);
        saldo.setProximo(limite);
        limite.setProximo(banco);
        banco.setProximo(processador);

        // Testando o Chain of Responsibility
        System.out.println("Tentando processar pagamento de R$300 para João:");
        validacao.processar("João", 300);

        System.out.println("\nTentando processar pagamento de R$700 para Maria:");
        validacao.processar("Maria", 700);
    }
}