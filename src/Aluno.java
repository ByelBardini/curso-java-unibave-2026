import java.io.Serializable;

public class Aluno implements Serializable {
    private String nome;
    private String matricula;
    private double nota1;
    private double nota2;

    public Aluno(String nome, String matricula, double nota1, double nota2) {
        this.nome = nome;
        this.matricula = matricula;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public double getNota1() {
        return nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public double getMedia() {
        return (nota1 + nota2) / 2.0;
    }

    public boolean isAprovado() {
        return getMedia() >= 7.0;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s | Matrícula: %s | Nota1: %.2f | Nota2: %.2f | Média: %.2f | %s",
                nome, matricula, nota1, nota2, getMedia(), (isAprovado() ? "Aprovado" : "Reprovado"));
    }
}
