package br.com.andreluzzi.padroes.comportamentais.templatemethod;

public class Cha extends Bebida {

    @Override
    protected void adicionarIngredientePrincipal() {
        System.out.println("Adicionando saquinho de chá na água...");
    }

    @Override
    protected void adicionarCondimentos() {
        System.out.println("Adicionando limão...");
    }
}
