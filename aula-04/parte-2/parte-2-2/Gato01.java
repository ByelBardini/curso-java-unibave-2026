import java.io.IO;

public class Gato01 extends Animal01 {

    public Gato01(String nome, String raca) {
        super(nome, raca);
    }

    @Override
    public void emitirSom() {
        IO.println(nome + " faz: Miau!");
    }
}
