package br.com.andreluzzi.padroes.comportamentais.templatemethod;

public class Cafe extends Bebida {

    @Override
    protected void adicionarIngredientePrincipal() {
        System.out.println("Adicionando pó de café na água...");
    }

    @Override
    protected void adicionarCondimentos() {
        System.out.println("Adicionando açucar e leite...");
    }
}
