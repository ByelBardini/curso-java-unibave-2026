// Parte 2.1 - Métodos parametrizados na mesma classe
void main() {
    saudacao("Maria");
    exibirSeparador();

    int resultadoSoma = somar(8, 5);
    IO.println("Soma de 8 + 5 = " + resultadoSoma);

    double resultadoMultiplicacao = multiplicar(3.5, 4.0);
    IO.println("Multiplicação de 3.5 x 4.0 = " + resultadoMultiplicacao);

    exibirSeparador();
    imprimir("Java com métodos parametrizados!");
    imprimir(42);
    imprimir(true);

    exibirSeparador();
    exibirTabuada(7);
}

void saudacao(String nome) {
    IO.println("Olá, " + nome + "! Bem-vindo ao curso de Java!");
}

int somar(int a, int b) {
    return a + b;
}

double multiplicar(double a, double b) {
    return a * b;
}

void imprimir(String mensagem) {
    IO.println("[texto]  " + mensagem);
}

void imprimir(int numero) {
    IO.println("[número] " + numero);
}

void imprimir(boolean valor) {
    IO.println("[bool]   " + valor);
}

void exibirTabuada(int numero) {
    IO.println("Tabuada do " + numero + ":");
    for (int i = 1; i <= 10; i++) {
        IO.println("  " + numero + " x " + i + " = " + (numero * i));
    }
}

void exibirSeparador() {
    IO.println("--------------------------------------------------");
}
