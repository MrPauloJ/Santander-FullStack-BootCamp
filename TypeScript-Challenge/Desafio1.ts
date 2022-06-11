/*
Desafio 1:
Como podemos rodar isso em um arquivo .ts sem causar erros? 

let employee = {};
employee.code = 10;
employee.name = "John";

*/

// Criando interface
interface CodePessoa{
    name: string,
    code: number
}

// Atribuindo interface
let employee:CodePessoa = {
    code: 10,
    name: "John"
}