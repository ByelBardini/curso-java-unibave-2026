package aula_02.parte_1.parte_1_2;

public class Metodos {

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
}