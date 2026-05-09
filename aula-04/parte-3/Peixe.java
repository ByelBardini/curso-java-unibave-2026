import java.io.IO;

public class Peixe implements Nadavel {
    public String nome;

    public Peixe(String nome) {
        this.nome = nome;
    }

    @Override
    public void nadar() {
        IO.println(nome + " está nadando!");
    }
}
