package aula_04.parte_final.exercicio_1;

public class Main {

    void main() {
        var produto1 = new Produto("Caneta", 2.50);
        var produto2 = new Produto("Caderno", 15.90, 100);

        produto1.exibir();
        produto2.exibir();
    }
}