# Correção — Sistema de Gerenciamento de Alunos


---

## 1. Implementações Base

### O que foi implementado corretamente
- Cadastro com nome, matrícula e duas notas ✔
- Listagem com média e situação (aprovado se ≥ 7,0) ✔
- Busca e remoção por nome (case-insensitive) ✔
- Persistência entre execuções via serialização Java ✔
- Mensagens de erro em campos inválidos sem encerrar o programa ✔

### Problemas encontrados

**Inconsistência no fluxo de cadastro com nota inválida**

Em `Main.java:60–69`, `lerDouble` faz loop até o usuário digitar um número válido (bom), mas depois o intervalo (0–10) é validado com `return`, descartando nome, matrícula e a outra nota:

```java
double nota1 = lerDouble("Nota 1 (0–10): ");
if (!notaValida(nota1)) {
    System.out.println("[Erro] Nota 1 deve estar entre 0 e 10.\n");
    return; // ← usuário perde TUDO e recomeça do zero
}
```

O correto seria loopar dentro do próprio `lerDouble` até obter um valor no intervalo, ou criar um `lerNota` separado — exatamente como `lerDouble` já faz para entradas não numéricas.

---

## 2. Organização do Código

### Problema crítico: toda a lógica está em `Main`

O README é explícito: *"Separação em classes com responsabilidades definidas — não coloque tudo no `main`"*.

`Main.java` acumula quatro responsabilidades distintas:
- Interface com o usuário (menus, impressão)
- Validação de entradas (`notaValida`, `lerString`, `lerInt`, `lerDouble`)
- Regras de negócio (cadastrar, buscar, remover)
- Coordenação do estado global (`alunos`, `sc` como campos estáticos)

O mínimo esperado seria uma classe `GerenciadorAlunos` (ou `Turma`) responsável pela lista e pelas operações sobre ela, deixando `Main` apenas com a navegação de menu.

### Herança completamente ausente

O README exige: *"Uso correto de herança e encapsulamento"*. O encapsulamento está presente em `Aluno`, mas **não há nenhum uso de herança em todo o projeto**. Possibilidades que fariam sentido no contexto:

- Uma classe abstrata `Pessoa` com `nome`, da qual `Aluno` herda
- Uma interface `Persistivel` ou `Exportavel`
- Uma hierarquia `AlunoRegular extends Aluno` para casos especiais

A ausência de herança é um critério de avaliação explícito e representa perda de pontos significativa.


---

## 3. Lógica e Funcionamento

### Funciona como esperado nos casos básicos ✔

O programa não crasha com entradas inválidas e a persistência funciona corretamente.

### Cast sem anotação de supressão

Em `Persistencia.java:16`:

```java
return (List<Aluno>) ois.readObject(); // ← unchecked cast sem @SuppressWarnings
```

### `removerAluno` remove múltiplos sem confirmação

```java
boolean removeu = alunos.removeIf(a -> a.getNome().equalsIgnoreCase(nome));
```

Se dois alunos têm o mesmo nome, ambos são removidos silenciosamente. O comportamento pode ser intencional, mas não há confirmação ou aviso ao usuário sobre quantos registros foram afetados. Emitir algo como *"2 aluno(s) removido(s)"* já seria suficiente — o que aliás o código já faz na mensagem `[OK]`, mas sem contar.

---

## 4. Implementações Extras

| Extra | Status |
|---|---|
| Estatísticas da turma (total, aprovados, reprovados, maior/menor média) | ✘ Não implementado |
| Matrícula única | ✘ Não implementado |
| Listagem ordenada por média | ✘ Não implementado |

Nenhum dos três extras foi implementado, o que representa perda da pontuação bônus.

---

## Resumo por Critério

| Critério | Situação |
|---|---|
| Cadastro, listagem, busca, remoção | Implementados e funcionando |
| Validação sem encerrar o programa | Parcial — fluxo de nota inválida descarta dados |
| Persistência entre execuções | Funcionando |
| Separação em classes | Insuficiente — lógica concentrada em Main |
| Herança | **Ausente** — critério explícito não atendido |
| Encapsulamento | Presente em Aluno |
| Nenhum crash por entrada inválida | Atendido |
| Extras implementados | Nenhum |
