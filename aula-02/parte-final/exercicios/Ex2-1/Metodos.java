void main() {
    int soma = somar(15, 7);
    exibirResultado("15 + 7", soma);

    int sub = subtrair(20, 8);
    exibirResultado("20 - 8", sub);

    double pot = calcularPotencia(2, 10);
    exibirResultado("2^10", pot);
}

int somar(int a, int b) {
    return a + b;
}

int subtrair(int a, int b) {
    return a - b;
}

double calcularPotencia(double base, int expoente) {
    return Math.pow(base, expoente);
}

void exibirResultado(String operacao, double valor) {
    IO.println(operacao + " = " + valor);
}
