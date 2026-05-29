# Exercícios — Aula 05

---

## Parte 1 — Exceções

### Exercício 1 — Estacionamento

Crie um sistema de estacionamento com vagas numeradas utilizando **exceções checked customizadas**.

**Classes a criar:**

- `VagaInexistenteException` — lançada quando o número da vaga não existe no estacionamento. Deve guardar o número da vaga tentada.
- `VagaOcupadaException` — lançada quando se tenta estacionar em uma vaga que já está ocupada. Deve guardar o número da vaga e a placa que já está lá.
- `Estacionamento` — gerencia um número fixo de vagas (definido no construtor). Deve ter os métodos:
  - `estacionar(String placa, int vaga)` — ocupa a vaga. Lança `VagaInexistenteException` ou `VagaOcupadaException` conforme o caso.
  - `liberar(int vaga)` — libera a vaga. Lança `VagaInexistenteException` se a vaga não existir.
  - `exibirStatus()` — exibe todas as vagas com seu estado (livre ou placa do carro).

**No `main`, teste os cenários:**
1. Estacionar dois carros em vagas válidas.
2. Tentar estacionar em uma vaga já ocupada.
3. Tentar estacionar em uma vaga que não existe.
4. Liberar uma vaga e estacionar outro carro no lugar.

---

### Exercício 2 — Calculadora com exceções

Crie uma `Calculadora` que valida suas operações com **exceções checked customizadas**.

**Classes a criar:**

- `DivisaoPorZeroException` — lançada ao tentar dividir por zero. Deve guardar o dividendo.
- `ValorNegativoException` — lançada quando uma operação exige número positivo (ex.: raiz quadrada de número negativo). Deve guardar o valor inválido.
- `Calculadora` — com os métodos:
  - `dividir(double a, double b)` — lança `DivisaoPorZeroException` se `b == 0`.
  - `raizQuadrada(double n)` — lança `ValorNegativoException` se `n < 0`.
  - `calcular(String operacao, double a, double b)` — aceita `"+"`, `"-"`, `"*"` e `"/"`, executa a operação e retorna o resultado. Para `"/"`, reutilize o método `dividir`.

**No `main`, teste os cenários:**
1. Divisão normal e divisão por zero.
2. Raiz quadrada de número positivo e de número negativo.
3. Chamadas ao método `calcular` com cada operação.

---

## Parte 2 — Listas (ArrayList)

### Exercício 1 — Biblioteca

Crie um sistema de gerenciamento de livros utilizando `List<Livro>`.

**Classes a criar:**

- `Livro` — atributos: `titulo` (String), `autor` (String), `anoPublicacao` (int). Com método `exibirDados()`.
- `Biblioteca` — contém uma `List<Livro>` interna. Deve ter os métodos:
  - `adicionarLivro(Livro livro)` — adiciona um livro à coleção.
  - `buscarPorAutor(String autor)` — retorna uma `List<Livro>` com todos os livros do autor informado (comparação sem diferenciar maiúsculas/minúsculas).
  - `livroMaisAntigo()` — percorre a lista e retorna o `Livro` com menor `anoPublicacao`. Retorna `null` se a biblioteca estiver vazia.
  - `exibirTodos()` — exibe todos os livros cadastrados.

**No `main`, teste:**
1. Adicione pelo menos 4 livros de autores diferentes (pelo menos 2 do mesmo autor).
2. Busque livros de um autor específico e exiba os resultados.
3. Exiba o livro mais antigo da coleção.

---

### Exercício 2 — Turma de Alunos

Crie um sistema de gerenciamento de alunos com cálculo de médias e aprovação, utilizando `List<Aluno>`.

**Classes a criar:**

- `Aluno` — atributos: `nome` (String), `nota` (double). Com método `exibirDados()`.
- `Turma` — contém uma `List<Aluno>` interna. Deve ter os métodos:
  - `adicionarAluno(Aluno aluno)` — adiciona um aluno à turma.
  - `calcularMedia()` — retorna a média das notas de todos os alunos. Retorna `0` se a turma estiver vazia.
  - `alunosAprovados()` — retorna uma `List<Aluno>` com os alunos que têm nota maior ou igual a `6.0`.
  - `melhorAluno()` — retorna o `Aluno` com a maior nota. Retorna `null` se a turma estiver vazia.
  - `exibirTodos()` — exibe todos os alunos com nome e nota.

**No `main`, teste:**
1. Adicione pelo menos 5 alunos com notas variadas (alguns abaixo de 6 e outros acima).
2. Exiba a média da turma.
3. Liste apenas os alunos aprovados.
4. Exiba o nome e a nota do melhor aluno.
