class Impressora {

    void imprimir(String mensagem) {
        IO.println("[texto]  " + mensagem);
    }

    void imprimir(int numero) {
        IO.println("[número] " + numero);
    }

    void imprimir(double numero) {
        IO.println("[double] " + numero);
    }

    void exibirTabuada(int numero) {
        IO.println("Tabuada do " + numero + ":");
        for (int i = 1; i <= 10; i++) {
            IO.println("  " + numero + " x " + i + " = " + (numero * i));
        }
    }

    void exibirResultado(String operacao, double resultado) {
        IO.println(operacao + " = " + resultado);
    }
}
