# Curso Java - Unibave 2026

Repositório com os exercícios e exemplos desenvolvidos durante o curso de Java da Unibave.

## Professores

| Nome | GitHub |
|------|--------|
| Victor Oliveira Rodrigues | [<img src="https://github.com/favicon.ico" width="16"/> victolirodrigues](https://github.com/victolirodrigues) |
| Gabryel Bagio Bardini | [<img src="https://github.com/favicon.ico" width="16"/> ByelBardini](https://github.com/ByelBardini) |

## Conteúdo

### Aula 01 — [PrimeiraAula.java](aula-01/PrimeiraAula.java)

Introdução ao Java com leitura de dados via terminal e lógica de compra com validações.

**Conceitos abordados:**
- Entrada de dados com `Scanner`
- Tipos primitivos: `int`, `double`, `boolean`, `String`
- Operadores aritméticos e lógicos
- Estruturas condicionais (`if/else`)
- Laço de repetição (`for`)

### Aula 02 — Métodos em Java

Criação e chamada de métodos sem e com parâmetros, sobrecarga, e separação em classes.

**Parte 1 — Métodos sem parâmetros**
- [Parte-1-1/Metodos.java](aula-02/parte-1/Parte-1-1/Metodos.java) — métodos na mesma unnamed class
- [Parte-1-2/Metodos.java](aula-02/parte-1/Parte-1-2/Metodos.java) + [Calculadora.java](aula-02/parte-1/Parte-1-2/Calculadora.java) — métodos em classe separada

**Parte 2 — Métodos com parâmetros**
- [Parte-2-1/Metodos.java](aula-02/parte-2/Parte-2-1/Metodos.java) — métodos parametrizados na mesma classe
- [Parte-2-2/Metodos.java](aula-02/parte-2/Parte-2-2/Metodos.java) + [CalculadoraParametrizada.java](aula-02/parte-2/Parte-2-2/CalculadoraParametrizada.java) + [Impressora.java](aula-02/parte-2/Parte-2-2/Impressora.java) — métodos parametrizados em classes separadas

**Conceitos abordados:**
- Declaração e chamada de métodos (`void` e com retorno)
- Parâmetros e argumentos
- Sobrecarga de métodos (overloading)
- Separação de responsabilidades em classes
- `Math.PI`, `Math.random()`, `java.time.LocalDate`

### Aula 03 — Orientação a Objetos

Introdução à programação orientada a objetos: criação de classes, objetos, passagem por referência e encapsulamento.

**Parte 1 — Objetos e Métodos (sem get/set)**
- [Parte-1-1/Pessoa.java](aula-03/parte-1/Parte-1-1/Pessoa.java) + [Main.java](aula-03/parte-1/Parte-1-1/Main.java) — passagem de objetos e primitivos para métodos; referência vs. valor
- [Parte1-2/ContaBancaria.java](aula-03/parte-1/Parte1-2/ContaBancaria.java) + [Main.java](aula-03/parte-1/Parte1-2/Main.java) — métodos que recebem objetos e chamam comportamentos; transferência entre objetos

**Parte 2 — Encapsulamento com get/set**
- [Parte-2-1/Produto.java](aula-03/Parte-2/Parte-2-1/Produto.java) + [Main.java](aula-03/Parte-2/Parte-2-1/Main.java) — campos `private` com getters e setters simples
- [Parte-2-2/Funcionario.java](aula-03/Parte-2/Parte-2-2/Funcionario.java) + [Main.java](aula-03/Parte-2/Parte-2-2/Main.java) — setters com validação; proteção do estado do objeto

**Conceitos abordados:**
- Classes e objetos
- Campos públicos vs. privados
- Passagem de objetos por referência e primitivos por valor
- Getters e setters
- Encapsulamento e validação de dados nos setters

### Aula 04 — Herança e Interfaces

Aprofundamento em orientação a objetos: herança entre classes, sobrescrita de métodos e contratos com interfaces.

**Parte 1 — Classes e construtores**
- [parte-1/Pessoa.java](aula-04/parte-1/Pessoa.java) + [Main.java](aula-04/parte-1/Main.java) — criação de objetos com construtor e método de apresentação

**Parte 2 — Herança**
- [parte-2/parte-2-1/](aula-04/parte-2/parte-2-1/) — herança com métodos específicos nas subclasses (`Cachorro` com `latir()`, `Gato` com `miar()`)
- [parte-2/parte-2-2/](aula-04/parte-2/parte-2-2/) — sobrescrita de métodos com `@Override` (`emitirSom()` redefinido em cada subclasse)

**Parte 3 — Interfaces**
- [parte-3/](aula-04/parte-3/) — interfaces `Nadavel` e `Voavel`; `Pato` implementa ambas, `Peixe` implementa apenas `Nadavel`

**Conceitos abordados:**
- Herança com `extends` e `super()`
- Métodos específicos de subclasses
- Sobrescrita de métodos (`@Override`)
- Declaração e implementação de interfaces (`interface` / `implements`)
- Múltiplas interfaces em uma mesma classe

### Aula 05 — Exceções e Listas

Tratamento de erros com exceções e manipulação de coleções com `ArrayList`.

**Parte 1 — Exceções**
- [Parte-1/Parte-1-1/](aula-05/Parte-1/Parte-1-1/) — exceções unchecked com `IllegalArgumentException` em `ContaBancaria` (depósito, saque com valor inválido e saldo insuficiente)
- [Parte-1/Parte-1-2/](aula-05/Parte-1/Parte-1-2/) — exceções checked customizadas: `ValorInvalidoException` e `SaldoInsuficienteException` estendendo `Exception`; `ContaBancaria` com múltiplas contas via `Banco`

**Parte 2 — Listas (ArrayList)**
- [parte-2/Parte-2-1/](aula-05/parte-2/Parte-2-1/) — `List<Pessoa>` com `ArrayList`; iteração com `for-each`
- [parte-2/Parte-2-2/](aula-05/parte-2/Parte-2-2/) — `List<Produto>` como carrinho simples; cálculo de total e remoção por índice
- [parte-2/Parte-2-3/](aula-05/parte-2/Parte-2-3/) — encapsulamento da lista em classe `Carrinho` com métodos `adicionar`, `remover`, `calcularTotal` e `tamanho`

**Conceitos abordados:**
- Exceções unchecked (`RuntimeException` / `IllegalArgumentException`)
- Exceções checked customizadas (`extends Exception`) com atributos extras
- `try/catch` e propagação com `throws`
- `ArrayList` e interface `List<T>`
- Iteração com `for-each`, acesso por índice, `add`, `remove`, `size`
- Encapsulamento de coleções em classes de domínio
