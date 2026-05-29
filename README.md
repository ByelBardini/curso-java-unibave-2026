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
- [Parte-1-1/Pessoa.java](aula-03/parte-1/Parte-1-1/Pessoa.java) + [Principal.java](aula-03/parte-1/Parte-1-1/Main.java) — passagem de objetos e primitivos para métodos; referência vs. valor
- [Parte1-2/ContaBancaria.java](aula-03/parte-1/Parte1-2/ContaBancaria.java) + [Principal.java](aula-03/parte-1/Parte1-2/Main.java) — métodos que recebem objetos e chamam comportamentos; transferência entre objetos

**Parte 2 — Encapsulamento com get/set**
- [Parte-2-1/Produto.java](aula-03/Parte-2/Parte-2-1/Produto.java) + [Principal.java](aula-03/Parte-2/Parte-2-1/Main.java) — campos `private` com getters e setters simples
- [Parte-2-2/Funcionario.java](aula-03/Parte-2/Parte-2-2/Funcionario.java) + [Principal.java](aula-03/Parte-2/Parte-2-2/Main.java) — setters com validação; proteção do estado do objeto

**Conceitos abordados:**
- Classes e objetos
- Campos públicos vs. privados
- Passagem de objetos por referência e primitivos por valor
- Getters e setters
- Encapsulamento e validação de dados nos setters

### Aula 04 — Herança e Interfaces

Aprofundamento em orientação a objetos: herança entre classes, sobrescrita de métodos e contratos com interfaces.

**Parte 1 — Classes e construtores**
- [parte-1/Pessoa.java](aula-04/parte-1/Pessoa.java) + [Principal.java](aula-04/parte-1/Main.java) — criação de objetos com construtor e método de apresentação

**Parte 2 — Herança**
- [parte-2/parte-2-1/](aula-04/parte-2/parte-2-1/) — herança com métodos específicos nas subclasses (`Cachorro01` com `latir()`, `Gato01` com `miar()`)
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

### Aula 06 — Arquivos e Persistência Simples

Leitura e escrita de arquivos texto, conversão de objetos em linhas e CRUD persistido em disco. Cada subparte é um módulo Maven independente (`mvn exec:java`), com `Main.java` como ponto de entrada. Os `.txt` ficam na raiz da aula, então as subpartes leem o que as anteriores gravaram.

**Parte 1 — Escrita e leitura básica**
- [parte1/parte1_1/](aula-06/parte1/parte1_1/) — escreve `mensagem.txt` com `Files.write` recebendo uma `List<String>`
- [parte1/parte1_2/](aula-06/parte1/parte1_2/) — lê `mensagem.txt` com `Files.readAllLines` e imprime linha a linha

**Parte 2 — Sobrescrever vs adicionar no final**
- [parte2/parte2_1/](aula-06/parte2/parte2_1/) — sobrescreve `log.txt` com `new FileWriter("...")`
- [parte2/parte2_2/](aula-06/parte2/parte2_2/) — adiciona linhas no final com `new FileWriter("...", true)` (append)
- [parte2/parte2_3/](aula-06/parte2/parte2_3/) — lê `log.txt` para comparar o resultado das duas anteriores

**Parte 3 — Salvando um objeto como texto**
- [parte3/parte3_1/](aula-06/parte3/parte3_1/) — `Conta` com `paraLinha()` que serializa para `titular;saldo` e grava em `conta.txt`
- [parte3/parte3_2/](aula-06/parte3/parte3_2/) — lê `conta.txt`, faz `split(";")` e reconstrói o objeto `Conta`

**Parte 4 — Salvando uma lista de contas**
- [parte4/parte4_1/](aula-06/parte4/parte4_1/) — grava uma `List<Conta>` em `contas.txt`, uma conta por linha
- [parte4/parte4_2/](aula-06/parte4/parte4_2/) — lê `contas.txt` e reconstrói a `List<Conta>` no `main`

**Parte 5 — Carregar ao iniciar**
- [parte5/](aula-06/parte5/) — `Files.exists` para decidir entre carregar ou começar com lista vazia; cadastra uma nova conta e regrava tudo

**Parte 6 — Buscar**
- [parte6/](aula-06/parte6/) — carrega a lista e procura pelo titular com `equalsIgnoreCase`

**Parte 7 — Editar**
- [parte7/](aula-06/parte7/) — altera o saldo de uma conta encontrada e reescreve `contas.txt` inteiro

**Parte 8 — Remover**
- [parte8/](aula-06/parte8/) — remove uma conta da lista em memória e regrava o arquivo do zero

**Parte 9 — Validação simples**
- [parte9/](aula-06/parte9/) — ignora linhas vazias, valida o número de campos por `split` e captura `NumberFormatException` em saldo inválido

**Conceitos abordados:**
- Leitura/escrita de arquivos com `Files.write`, `Files.readAllLines`, `Files.readString` e `FileWriter`
- Sobrescrever vs append (segundo parâmetro do `FileWriter`)
- Conversão objeto ↔ linha com `split(";")` e `Double.parseDouble`
- Persistência de `List<T>` linha a linha em arquivo texto
- Carregamento condicional ao iniciar (`Files.exists`)
- Padrão CRUD em memória + reescrita completa do arquivo
- Validação defensiva de dados lidos (`isBlank`, tamanho do `split`, `NumberFormatException`)
- `try-with-resources` para fechar `FileWriter` automaticamente
- Maven multi-módulo: pom-pai com `<modules>` e poms-filhos herdando configuração
- `exec-maven-plugin` para rodar `Main` via `mvn exec:java`
- Java 26: `void main()` (instance main) e `IO.println()` em classes nomeadas (JEP 512, `java.lang.IO`)
