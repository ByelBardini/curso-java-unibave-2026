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
        alunos.sort((a1, a2) ->
                Double.compare(a2.getMedia(), a1.getMedia()));
        for (Aluno aluno : alunos) {
            System.out.println("\n================================================");
            System.out.println(aluno);
            System.out.println("================================================\n");
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
    public void estatisticas() {
        if (alunos.isEmpty()) {
        System.out.println("Nenhum aluno cadastrado.");
        return;
    }
        int aprovados = 0;
        int reprovados = 0;

        double maiorMedia = alunos.get(0).getMedia();
        double menorMedia = alunos.get(0).getMedia();
        for (Aluno aluno : alunos) {
            if (aluno.aprovado()) {
                aprovados++;
            } else {
                reprovados++;
            }
            if (aluno.getMedia() > maiorMedia) {
                maiorMedia = aluno.getMedia();
            }
            if (aluno.getMedia() < menorMedia) {
                menorMedia = aluno.getMedia();
            }
        }
        System.out.println("\n===== ESTATÍSTICAS =====");
        System.out.println("Total de alunos: " + alunos.size());
        System.out.println("Aprovados: " + aprovados);
        System.out.println("Reprovados: " + reprovados);
        System.out.println("Maior média: " + String.format("%.2f", maiorMedia));
        System.out.println("Menor média: " + String.format("%.2f", menorMedia));
    }

}
