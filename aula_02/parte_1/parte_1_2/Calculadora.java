package aula_02.parte_1.parte_1_2;

class Calculadora {

    void exibirNome() {
        IO.println("Calculadora Java 26");
    }

    void exibirVersao() {
        IO.println("Versão: 1.0");
    }

    void exibirResultadoPi() {
        double pi = Math.PI;
        IO.println("Valor de PI: " + pi);
        IO.println("PI ao quadrado: " + (pi * pi));
    }

    void exibirNumeroAleatorio() {
        int numero = (int) (Math.random() * 100);
        IO.println("Número aleatório (0-99): " + numero);
    }
}
