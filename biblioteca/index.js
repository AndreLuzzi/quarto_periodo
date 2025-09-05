/*const cowsay = require('cowsay');

console.log(
    cowsay.think(
        {
            text: "Oi, eu sou uma vaquinha!!",
            e: "00",
            T: "X "
        }
    )
);*/

//--------------------------------------------------------------------------------------------

/*const chalk = require('chalk');
import chalk from 'chalk';
console.log(chalk.blue('Texto azul'));
console.log(chalk.green.bold('Texto verde em negrito'));
console.log(chalk.red.bgYellow('Erro!'));*/

//--------------------------------------------------------------------------------------------

/*const axios = require('axios');
axios.get('https://viacep.com.br/ws/85819040/json/')
 .then(res => console.log(res.data))
 .catch(err => console.error(err))*/

//--------------------------------------------------------------------------------------------

/*const figlet = require('figlet');
figlet('ANDRE COME O BUTÃO!', (err, data) => {
 if (!err) console.log(data);
});*/

//--------------------------------------------------------------------------------------------

/*const _ = require('lodash');
const numeros = [1, 2, 3, 4, 5];
console.log(_.shuffle(numeros)); // embaralha
console.log(_.sum(numeros)); // soma tudo */

//--------------------------------------------------------------------------------------------

/*const dayjs = require('dayjs');
console.log(dayjs().startOf('month').add(1, 'day').set('year', 2018).format('YYYY-MM-DD HH:mm:ss'));*/

//--------------------------------------------------------------------------------------------

/*const { faker } = require('@faker-js/faker');
console.log(faker.person.fullName());
console.log(faker.internet.email());
console.log(faker.location.city());*/

//--------------------------------------------------------------------------------------------

/*fetch("https://viacep.com.br/ws/85819040/json/")
 .then(res => res.json())
 .then(data => console.log(data))
 .catch(err => console.error(err));*/

//--------------------------------------------------------------------------------------------

 const axios = require("axios");
axios.get("https://viacep.com.br/ws/85819040/json/", {
 timeout: 2000 // tempo máximo em milissegundos (2 segundos)
})
.then(res => {
 console.log("Endereço encontrado:");
 console.log(res.data);
})
.catch(err => {
 if (err.code === 'ECONNABORTED') {
 console.error("Erro: a requisição demorou mais que o tempo limite definido!");
 } else {
 console.error("Erro na requisição:", err.message);
 }
});

//Prefiro usar o fetch em requisições simples e rápidas, quando quiser algo nativo sem instalar dependências. Já o axios é melhor para projetos maiores, pois oferece recursos extras (interceptores, tratamento de erros, timeout, suporte automático a JSON), tornando o código mais prático e robusto.


