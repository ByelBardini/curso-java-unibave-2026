package aula_04.parte_2.parte_2_2;

public class Animal {
    public String nome;
    public String raca;

    public Animal(String nome, String raca) {
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
