"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
exports.Exercicio1 = void 0;
class Exercicio1 {
    nome;
    idade;
    maiorIdade;
    notas;
    constructor(nome, idade, maioridade, notas) {
        this.nome = nome;
        this.idade = idade;
        this.maiorIdade = maioridade;
        this.notas = notas;
    }
    mostrarDados() {
        console.log("Nome: " + this.nome);
        console.log("idade: " + this.idade);
        console.log("Maior de idade: " + this.maiorIdade);
        console.log("Notas: " + this.notas);
    }
}
exports.Exercicio1 = Exercicio1;
//# sourceMappingURL=exercicio1.js.map