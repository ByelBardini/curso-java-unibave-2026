package Projeto.src;

import java.util.ArrayList;
import java.util.List;

public class ListarAlunos {

    private List<Alunos> alunos;

    public ListarAlunos() {
        alunos = new ArrayList<>();
    }

    public void adicionarAluno(Alunos aluno) {
        alunos.add(aluno);
    }

    public void exibirTodos() {
        System.out.println("\n" +
                "=== Todos os Alunos ===");
        for (Alunos aluno : alunos) {
            aluno.exibirDados();
        }
    }
}
