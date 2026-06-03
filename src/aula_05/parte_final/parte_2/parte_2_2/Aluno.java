package aula_05.parte_final.parte_2.parte_2_2;

public class Aluno {
    private String nome;
    private double nota;

    public Aluno(String nome, double nota) {
        this.nome = nome;
        this.nota = nota;
    }

    public String getNome() {
        return nome;
    }

    public double getNota() {
        return nota;
    }

    public void exibirDados() {
        IO.println("Aluno: " + nome + " | Nota: " + nota);
    }
}
