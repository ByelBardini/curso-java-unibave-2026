public class Main {
    public static void main(String[] args) {
        // Referencia classes para garantir que sejam carregadas
        System.out.println("Inicializando aplicação...");
        System.out.println("Classes carregadas: " + Aluno.class.getSimpleName()
                + ", " + Repositorio.class.getSimpleName()
                + ", " + App.class.getSimpleName());

        // Inicializa repositório (carrega dados) e delega para o App (CLI)
        Repositorio repo = new Repositorio();
        System.out.println("Total de alunos no repositório: " + repo.totalAlunos());

        App.main(args);
    }
}
