package aula_04.parte_2.parte_2_2;

public class Gato extends Animal {

    public Gato(String nome, String raca) {
        super(nome, raca);
    }

    @Override
    public void emitirSom() {
        IO.println(nome + " faz: Miau!");
    }
}
