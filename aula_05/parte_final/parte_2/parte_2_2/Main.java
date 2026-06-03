package aula_05.parte_final.parte_2.parte_2_2;

import java.util.List;

public class Main {

    void main() {
        var turma = new Turma();

        turma.adicionarAluno(new Aluno("Ana", 8.5));
        turma.adicionarAluno(new Aluno("Bruno", 5.0));
        turma.adicionarAluno(new Aluno("Carla", 9.2));
        turma.adicionarAluno(new Aluno("Daniel", 4.7));
        turma.adicionarAluno(new Aluno("Eduarda", 7.3));

        IO.println("=== Alunos da turma ===");
        turma.exibirTodos();

        IO.println("\n=== Média da turma ===");
        IO.println("Média: " + turma.calcularMedia());

        IO.println("\n=== Alunos aprovados ===");
        List<Aluno> aprovados = turma.alunosAprovados();
        if (aprovados.isEmpty()) {
            IO.println("Nenhum aluno aprovado.");
        } else {
            for (Aluno aluno : aprovados) {
                aluno.exibirDados();
            }
        }

        IO.println("\n=== Melhor aluno ===");
        Aluno melhor = turma.melhorAluno();
        if (melhor == null) {
            IO.println("A turma está vazia.");
        } else {
            IO.println("Nome: " + melhor.getNome() + " | Nota: " + melhor.getNota());
        }
    }
}