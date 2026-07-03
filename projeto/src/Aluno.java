package projeto.src;

import java.io.Serializable;

public class Aluno implements Serializable {
    private static final long serialVersionUID = 1L;

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

    public String getNome()       { return nome; }
    public String getMatricula()  { return matricula; }
    public double getNota1()      { return nota1; }
    public double getNota2()      { return nota2; }

    public double getMedia() {
        return (nota1 + nota2) / 2.0;
    }

    public String getSituacao() {
        return getMedia() >= 7.0 ? "Aprovado" : "Reprovado";
    }

    @Override
    public String toString() {
        return String.format("%-20s | %-10s | Nota1: %5.1f | Nota2: %5.1f | Média: %5.1f | %s",
                nome, matricula, nota1, nota2, getMedia(), getSituacao());
    }
}
