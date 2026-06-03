package aula_04.parte_1;

public class Main {

    void main() {
        var pessoa1 = new Pessoa("Ana", 25, "Florianópolis");
        var pessoa2 = new Pessoa("Carlos", 30, "São Paulo");

        pessoa1.apresentar();
        pessoa2.apresentar();
    }
}