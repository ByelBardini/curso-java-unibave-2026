// Parte 2.2 - Métodos parametrizados em classes separadas
void main() {
    CalculadoraParametrizada calc = new CalculadoraParametrizada();
    Impressora imp = new Impressora();

    imp.imprimir("Demonstração de métodos parametrizados");
    exibirSeparador();

    int soma = calc.somar(8, 5);
    imp.exibirResultado("8 + 5", soma);

    int subtracao = calc.subtrair(10, 3);
    imp.exibirResultado("10 - 3", subtracao);

    double multiplicacao = calc.multiplicar(3.5, 4.0);
    imp.exibirResultado("3.5 x 4.0", multiplicacao);

    double divisao = calc.dividir(15.0, 4.0);
    imp.exibirResultado("15.0 / 4.0", divisao);

    exibirSeparador();
    imp.exibirTabuada(6);
}

void exibirSeparador() {
    IO.println("--------------------------------------------------");
}
