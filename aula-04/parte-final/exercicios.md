# Exercícios — Aula 04

## Exercício 1 — Construtores

Crie uma classe `Produto` com os atributos `nome` (String), `preco` (double) e `estoque` (int).

A classe deve ter **dois construtores**:
- Um que recebe `nome` e `preco` (o estoque começa em `0`)
- Um que recebe `nome`, `preco` e `estoque`

Adicione um método `exibir()` que imprime as informações do produto no formato:
```
Produto: Caneta | Preço: R$ 2.50 | Estoque: 100
```

No `main`, crie um produto usando cada construtor e chame `exibir()` em ambos.

---

## Exercício 2 — Herança (métodos adicionais)

Crie uma classe `Veiculo` com os atributos `marca` (String) e `velocidadeMaxima` (int), um construtor e um método `apresentar()` que imprime a marca e a velocidade máxima.

Em seguida, crie duas subclasses:
- `Carro`, que herda de `Veiculo` e adiciona o método `ligarArCondicionado()` imprimindo `"Ar-condicionado ligado!"`
- `Moto`, que herda de `Veiculo` e adiciona o método `empinar()` imprimindo `"[nome da marca] empinando!"`

No `main`, instancie um `Carro` e uma `Moto`, chame `apresentar()` em ambos e depois chame o método específico de cada um.

---

## Exercício 3 — Herança (sobrescrita de método)

Crie uma classe `Funcionario` com os atributos `nome` (String) e `salarioBase` (double), um construtor e um método `calcularSalario()` que retorna o `salarioBase`.

Crie duas subclasses:
- `Gerente`, que sobrescreve `calcularSalario()` adicionando um bônus de 30% ao salário base
- `Estagiario`, que sobrescreve `calcularSalario()` retornando 50% do salário base

No `main`, crie um `Funcionario`, um `Gerente` e um `Estagiario` com o mesmo salário base e imprima o salário calculado de cada um.

---

## Exercício 4 — Interface

Crie a interface `Desenhavel` com o método `desenhar()`.

Depois, crie três classes que implementam essa interface:
- `Circulo` — imprime `"Desenhando um círculo"`
- `Retangulo` — imprime `"Desenhando um retângulo"`
- `Triangulo` — imprime `"Desenhando um triângulo"`

No `main`, crie uma instância de cada classe e chame `desenhar()` em todas.

---

## Exercício 5 — Múltiplas Interfaces

Crie duas interfaces:
- `Carregavel`, com o método `carregar()`
- `Reproduzivel`, com o método `reproduzir()`

Em seguida, crie duas classes:
- `Smartphone`, que implementa **ambas** as interfaces — `carregar()` imprime `"Carregando smartphone..."` e `reproduzir()` imprime `"Reproduzindo mídia no smartphone"`
- `Fone`, que implementa **apenas** `Reproduzivel` — `reproduzir()` imprime `"Reproduzindo áudio no fone"`

No `main`, instancie um `Smartphone` e um `Fone`, chame os métodos disponíveis em cada um.
