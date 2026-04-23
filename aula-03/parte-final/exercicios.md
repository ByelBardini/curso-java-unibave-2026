# Exercícios — Aula 03: Orientação a Objetos

---

## Parte 1 — Objetos e Métodos (sem get/set)

### Exercício 1
Crie uma classe `Livro` com os campos públicos `titulo`, `autor` e `numeroDePaginas`.  
No `Main`, crie dois livros, atribua valores diretamente e exiba as informações de cada um.

---

### Exercício 2
Crie um método estático `exibirLivro(Livro l)` no `Main` que receba um objeto `Livro` e imprima seus dados.  
Chame esse método para cada livro criado no exercício anterior.

---

### Exercício 3
Crie um método estático `adicionarPaginas(Livro l, int quantidade)` que some páginas ao livro recebido.  
Exiba o número de páginas antes e depois da chamada e observe que o objeto foi alterado.

---

### Exercício 4
Crie um método estático `tentarMudarPaginas(int paginas)` que receba o número de páginas como `int` e tente dobrá-lo internamente.  
Exiba o valor dentro do método e depois fora e explique por que o valor original não mudou.

---

### Exercício 5
Crie uma classe `Turma` com os campos `nome` e `quantidadeDeAlunos`.  
Crie um método estático `matricular(Turma t)` que incremente `quantidadeDeAlunos` em 1 e exiba uma mensagem.  
No `Main`, matricule três alunos na mesma turma chamando o método três vezes.

---

## Parte 2 — Encapsulamento com get/set

### Exercício 6
Crie uma classe `Carro` com os campos privados `modelo` e `ano`.  
Adicione getters e setters para os dois campos.  
No `Main`, crie um carro, defina os valores com setters e exiba-os com getters.

---

### Exercício 7
Modifique o setter `setAno` do exercício anterior para bloquear anos menores que 1886 (ano do primeiro carro da história) ou maiores que 2026.  
Teste com um ano válido e um inválido e observe o comportamento.

---

### Exercício 8
Crie uma classe `Aluno` com os campos privados `nome`, `nota1` e `nota2`.  
Adicione getters e setters. O setter de cada nota deve bloquear valores fora do intervalo de 0 a 10.  
Crie um método `calcularMedia()` que retorne a média das duas notas e exiba o resultado no `Main`.

---

### Exercício 9
Crie uma classe `ContaCorrente` com os campos privados `titular` e `saldo`.  
Adicione um método `depositar(double valor)` que bloqueie depósitos de valor zero ou negativo.  
Adicione um método `sacar(double valor)` que bloqueie saques maiores que o saldo disponível.  
No `Main`, teste depósitos e saques válidos e inválidos.

---

### Exercício 10 — Desafio
Crie uma classe `Estoque` com os campos privados `produto`, `quantidade` e `precoUnitario`.  
Implemente:
- Setters com validação: quantidade e preço não podem ser negativos, nome não pode ser vazio.
- Um método `vender(int quantidade)` que reduza o estoque, bloqueie vendas acima do disponível e exiba o valor total da venda.
- Um método `reporEstoque(int quantidade)` que some ao estoque atual.
- Um método `exibir()` que mostre todas as informações do produto.

No `Main`, crie um produto, faça vendas e reposições, e tente inserir dados inválidos para verificar as validações.
