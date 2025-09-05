package br.com.andreluzzi.padroes.comportamentais.templatemethod;

// Classe abstrata que define o template do metodo
public abstract class Bebida {

    // Método Template
    public final void preparar() {
        ferverAgua();
        adicionarIngredientePrincipal();
        adicionarCondimentos();
        servir();
    }

    protected void ferverAgua() {
        System.out.println("Fervendo Água");
    }

    // Passo a ser implementado pela subclasse
    protected abstract void adicionarIngredientePrincipal();

    // Pode ter implementação ou ser redefinido na subclasse
    protected void adicionarCondimentos() {
        //Todo
        //Método gancho
    }

    private void servir() {
        System.out.println("Servindo a bebida");
    }
}
