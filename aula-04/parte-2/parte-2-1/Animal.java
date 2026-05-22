public class Animal {
    public String nome;
    public String raca;

    public Animal(String nome, String raca) {
        this.nome = nome;
        this.raca = raca;
    }

    public void dormir() {
        IO.println(nome + " está dormindo... 💤");
    }

    public void apresentar() {
        IO.println(nome + " é da raça " + raca + ".");
    }
}
