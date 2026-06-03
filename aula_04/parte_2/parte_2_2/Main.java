package aula_04.parte_2.parte_2_2;

public class Main {

    void main() {
        var cachorro = new Cachorro("Rex", "Labrador");
        var gato = new Gato("Mimi", "Siamês");

        cachorro.apresentar();
        cachorro.emitirSom();

        IO.println("---");

        gato.apresentar();
        gato.emitirSom();
    }
}