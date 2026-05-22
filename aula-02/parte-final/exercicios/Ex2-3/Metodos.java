void main() {
    exibirTabuada(5, 5);
    IO.println("");
    exibirTabuada(3, 12);
}

void exibirTabuada(int numero, int limite) {
    for (int i = 1; i <= limite; i++) {
        IO.println(numero + " x " + i + " = " + (numero * i));
    }
}
