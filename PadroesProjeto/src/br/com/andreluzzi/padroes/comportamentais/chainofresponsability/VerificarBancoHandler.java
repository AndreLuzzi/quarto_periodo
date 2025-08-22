package br.com.andreluzzi.padroes.comportamentais.chainofresponsability;

public class VerificarBancoHandler extends AbstractHandler {
    @Override
    public void processar(String usuario, double valor) {
        if (!bancoDisponivel()) {
            System.out.println("Erro: Banco indisponível para transações.");
            return;
        }
        chamarProximo(usuario, valor);
    }

    private boolean bancoDisponivel() {
        return true; // Simulação: banco sempre disponível
    }
}