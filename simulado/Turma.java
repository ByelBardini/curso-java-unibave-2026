import java.util.ArrayList;
public class Turma {

    private ArrayList<Aluno> alunos = new ArrayList<>();

    public Turma() {
        alunos = Persistencia.carregar();
    }

    public boolean matriculaExiste(String matricula) {
        for (Aluno aluno : alunos) {
            if (aluno.getMatricula().equalsIgnoreCase(matricula)) {
                return true;
            }
        }
        return false;
    }
    public boolean cadastrar(Aluno aluno) {
        if (matriculaExiste(aluno.getMatricula())) {
            return false;
        }
        alunos.add(aluno);
        Persistencia.salvar(alunos);
        return true;
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
            Persistencia.salvar(alunos);
            return true;
        }

        return false;
    }


}
