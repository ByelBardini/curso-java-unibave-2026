package aula_04.parte_final.exercicio_5;

public class Main {

    void main() {
        var smartphone = new Smartphone();
        var fone = new Fone();

        IO.println("=== Smartphone ===");
        smartphone.carregar();
        smartphone.reproduzir();

        IO.println("---");

        IO.println("=== Fone ===");
        fone.reproduzir();
    }
}