package aula_04.parte_2.parte_2_2;

public class Cachorro extends Animal {

    public Cachorro(String nome, String raca) {
        super(nome, raca);
    }

    @Override
    public void emitirSom() {
        IO.println(nome + " faz: Au au!");
    }
}
