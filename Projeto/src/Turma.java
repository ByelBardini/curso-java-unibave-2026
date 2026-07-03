import java.util.ArrayList;
import java.util.List;

public class Turma {

    private List<Aluno> alunos = new ArrayList<>();

    public Turma() {

        alunos.add(new Aluno("Thiago", "001", 8.0, 7.5));
        alunos.add(new Aluno("Carolina", "002", 9.0, 8.5));
        alunos.add(new Aluno("Michele", "003", 8.0, 9.5));
        alunos.add(new Aluno("Caio", "004", 5.5, 6.0));
        alunos.add(new Aluno("Fernando", "005", 8.5, 9.0));
        alunos.add(new Aluno("Miguel", "006", 7.0, 7.0));

    }

    public void listarAlunos() {

        for (Aluno aluno : alunos) {
            System.out.println(aluno);
        }

    }

    public Aluno buscarAluno(String nome) {

        for (Aluno aluno : alunos) {

            if (aluno.getNome().equalsIgnoreCase(nome)) {
                return aluno;
            }

        }

        return null;
    }

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public boolean removerAluno(String nome) {

        Aluno aluno = buscarAluno(nome);

        if (aluno != null) {
            alunos.remove(aluno);
            return true;
        }

        return false;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }
}

