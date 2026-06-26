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

    public double calcularMedia() {
        return (nota1 + nota2) / 2;
    }

    public String getSituacao() {
        if (calcularMedia() >= 7) {
            return "Aprovado";
        }
        return "Reprovado";
    }

    @Override
    public String toString() {
        return "Nome: " + nome +
                " | Matrícula: " + matricula +
                " | Média: " + String.format("%.2f", calcularMedia()) +
                " | Situação: " + getSituacao();
    }
}