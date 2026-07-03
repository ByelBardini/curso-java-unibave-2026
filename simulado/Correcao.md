# Correcao - Simulado: Sistema de Gerenciamento de Alunos



## Analise por Criterio

### 1. Implementacoes Base

| Requisito | Situacao |
|---|---|
| Cadastrar alunos com nome, matricula e duas notas | Parcial - dados hardcoded, sem Scanner |
| Listar alunos com media e situacao | Parcial - imprime mas nao ha lista real |
| Validacao de campos invalidos (nome em branco, notas 0-10) | Nao implementado |
| Buscar aluno pelo nome | Nao implementado |
| Remover aluno pelo nome | Nao implementado |
| Persistencia entre execucoes | Nao implementado |

**Observacoes:**
- O programa **nao e interativo**. Nao ha `Scanner`, nao ha menu, nao ha entrada do usuario. Toda execucao produz sempre o mesmo resultado.
- As notas nao sao atributos do aluno - sao passadas como parametros avulsos e descartadas. Isso impede qualquer operacao futura sobre elas.
- O `try-catch` em `Main` captura `Exception` generica e imprime "Usuario nao encontrado" - mensagem que nao faz sentido para o bloco, e mascara qualquer erro real de logica.

---

### 2. Organizacao do Codigo

**Pontos positivos:**
- A separacao em tres classes (`Pessoa`, `Alunos`, `Main`) e um bom ponto de partida e demonstra entendimento da divisao de responsabilidades.
- O encapsulamento em `Pessoa` esta correto: atributos `private` com getters.
- A heranca de `Alunos extends Pessoa` e semanticamente valida.

**Problemas identificados:**

**a) Nome de classe no plural**
```java
// Errado - classe representa UM aluno, nao uma colecao
public class Alunos extends Pessoa { ... }

// Correto
public class Aluno extends Pessoa { ... }
```
Convencao Java: nome de classe no singular. `Alunos` sugere uma colecao ou repositorio.

**b) Nome de metodo enganoso**
```java
public void somarNotas(double n1, double n2) {
    double media = (n1 + n2) / 2;  // nao soma, calcula media
```
O metodo se chama `somarNotas` mas calcula a media. Isso viola o principio de codigo autoexplicativo. Deveria ser `calcularMedia()` ou `exibirSituacao()`.

**c) Notas nao sao atributos da entidade**
As notas fazem parte do aluno. Devem ser campos da classe, nao parametros de metodo:
```java
// Correto
public class Aluno extends Pessoa {
    private double nota1;
    private double nota2;

    public Aluno(String nome, int matricula, double nota1, double nota2) { ... }

    public double calcularMedia() {
        return (nota1 + nota2) / 2;
    }
}
```

**d) Logica de negocio misturada com exibicao**
O metodo `somarNotas` mistura calculo de media com impressao no console. Essas responsabilidades deveriam estar separadas.

---

### 3. Logica e Funcionamento

- A formula da media esta correta: `(n1 + n2) / 2`.
- O criterio de aprovacao (media >= 7) esta correto.
- Porem, **nao ha sistema funcional**. Um sistema pressupoe: entrada de dados, processamento e saida - e apenas a saida existe, para dados fixos.
- Nao ha qualquer colecao (`ArrayList`, `List`) para armazenar os alunos cadastrados.
- O tratamento de excecao e incorreto: capturar `Exception` generica em torno de construtores e chamadas de metodo simples nao faz sentido e esconde erros reais.

---

### 4. Implementacoes Extras

Nenhuma implementacao extra foi entregue.

---

## O Que Era Esperado

Para um aproveitamento basico, a entrega deveria conter:

```
simulado/src/
|-- Pessoa.java              <- classe base com nome e matricula
|-- Aluno.java               <- herda Pessoa, adiciona nota1, nota2, metodos de media/situacao
|-- GerenciadorAlunos.java   <- List<Aluno>, metodos cadastrar/buscar/remover/listar
|-- Persistencia.java        <- salvar/carregar de arquivo .txt ou .csv
+-- Main.java                <- menu interativo com Scanner
```

Exemplo minimo de menu esperado:
```
1 - Cadastrar aluno
2 - Listar alunos
3 - Buscar aluno
4 - Remover aluno
0 - Sair
```

---