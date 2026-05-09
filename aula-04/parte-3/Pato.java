import java.io.IO;

public class Pato implements Nadavel, Voavel {
    public String nome;

    public Pato(String nome) {
        this.nome = nome;
    }

    @Override
    public void nadar() {
        IO.println(nome + " está nadando!");
    }

    @Override
    public void voar() {
        IO.println(nome + " está voando!");
    }
}
