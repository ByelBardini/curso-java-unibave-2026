public class Main {

    static void main() {
        ListarAlunos turma = new ListarAlunos();
        turma.adicionarAluno(new Alunos("Bruno", 10.0, 9.0));
        turma.adicionarAluno(new Alunos("Carlos", 5.5, 6.0));
        turma.adicionarAluno(new Alunos("Ana", 9.5, 8.5));
        turma.adicionarAluno(new Alunos("Julia", 7.5, 8.0));
        turma.adicionarAluno(new Alunos("Pedro", 2.5, 3.0));

        Alunos.exibirDados();
    }
}
