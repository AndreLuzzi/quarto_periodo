class Animal {
nome: string;
constructor(nome: string) {
this.nome = nome;
}
falar(): void {
console.log(`${this.nome} faz um som.`);
}
}
class Cachorro extends Animal {
falar(): void {
console.log(`${this.nome} late.`);
}
}
const dog = new Cachorro("Rex");
dog.falar(); // Rex late.
