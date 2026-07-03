# Correção — Sistema de Gerenciamento de Alunos

---

## 1. Erros Críticos (o programa não funciona)

### 1.1 Chamada de método de instância como método estático — `Main.java`, linha 13

```java
// Errado — exibirDados() é um método de INSTÂNCIA, não estático:
Alunos.exibirDados();

// Correto — deveria ser chamado em cada objeto via ListarAlunos:
turma.exibirTodos();
```

`exibirDados()` está declarado em `Alunos.java` como método de instância (`public void exibirDados()`). Chamá-lo como se fosse estático (`Alunos.exibirDados()`) causa **erro de compilação**. Ironicamente, o método `exibirTodos()` de `ListarAlunos` — que faz exatamente o que é necessário — foi criado mas **nunca chamado**.

---

## 2. Requisitos Base — Não Implementados

O enunciado define seis requisitos obrigatórios. **Nenhum foi completamente atendido.**

| Requisito | Status | Observação |
|---|---|---|
| Cadastrar alunos com nome, **matrícula** e duas notas | ✗ Parcial | Matrícula ausente; dados hardcoded no código, não lidos do usuário |
| Listar alunos com média e situação | ✗ Parcial | Lógica existe em `exibirDados()`, mas nunca é executada |
| Validação de campos inválidos | ✗ Ausente | Nenhuma validação implementada |
| Buscar aluno pelo nome | ✗ Ausente | Método não existe |
| Remover aluno pelo nome | ✗ Ausente | Método não existe |
| Persistência de dados entre execuções | ✗ Ausente | Nenhuma leitura/escrita em arquivo |

### Detalhe — campo `matricula` ausente

O enunciado exige explicitamente que cada aluno tenha **nome, matrícula e duas notas**. A classe `Alunos` não possui o campo `matricula`:

```java
// Atual:
private String nome;
private double nota1;
private double nota2;

// Deveria ter:
private String nome;
private String matricula; // ou int
private double nota1;
private double nota2;
```

### Detalhe — sem interação com o usuário

O programa não tem nenhum menu, nenhum `Scanner`, nenhuma entrada do teclado. Os alunos são adicionados diretamente no código-fonte, o que torna o sistema inutilizável como aplicação de linha de comando.

---

## 3. Implementações Extras — Não Implementadas

Nenhum dos três extras foi implementado:

- ✗ Estatísticas da turma (total, aprovados, reprovados, maior/menor média)
- ✗ Matrícula única (sem verificação de duplicatas)
- ✗ Listagem ordenada por média

---

## 4. Organização do Código

---

### 4.1 Herança não utilizada

O enunciado avalia explicitamente o **uso correto de herança**. Nenhuma hierarquia de classes foi criada. Uma solução esperada poderia envolver, por exemplo, uma classe base `Pessoa` da qual `Aluno` herde — ou pelo menos alguma interface/abstração que demonstre o conceito.

---

### 4.2 Encapsulamento parcialmente correto

O encapsulamento na classe `Alunos` está parcialmente correto: os campos são `private`. Porém, **não há getters nem setters**, o que impede que outras classes acessem ou modifiquem os dados do aluno de forma controlada (necessário para busca, remoção, ordenação, etc.).

---

### 4.3 Responsabilidades misturadas / método no lugar errado

O método `exibirDados()` em `Alunos` calcula a média internamente a cada chamada. Seria mais adequado ter a média como um método separado (`calcularMedia()`) ou armazená-la, permitindo reutilização (por exemplo, para ordenar por média ou calcular estatísticas).

---

### 4.4 Nome da classe no plural desnecessário

`Alunos` representa **um único aluno**. O nome correto seria `Aluno` (singular). `ListarAlunos` poderia se chamar `Turma` para representar melhor sua responsabilidade.

---

## 5. O que estava correto

Apesar dos problemas, alguns pontos merecem reconhecimento:

- A separação em três classes (`Main`, `Alunos`, `ListarAlunos`) indica que o aluno compreende a ideia de responsabilidades separadas.
- O uso de `ArrayList` em `ListarAlunos` é apropriado para o problema.
- A lógica de aprovação por média ≥ 7 está correta em `exibirDados()`.
- O método `exibirTodos()` tem a estrutura certa (iterar e delegar para cada aluno).

---

## 6. Resumo dos Problemas por Prioridade

| Prioridade | Problema |
|---|---|
| 🔴 Crítico | Chamada estática de método de instância — não compila |
| 🔴 Crítico | Sem entrada do usuário — não é um sistema de linha de comando |
| 🔴 Crítico | Campo `matricula` ausente |
| 🔴 Crítico | Sem persistência de dados |
| 🟠 Alto | Sem busca por nome |
| 🟠 Alto | Sem remoção por nome |
| 🟠 Alto | Sem validação de campos |
| 🟡 Médio | Herança não utilizada |
| 🟡 Médio | Sem getters/setters |
| 🟡 Médio | Nome da classe `Alunos` deveria ser `Aluno` |
| 🟡 Médio | Pacote com letras maiúsculas |
| 🟢 Baixo | `exibirTodos()` existe mas nunca é chamado |

---

## 8. Sugestão de Estrutura Esperada

Para referência, uma estrutura mínima para atender aos requisitos seria:

```
src/
├── Main.java           → menu de loop com Scanner
├── Aluno.java          → modelo com nome, matricula, nota1, nota2; getters/setters
├── Turma.java          → lista de alunos + métodos: adicionar, buscar, remover, listar
└── Persistencia.java   → salvar/carregar lista de arquivo (ex: JSON ou TXT)
```

---

*Esta correção é baseada no código presente no repositório no momento da avaliação.*
