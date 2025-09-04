const express = require('express');
const app = new express();

//Adicionar pasta public como ponto de entrada para o sistema
app.use(express.static('public'));
//Adiciona suporte para JSON no body das requisições
app.use(express.json());

//Rotas usando Restful
//app.get - retorna dados
//app.post - salva dados
//app.put - editar dados
//app.del - deletar dados

//acessar com localhost:3000/
app.get("/", (requisicao, resposta) => {
    console.log("entrou rota ...")
    resposta.send("Olá mundo");
});

app.get("/professor", (req, res) => {
    let resposta = [
        {id: 1, nome: "Andre Luzzi", profissao: "Militar"},
        {id: 2, nome: "Guilherme", profissao: "Professor"},
        {id:3, nome: "Roberta", profissao: "Professora"}      
    ];
    res.json(resposta);
});

app.listen(3000, () => {
    console.log('Servidor rodando na porta 3000');
});