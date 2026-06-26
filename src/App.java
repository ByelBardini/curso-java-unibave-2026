import java.util.List;
import java.util.OptionalDouble;
import java.util.Scanner;

public class App {
    private Repositorio repo = new Repositorio();
    private Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        new App().run();
    }

    private void run() {
        while (true) {
            showMenu();
            String opt = sc.nextLine().trim();
            switch (opt) {
                case "1": cadastrar(); break;
                case "2": listar(); break;
                case "3": buscar(); break;
                case "4": remover(); break;
                case "5": estatisticas(); break;
                case "6": listarOrdenado(); break;
                case "0": System.out.println("Saindo..."); return;
                default: System.out.println("Opção inválida.");
            }
        }
    }

    private void showMenu() {
        System.out.println("\n=== Sistema de Turma ===");
        System.out.println("1 - Cadastrar aluno");
        System.out.println("2 - Listar alunos");
        System.out.println("3 - Buscar aluno por nome");
        System.out.println("4 - Remover aluno por nome");
        System.out.println("5 - Estatísticas da turma");
        System.out.println("6 - Listar por média (desc)");
        System.out.println("0 - Sair");
        System.out.print("Escolha: ");
    }

    private void cadastrar() {
        try {
            System.out.print("Nome: ");
            String nome = sc.nextLine().trim();
            if (nome.isEmpty()) {
                System.out.println("Erro: nome não pode ser vazio.");
                return;
            }
            System.out.print("Matrícula: ");
            String mat = sc.nextLine().trim();
            if (mat.isEmpty()) {
                System.out.println("Erro: matrícula não pode ser vazia.");
                return;
            }
            System.out.print("Nota 1 (0-10): ");
            double n1 = Double.parseDouble(sc.nextLine().trim());
            if (n1 < 0 || n1 > 10) { System.out.println("Erro: nota inválida."); return; }
            System.out.print("Nota 2 (0-10): ");
            double n2 = Double.parseDouble(sc.nextLine().trim());
            if (n2 < 0 || n2 > 10) { System.out.println("Erro: nota inválida."); return; }

            Aluno a = new Aluno(nome, mat, n1, n2);
            boolean ok = repo.adicionar(a);
            if (!ok) {
                System.out.println("Erro: matrícula já existente.");
            } else {
                System.out.println("Aluno cadastrado com sucesso.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Erro: entrada de número inválida.");
        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
        }
    }

    private void listar() {
        List<Aluno> todos = repo.listar();
        if (todos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }
        System.out.println("\n--- Lista de Alunos ---");
        for (Aluno a : todos) {
            System.out.println(a);
        }
    }

    private void listarOrdenado() {
        List<Aluno> ordenado = repo.listarOrdenadoPorMediaDesc();
        if (ordenado.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }
        System.out.println("\n--- Alunos por média (desc) ---");
        for (Aluno a : ordenado) System.out.println(a);
    }

    private void buscar() {
        System.out.print("Nome para buscar: ");
        String nome = sc.nextLine().trim();
        if (nome.isEmpty()) { System.out.println("Erro: nome não pode ser vazio."); return; }
        List<Aluno> encontrados = repo.buscarPorNome(nome);
        if (encontrados.isEmpty()) {
            System.out.println("Nenhum aluno encontrado com esse nome.");
            return;
        }
        System.out.println("\n--- Resultados ---");
        for (Aluno a : encontrados) System.out.println(a);
    }

    private void remover() {
        System.out.print("Nome exato para remover: ");
        String nome = sc.nextLine().trim();
        if (nome.isEmpty()) { System.out.println("Erro: nome não pode ser vazio."); return; }
        boolean ok = repo.removerPorNome(nome);
        if (ok) System.out.println("Aluno removido."); else System.out.println("Aluno não encontrado.");
    }

    private void estatisticas() {
        int total = repo.totalAlunos();
        long aprov = repo.countAprovados();
        long repro = repo.countReprovados();
        OptionalDouble max = repo.maiorMedia();
        OptionalDouble min = repo.menorMedia();
        System.out.println("\n--- Estatísticas ---");
        System.out.println("Total de alunos: " + total);
        System.out.println("Aprovados: " + aprov);
        System.out.println("Reprovados: " + repro);
        System.out.println("Maior média: " + (max.isPresent() ? String.format("%.2f", max.getAsDouble()) : "N/A"));
        System.out.println("Menor média: " + (min.isPresent() ? String.format("%.2f", min.getAsDouble()) : "N/A"));
    }
}
