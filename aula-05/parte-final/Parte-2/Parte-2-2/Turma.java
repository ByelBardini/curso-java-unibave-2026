import java.util.ArrayList;
import java.util.List;

public class Turma {
    private List<Aluno> alunos = new ArrayList<>();

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public double calcularMedia() {
        if (alunos.isEmpty()) {
            return 0;
        }
        double soma = 0;
        for (Aluno aluno : alunos) {
            soma += aluno.getNota();
        }
        return soma / alunos.size();
    }

    public List<Aluno> alunosAprovados() {
        List<Aluno> aprovados = new ArrayList<>();
        for (Aluno aluno : alunos) {
            if (aluno.getNota() >= 6.0) {
                aprovados.add(aluno);
            }
        }
        return aprovados;
    }

    public Aluno melhorAluno() {
        if (alunos.isEmpty()) {
            return null;
        }
        Aluno melhor = alunos.get(0);
        for (Aluno aluno : alunos) {
            if (aluno.getNota() > melhor.getNota()) {
                melhor = aluno;
            }
        }
        return melhor;
    }

    public void exibirTodos() {
        for (Aluno aluno : alunos) {
            aluno.exibirDados();
        }
    }
}
