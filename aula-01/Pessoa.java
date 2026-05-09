import java.io.IO;

public class Pessoa {
    public String nome;
    public int idade;
    public String cidade;

    public Pessoa(String nome, int idade, String cidade) {
        this.nome = nome;
        this.idade = idade;
        this.cidade = cidade;
    }

    public void apresentar() {
        IO.println("Olá! Meu nome é " + nome + ", tenho " + idade + " anos e moro em " + cidade + ".");
    }
}
