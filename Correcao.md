# Correção — Sistema de Gerenciamento de Alunos



## Implementações Base

### O que foi entregue

| Requisito | Situação |
|---|---|
| Cadastrar com nome, matrícula e duas notas | ✅ Implementado |
| Listar com média e situação (≥ 7,0 = Aprovado) | ✅ Implementado |
| Erro em campos inválidos sem encerrar o programa | ✅ Implementado (parcial — ver observação) |
| Buscar aluno pelo nome | ✅ Implementado |
| Remover aluno pelo nome | ✅ Implementado |
| Persistência entre execuções | ✅ Implementado |

### Observação sobre validação

O código exibe mensagens de erro e **não encerra o programa** — o comportamento correto. Porém, ao informar um nome em branco ou uma nota inválida, o formulário inteiro é abandonado com `return`, forçando o usuário a reiniciar o cadastro do zero. O ideal seria repetir apenas o campo com problema, semelhante ao `lerDouble()` que já faz isso corretamente com um laço `while`.

```java
// lerDouble() — bom: fica em loop até receber entrada válida
private static double lerDouble(String prompt) {
    while (true) { ... }
}

// cadastrarAluno() — inconsistente: abandona tudo ao primeiro erro
if (nome.isBlank()) {
    System.out.println("[Erro] O nome não pode ser vazio.\n");
    return; // ← aqui o usuário perde a matrícula e notas que já digitou
}
```

---

## Organização do Código

### Pontos positivos

- `Aluno.java` encapsula bem os dados: campos `private`, getters, `getMedia()` e `getSituacao()` como comportamentos da própria entidade. Correto.
- `Persistencia.java` isola a responsabilidade de I/O, com try-with-resources e tratamento de exceções adequados.
- O menu usa **switch expressions** com sintaxe de seta (`case 1 -> ...`), recurso do Java 14 em diante. Boa escolha.

### Pontos a melhorar

**1. Herança não foi utilizada**

O README exige explicitamente *"uso correto de herança"*. Nenhuma hierarquia de classes foi criada. Uma abordagem possível seria extrair uma classe `Pessoa` com o atributo `nome`, e `Aluno` herdá-la:

```java
public abstract class Pessoa {
    protected String nome;
    public Pessoa(String nome) { this.nome = nome; }
    public String getNome() { return nome; }
}

public class Aluno extends Pessoa implements Serializable { ... }
```

**2. Toda a lógica de negócio está em `Main`**

O README pede *"separação em classes com responsabilidades definidas — não coloque tudo no `main`"*. Os métodos `cadastrarAluno()`, `listarAlunos()`, `buscarAluno()` e `removerAluno()` são estáticos dentro de `Main`. O ideal seria uma classe de serviço (ex.: `GerenciadorAlunos`) responsável pela coleção e pelas operações sobre ela:

```java
// Exemplo de separação adequada
public class GerenciadorAlunos {
    private List<Aluno> alunos;

    public void cadastrar(Aluno a) { ... }
    public List<Aluno> buscarPorNome(String nome) { ... }
    public boolean remover(String nome) { ... }
    public List<Aluno> listar() { ... }
}
```


---

## Lógica e Funcionamento

O programa funciona corretamente nos fluxos principais. A listagem exibe média e situação, a busca é case-insensitive (`equalsIgnoreCase`), a remoção persiste os dados e a leitura ao iniciar mostra o total carregado. Sem travamentos por entradas inválidas.

**Único problema lógico identificado:** não há verificação de **matrícula duplicada** no cadastro. Isso está listado como extra, mas é um item de integridade de dados que poderia ser feito em poucas linhas:

```java
boolean matriculaExistente = alunos.stream()
    .anyMatch(a -> a.getMatricula().equals(matricula));
if (matriculaExistente) {
    System.out.println("[Erro] Matrícula já cadastrada.\n");
    return;
}
```


---

## Implementações Extras

Nenhuma das três funcionalidades extras foi implementada:

| Extra | Situação |
|---|---|
| Estatísticas da turma (total, aprovados, reprovados, maior/menor média) | ❌ |
| Matrícula única | ❌ |
| Listagem ordenada por média | ❌ |

A listagem ordenada seria particularmente simples com a API de Streams:

```java
alunos.stream()
    .sorted(Comparator.comparingDouble(Aluno::getMedia).reversed())
    .forEach(System.out::println);
```

---
