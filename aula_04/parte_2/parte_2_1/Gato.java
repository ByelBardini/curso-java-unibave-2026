package aula_04.parte_2.parte_2_1;

public class Gato extends Animal {

    public Gato(String nome, String raca) {
        super(nome, raca);
    }

    public void miar() {
        IO.println(nome + " faz: Miau!");
    }
}
