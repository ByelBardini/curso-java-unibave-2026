import java.io.IO;

public class Gato extends Animal01 {

    public Gato(String nome, String raca) {
        super(nome, raca);
    }

    public void miar() {
        IO.println(nome + " faz: Miau!");
    }
}
