# Exercícios — Aula 02: Métodos em Java

> Crie cada exercício em sua própria pasta. Ex: `exercicios/Ex1-1/`, `exercicios/Ex1-2/`, etc.

## Parte 1 — Métodos sem parâmetros

### Exercício 1.1 — Mesma classe
Crie um arquivo `Metodos.java` com os seguintes métodos e chame todos no `main`:

- `exibirNome()` → imprime seu nome completo
- `exibirIdade()` → imprime sua idade
- `exibirCidade()` → imprime a cidade onde mora
- `exibirSeparador()` → imprime uma linha de `=` com 40 caracteres

**Saída esperada:**
```
Nome: João Silva
Idade: 22 anos
Cidade: Araranguá
========================================
```

---

### Exercício 1.2 — Classes separadas
Crie um arquivo `Perfil.java` com a classe `Perfil` contendo:

- `exibirNome()` → imprime seu nome
- `exibirCurso()` → imprime o curso que faz
- `exibirAno()` → imprime o ano atual usando `java.time.LocalDate.now().getYear()`

No `Metodos.java`, instancie `Perfil` e chame todos os métodos.

---

## Parte 2 — Métodos com parâmetros

### Exercício 2.1 — Operações matemáticas (mesma classe)
Crie os seguintes métodos e chame todos no `main`:

- `somar(int a, int b)` → retorna `int` com a soma
- `subtrair(int a, int b)` → retorna `int` com a subtração
- `calcularPotencia(double base, int expoente)` → retorna `double` usando `Math.pow`
- `exibirResultado(String operacao, double valor)` → imprime `"operacao = valor"`

**Chame assim no main:**
```java
int soma = somar(15, 7);
exibirResultado("15 + 7", soma);

int sub = subtrair(20, 8);
exibirResultado("20 - 8", sub);

double pot = calcularPotencia(2, 10);
exibirResultado("2^10", pot);
```

---

### Exercício 2.2 — Sobrecarga de métodos (mesma classe)
Crie um método `descrever` sobrecarregado que aceite diferentes tipos:

- `descrever(String texto)` → imprime `"Texto: " + texto`
- `descrever(int numero)` → imprime `"Número inteiro: " + numero`
- `descrever(double numero)` → imprime `"Número decimal: " + numero`
- `descrever(boolean valor)` → imprime `"Booleano: " + valor`

No `main`, chame cada versão com um valor diferente.

---

### Exercício 2.3 — Tabuada parametrizada (mesma classe)
Crie o método `exibirTabuada(int numero, int limite)` onde `limite` define até qual número a tabuada vai (em vez de fixar no 10).

**Chame assim no main:**
```java
exibirTabuada(5, 5);   // tabuada do 5 até 5x5
exibirTabuada(3, 12);  // tabuada do 3 até 3x12
```

---

### Exercício 2.4 — Classes separadas
Crie dois arquivos de classe:

**`Conversor.java`** com a classe `Conversor` contendo:
- `celsiusParaFahrenheit(double celsius)` → retorna `double` (fórmula: `celsius * 9/5 + 32`)
- `kmParaMilhas(double km)` → retorna `double` (fórmula: `km * 0.621371`)
- `kgParaLibras(double kg)` → retorna `double` (fórmula: `kg * 2.20462`)

**`ImpressoraResultados.java`** com a classe `ImpressoraResultados` contendo:
- `exibirConversao(String de, String para, double entrada, double saida)` → imprime:
  `"X de → Y para"`

No `Metodos.java`, instancie ambas as classes e exiba pelo menos 3 conversões.

---

## Desafio — IMC
Crie um arquivo `Metodos.java` com os seguintes métodos:

- `calcularIMC(double peso, double altura)` → retorna `double` (fórmula: `peso / (altura * altura)`)
- `classificarIMC(double imc)` → retorna `String` com a classificação:
  - Abaixo de 18.5 → `"Abaixo do peso"`
  - Entre 18.5 e 24.9 → `"Peso normal"`
  - Entre 25.0 e 29.9 → `"Sobrepeso"`
  - 30.0 ou acima → `"Obesidade"`
- `exibirRelatorio(String nome, double imc, String classificacao)` → imprime um relatório formatado

**Chame no main com pelo menos 3 pessoas diferentes.**
