public class Cachorro extends Animal {

    public Cachorro(String nome, String raca) {
        super(nome, raca);
    }

    public void latir() {
        IO.println(nome + " faz: Au au!");
    }
}
