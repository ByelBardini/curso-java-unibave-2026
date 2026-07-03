# Correção — Exercício de Revisão Java

---

## 1. Implementações Base ✅ (completas)

| Requisito | Status |
|---|---|
| Cadastrar aluno (nome, matrícula, duas notas) | ✅ |
| Listar com média e situação | ✅ |
| Validação de campos inválidos sem encerrar o programa | ✅ |
| Buscar por nome | ✅ |
| Remover por nome | ✅ |
| Persistência entre execuções | ✅ |

## 2. Implementações Extras ✅ (todas)

| Requisito | Status |
|---|---|
| Estatísticas da turma | ✅ |
| Matrícula única | ✅ |
| Listagem ordenada por média | ✅ |

---

## 3. Problemas Encontrados

### 3.1 CRÍTICO — Herança ausente (`Aluno.java`)

O critério de avaliação exige explicitamente **"uso correto de herança"**. O projeto não possui nenhuma relação de herança em lugar algum.

Uma aplicação natural seria, por exemplo, separar o conceito base de uma `Pessoa` e fazer `Aluno` estender:

```java
// Pessoa.java
public class Pessoa {
    protected String nome;

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public String getNome() { return nome; }
}

// Aluno.java
public class Aluno extends Pessoa {
    private String matricula;
    private double nota1, nota2;
    // ...
}
```

Sem herança, o critério "uso correto de herança e encapsulamento" é atendido apenas pela metade.

---

### 3.2 Inicialização dupla desnecessária (`Turma.java`, linha 6)

```java
// PROBLEMA
private ArrayList<Aluno> alunos = new ArrayList<>(); // criado aqui...

public Turma() {
    alunos = Persistencia.carregar(); // ...e imediatamente descartado aqui
}
```

O `new ArrayList<>()` da linha 6 é instanciado e jogado fora no construtor. Prefira declarar sem inicializar:

```java
private List<Aluno> alunos;

public Turma() {
    this.alunos = Persistencia.carregar();
}
```

---

### 3.3 Indentação inconsistente (`Turma.java`, linha 63–65)

O bloco `if` dentro de `estatisticas()` está com indentação errada em relação ao resto do método:

```java
// PROBLEMA — if alinhado à esquerda, fora do padrão do método
public void estatisticas() {
    if (alunos.isEmpty()) {
    System.out.println("Nenhum aluno cadastrado."); // ← faltam 4 espaços
    return;
}
```

---

### 3.4 Indentação inconsistente (`Persistencia.java`, linha 20–22)

O `catch` do método `salvar()` está desalinhado com o `try`:

```java
try (BufferedWriter writer = ...) {
    // ...
} catch (IOException e) {        // ← catch alinhado com o corpo do try, não com o try
    System.out.println("...");
    }                             // ← fechamento da função no lugar errado
```

---

### 3.5 Arquivo corrompido causa crash (`Persistencia.java`)

Se o arquivo `alunos.txt` tiver uma linha malformada (faltando campos, ou nota não numérica), o método `carregar()` lança `ArrayIndexOutOfBoundsException` ou `NumberFormatException` não tratadas, derrubando o programa na inicialização.

```java
// PROBLEMA — sem tratamento de linha corrompida
String[] dados = linha.split(";");
String nome = dados[0];        // IndexOutOfBoundsException se dados tiver < 4 campos
double nota1 = Double.parseDouble(dados[2]); // NumberFormatException se não for número
```

**Correção:**

```java
while ((linha = reader.readLine()) != null) {
    String[] dados = linha.split(";");
    if (dados.length < 4) continue; // pula linha corrompida
    try {
        // parse...
    } catch (NumberFormatException e) {
        System.out.println("Linha ignorada (formato inválido): " + linha);
    }
}
```

---

### 3.6 Acoplamento de variáveis entre `case`s (`Main.java`)

A variável `nome` é declarada no `case 1` e reutilizada silenciosamente nos `case 3` e `case 4`. Isso é um cheiro de código: cases que não têm relação entre si compartilham estado.

```java
case 1:
    String nome = sc.nextLine(); // declarada aqui
    // ...

case 3:
    nome = sc.nextLine().trim(); // reutiliza a variável do case 1
```

Cada `case` deveria declarar sua própria variável local, idealmente com blocos `{}`:

```java
case 3 -> {
    String nome = sc.nextLine().trim();
    // ...
}
```

---

### 3.7 Sem validação de entrada vazia na busca e remoção (`Main.java`)

No cadastro (case 1), há validação de nome em branco. Mas na busca (case 3) e remoção (case 4), o nome não é validado:

```java
case 3:
    nome = sc.nextLine().trim();
    Aluno encontrado = turma.buscar(nome); // busca por string vazia é silenciosa
```

Se o usuário pressionar Enter sem digitar nada, o sistema tentará buscar por `""` sem nenhum aviso.

---


### 3.8 `FileReader(ARQUIVO)` duplica a criação do objeto (`Persistencia.java`, linha 37)

```java
File arquivo = new File(ARQUIVO);      // arquivo já existe como objeto
if (!arquivo.exists()) return alunos;

try (BufferedReader reader =
        new BufferedReader(
                new FileReader(ARQUIVO))) { // ← deveria ser new FileReader(arquivo)
```

O `arquivo` já foi criado; passar `ARQUIVO` (a String) novamente cria um segundo `File` internamente. Use `new FileReader(arquivo)`.

---

### 3.9 Classe utilitária sem construtor privado (`Persistencia.java`)

`Persistencia` só tem métodos estáticos e nunca deve ser instanciada. Sem um construtor privado, `new Persistencia()` compila sem erros — o que é enganoso.

```java
public class Persistencia {
    private Persistencia() {} // impede instanciação acidental
    // ...
}
```

---

### 3.10 `listar()` muta a ordem interna da lista (`Turma.java`, linha 33)

```java
alunos.sort((a1, a2) -> Double.compare(a2.getMedia(), a1.getMedia()));
```

Chamar `listar()` tem um efeito colateral: reordena permanentemente a lista interna `alunos`. Isso significa que a ordem de remoção e busca fica condicionada a ter listado antes. O ideal seria ordenar uma cópia:

```java
// Java 26 — sem mutar a lista original
List<Aluno> ordenados = alunos.stream()
    .sorted(Comparator.comparingDouble(Aluno::getMedia).reversed())
    .toList();
ordenados.forEach(System.out::println);
```

---


## 4. Pontos Positivos

- Encapsulamento bem aplicado em `Aluno.java` (getters/setters, campos privados)
- Separação de responsabilidades entre `Main`, `Turma`, `Aluno` e `Persistencia` está correta
- Tratamento de entrada inválida no Scanner (sem loops infinitos, sem crashes por tipo errado)
- Persistência funciona corretamente com separador `;`
- Todos os extras implementados e funcionais
- `toString()` bem implementado com `@Override`

---

## 5. Resumo das Penalizações

| Problema | Impacto |
|---|---|
| Herança ausente | Alto — critério explícito não atendido |
| Arquivo corrompido derruba o programa | Médio — falha silenciosa em produção |
| Indentação inconsistente (2 arquivos) | Médio — "código limpo" é critério |
| Inicialização dupla | Baixo |
| `listar()` muta estado interno | Baixo |
| Validação ausente em busca/remoção | Baixo |
| Construtor privado ausente | Baixo |
