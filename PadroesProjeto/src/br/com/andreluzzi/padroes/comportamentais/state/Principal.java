package br.com.andreluzzi.padroes.comportamentais.state;

public class Principal {

    public static void main(String[] args) {

        MaquinaVenda maquinaVenda = new MaquinaVenda(2);

        System.out.println("---------------------");
        System.out.println("Primeira tentativa SEM INSERIR MOEDA");
        maquinaVenda.acionarAlavanca();

        System.out.println("---------------------");
        System.out.println("Segunda tentativa INSERINDO MOEDA");
        maquinaVenda.inserirMoeda();
        maquinaVenda.acionarAlavanca();

        System.out.println("---------------------");
        System.out.println("Terceira tentativa EJETANDO MOEDA");
        maquinaVenda.inserirMoeda();
        maquinaVenda.ejetarMoeda();

        System.out.println("---------------------");
        System.out.println("Quarta tentativa INSERINDO MOEDA");
        maquinaVenda.inserirMoeda();
        maquinaVenda.acionarAlavanca();

        System.out.println("---------------------");
        System.out.println("Quinta tentativa INSERINDO MOEDA, MAS SEM ESTOQUE");
        maquinaVenda.inserirMoeda();
    }
}
