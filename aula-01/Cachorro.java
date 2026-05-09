import java.io.IO;

public class Cachorro extends Animal01 {

    public Cachorro(String nome, String raca) {
        super(nome, raca);
    }

    public void latir() {
        IO.println(nome + " faz: Au au!");
    }
}
