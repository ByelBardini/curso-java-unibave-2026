import java.util.ArrayList;
public class Turma {
    private ArrayList<Aluno> alunos = new ArrayList<>();

    public void cadastrar(Aluno aluno) {
        alunos.add(aluno);
        System.out.println("Aluno cadastrado com sucesso!");
    }
    public void listar() {
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }

        for (Aluno aluno : alunos) {
            System.out.println(aluno);
            System.out.println("----------------------");
        }
    }
    public Aluno buscar(String nome) {

        for (Aluno aluno : alunos) {

            if (aluno.getNome().equalsIgnoreCase(nome)) {
                return aluno;
            }

        }

        return null;
    }
    public boolean remover(String nome) {

        Aluno aluno = buscar(nome);

        if (aluno != null) {
            alunos.remove(aluno);
            return true;
        }

        return false;
    }
}
