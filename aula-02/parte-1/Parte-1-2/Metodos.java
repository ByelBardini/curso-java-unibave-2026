// Parte 1.2 - Chamando métodos de outra classe dentro do void main()
void main() {
    Calculadora calculadora = new Calculadora();

    calculadora.exibirNome();
    calculadora.exibirVersao();
    exibirSeparador();
    calculadora.exibirResultadoPi();
    exibirSeparador();
    calculadora.exibirNumeroAleatorio();
}

void exibirSeparador() {
    IO.println("--------------------------------------------------");
}
