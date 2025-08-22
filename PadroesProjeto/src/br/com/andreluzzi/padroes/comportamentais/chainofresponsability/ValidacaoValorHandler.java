package br.com.andreluzzi.padroes.comportamentais.chainofresponsability;

public class ValidacaoValorHandler extends AbstractHandler {
    @Override
    public void processar(String usuario, double valor) {
        if (valor <= 0) {
            System.out.println("Erro: O valor do pagamento deve ser maior que zero.");
            return;
        }
        chamarProximo(usuario, valor);
    }
}
