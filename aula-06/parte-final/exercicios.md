# Exercícios — Aula 06

---

## Parte 1 — Escrita e leitura simples

### Exercício 1 — Diário pessoal

Crie um programa que mantém um diário em texto puro em `diario.txt`. Cada execução do programa **adiciona uma nova entrada no final** do arquivo (modo append), no formato:

```
2026-05-28 - Hoje aprendi sobre arquivos em Java!
```

**Requisitos:**

- A entrada do dia deve começar com a data atual (use `LocalDate.now()`).
- Use `FileWriter` em **modo append** (segundo parâmetro `true`) para não apagar entradas anteriores.
- Após gravar, **leia o arquivo inteiro** com `Files.readAllLines` e mostre todas as entradas no terminal.
- Exiba o total de entradas do diário.
- Capture `IOException` em todas as operações de I/O.
- Use `try-with-resources` para o `FileWriter`.

**Desafio extra:**
- Em vez de uma entrada fixa no código, peça o texto ao usuário com `IO.readln("Entrada do dia: ")`.

---

### Exercício 2 — Análise de texto

Crie um programa que lê o arquivo `texto.txt` e exibe estatísticas sobre ele.

**Requisitos:**

- Se `texto.txt` não existir, **crie automaticamente** com um conteúdo de exemplo (3 a 5 linhas).
- Conte e imprima:
  - **Total de linhas** (não conte linhas em branco).
  - **Total de palavras** (separadas por espaços).
  - **Total de caracteres** (sem contar espaços).
  - **Linha mais longa** do arquivo.
- Ignore linhas vazias usando `String.isBlank()`.
- Use `Files.readAllLines` para ler e `split(" ")` para quebrar em palavras.

**Desafio extra:**
- Imprima também a **palavra mais frequente** e quantas vezes ela aparece.

---

## Parte 2 — Persistência de objetos com listas

### Exercício 1 — Agenda de contatos

Crie um sistema simples de agenda persistido em `agenda.txt`, no formato:

```
nome;telefone;email
```

**Classes a criar:**

- `Contato` — atributos: `nome` (String), `telefone` (String), `email` (String). Com getters e o método `paraLinha()` que retorna `nome;telefone;email`.
- `Main` com os métodos auxiliares:
  - `carregar(Path arquivo)` — retorna uma `List<Contato>` lida do arquivo. Se o arquivo não existir, retorna lista vazia.
  - `salvar(Path arquivo, List<Contato> contatos)` — grava a lista inteira, uma linha por contato.
  - `buscar(List<Contato> contatos, String nome)` — busca pelo nome **sem diferenciar maiúsculas/minúsculas**. Retorna `null` se não achar.
  - `remover(List<Contato> contatos, String nome)` — remove o contato encontrado da lista em memória.

**No `main`, demonstre o fluxo completo:**
1. Carregue a agenda do arquivo (começa vazia se não existir).
2. Cadastre 3 contatos.
3. Liste todos os contatos no terminal.
4. Busque um contato pelo nome e exiba os dados (ou avise que não foi encontrado).
5. Remova um contato pelo nome.
6. Salve a lista atualizada em `agenda.txt`.

---

### Exercício 2 — Controle de estoque

Crie um sistema de estoque persistido em `estoque.txt`, no formato:

```
codigo;nome;quantidade;preco
```

**Classes a criar:**

- `Produto` — atributos: `codigo` (String), `nome` (String), `quantidade` (int), `preco` (double). Com getters, `paraLinha()` e `getValorEmEstoque()` que retorna `quantidade * preco`.
- `Main` com os métodos auxiliares `carregar` e `salvar` (similares ao exercício anterior).

**No `main`:**
1. Carregue o estoque do arquivo.
2. Se a lista estiver vazia, cadastre 4 produtos de exemplo.
3. Liste todos os produtos com código, nome, quantidade, preço unitário e valor em estoque (`quantidade * preco`).
4. Calcule e exiba o **valor total do estoque** (soma de todos os `getValorEmEstoque()`).
5. Liste os **produtos com estoque baixo** (`quantidade < 5`) com uma mensagem de alerta.
6. Salve o estoque de volta no arquivo.

**Validações ao carregar:**
- **Ignore linhas com formato inválido** (split que não retorne exatamente 4 partes).
- Capture `NumberFormatException` ao converter `quantidade` e `preco`.

**Desafio extra:**
- Adicione o método `aumentarPreco(double percentual)` em `Produto` que aplica um aumento e salve a lista depois.
