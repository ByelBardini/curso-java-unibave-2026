import java.io.IO;

public class Animal01 {
    public String nome;
    public String raca;

    public Animal01(String nome, String raca) {
        this.nome = nome;
        this.raca = raca;
    }

    public void emitirSom() {
        IO.println(nome + " emite um som genérico...");
    }

    public void apresentar() {
        IO.println(nome + " é da raça " + raca + ".");
    }
}
