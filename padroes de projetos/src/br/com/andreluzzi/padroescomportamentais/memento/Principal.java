package br.com.andreluzzi.padroescomportamentais.memento;

public class Principal {

    public static void main(String[] args) {
        EditorTexto editor = new EditorTexto();
        Historico historico = new Historico();

        //escrever no editor
        editor.escrever("Olá, ");
        historico.salvarMemento(editor.salvar());

        editor.escrever("mundo!");
        historico.salvarMemento(editor.salvar());

        editor.escrever(" Este é um editor de texto!");
        System.out.println("Texto atual: " + editor.mostrarTexto());

        //desfazer
        editor.desfazer(historico.desfazer());
        System.out.println("Após desfazer: " + editor.mostrarTexto());

        //desfazer novamente
        editor.desfazer(historico.desfazer());
        System.out.println("Após desfazer novamente: " + editor.mostrarTexto());
    }
}

