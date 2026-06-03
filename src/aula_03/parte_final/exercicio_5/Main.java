package aula_03.parte_final.exercicio_5;

public class Main {

    void matricular(Turma t) {
        t.quantidadeDeAlunos = t.quantidadeDeAlunos + 1;
        IO.println("Aluno matriculado na turma " + t.nome + ". Total: " + t.quantidadeDeAlunos);
    }

    void main() {
        Turma turma = new Turma();
        turma.nome = "Java 2026";
        turma.quantidadeDeAlunos = 0;

        matricular(turma);
        matricular(turma);
        matricular(turma);

        IO.println("Total de alunos na turma: " + turma.quantidadeDeAlunos);
    }
}