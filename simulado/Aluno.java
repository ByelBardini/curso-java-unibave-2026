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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }


    public double getMedia() {
        return (nota1 + nota2) / 2;
    }

    public boolean aprovado() {
        return getMedia() >= 7;
    }
    @Override
    public String toString() {
        return "Nome: " + nome +
                "\nMatrícula: " + matricula +
                "\nNota 1: " + nota1 +
                "\nNota 2: " + nota2 +
                "\nMédia: " + String.format("%.2f", getMedia()) +
                "\nSituação: " + (aprovado() ? "Aprovado" : "Reprovado");
    }
}