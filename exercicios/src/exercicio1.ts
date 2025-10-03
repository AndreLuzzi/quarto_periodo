export class Exercicio1{
    nome: string;
    idade: number;
    maiorIdade: boolean;
    notas: number[];

    constructor(nome: string, idade: number, maioridade: boolean, notas: number[]){
        this.nome = nome;
        this.idade = idade;
        this.maiorIdade = maioridade;
        this.notas = notas;
    }

    mostrarDados(): void{
        console.log("Nome: " + this.nome);
        console.log("idade: " + this.idade);
        console.log("Maior de idade: " + this.maiorIdade);
        console.log("Notas: " + this.notas);
    }
}