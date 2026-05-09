import java.io.IO;

public class Cachorro01 extends Animal01 {

    public Cachorro01(String nome, String raca) {
        super(nome, raca);
    }

    public void emitirSom() {
        IO.println(nome + " faz: Au au!");
    }
}
