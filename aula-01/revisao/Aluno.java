package revisao;

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

    public String getNome() { return nome; }
    public String getMatricula() { return matricula; }
    public double getNota1() { return nota1; }
    public double getNota2() { return nota2; }

    public double media() { return (nota1 + nota2) / 2.0; }

    public String situacao() { return media() >= 7.0 ? "Aprovado" : "Reprovado"; }

    public String toCSV() {
        return nome.replace(";", ",") + ";" + matricula + ";" + nota1 + ";" + nota2;
    }

    public static Aluno fromCSV(String line) {
        String[] p = line.split(";");
        if (p.length < 4) return null;
        try {
            return new Aluno(p[0], p[1], Double.parseDouble(p[2]), Double.parseDouble(p[3]));
        } catch (NumberFormatException e) {
            return null;
        }
    }

    @Override
    public String toString() {
        return String.format("%s (mat %s) - notas: %.2f, %.2f - média: %.2f - %s",
                nome, matricula, nota1, nota2, media(), situacao());
    }
}
