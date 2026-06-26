public class Aluno {

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

    public double getMedia() {
        return (nota1 + nota2) / 2;
    }

    public boolean aprovado() {
        return getMedia() >= 7;
    }

    // getters e setters
}