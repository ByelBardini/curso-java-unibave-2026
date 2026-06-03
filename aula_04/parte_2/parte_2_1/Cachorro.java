package aula_04.parte_2.parte_2_1;

public class Cachorro extends Animal {

    public Cachorro(String nome, String raca) {
        super(nome, raca);
    }

    public void latir() {
        IO.println(nome + " faz: Au au!");
    }
}
