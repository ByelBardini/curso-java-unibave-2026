import java.util.List;
import java.util.Scanner;

public class Main {

    private static List<Aluno> alunos = Persistencia.carregar();
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== Sistema de Alunos ===");
        System.out.println(alunos.size() + " aluno(s) carregado(s) do arquivo.\n");

        int opcao;
        do {
            exibirMenu();
            opcao = lerInt("Escolha uma opção: ");

            switch (opcao) {
                case 1 -> cadastrarAluno();
                case 2 -> listarAlunos();
                case 3 -> buscarAluno();
                case 4 -> removerAluno();
                case 0 -> System.out.println("Encerrando... Dados salvos!");
                default -> System.out.println("[Erro] Opção inválida.\n");
            }
        } while (opcao != 0);

        sc.close();
    }


    private static void exibirMenu() {
        System.out.println("─".repeat(40));
        System.out.println("1. Cadastrar aluno");
        System.out.println("2. Listar alunos");
        System.out.println("3. Buscar aluno pelo nome");
        System.out.println("4. Remover aluno pelo nome");
        System.out.println("0. Sair");
        System.out.println("─".repeat(40));
    }



    private static void cadastrarAluno() {
        System.out.println("\n[ Cadastro de Aluno ]");


        String nome = lerString("Nome: ");
        if (nome.isBlank()) {
            System.out.println("[Erro] O nome não pode ser vazio.\n");
            return;
        }


        String matricula = lerString("Matrícula: ");
        if (matricula.isBlank()) {
            System.out.println("[Erro] A matrícula não pode ser vazia.\n");
            return;
        }


        double nota1 = lerDouble("Nota 1 (0–10): ");
        if (!notaValida(nota1)) {
            System.out.println("[Erro] Nota 1 deve estar entre 0 e 10.\n");
            return;
        }


        double nota2 = lerDouble("Nota 2 (0–10): ");
        if (!notaValida(nota2)) {
            System.out.println("[Erro] Nota 2 deve estar entre 0 e 10.\n");
            return;
        }

        Aluno aluno = new Aluno(nome, matricula, nota1, nota2);
        alunos.add(aluno);
        Persistencia.salvar(alunos);

        System.out.printf("[OK] Aluno cadastrado! Média: %.1f — %s%n%n",
                aluno.getMedia(), aluno.getSituacao());
    }

    private static void listarAlunos() {
        System.out.println("\n[ Lista de Alunos ]");
        if (alunos.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.\n");
            return;
        }

        System.out.println("─".repeat(80));
        System.out.printf("%-20s | %-10s | %-12s | %-12s | %-10s | %s%n",
                "Nome", "Matrícula", "Nota 1", "Nota 2", "Média", "Situação");
        System.out.println("─".repeat(80));

        for (Aluno a : alunos) {
            System.out.println(a);
        }
        System.out.println("─".repeat(80));
        System.out.println("Total: " + alunos.size() + " aluno(s)\n");
    }

    private static void buscarAluno() {
        System.out.println("\n[ Busca de Aluno ]");
        String nome = lerString("Nome para buscar: ");

        List<Aluno> encontrados = alunos.stream()
                .filter(a -> a.getNome().equalsIgnoreCase(nome))
                .toList();

        if (encontrados.isEmpty()) {
            System.out.println("[Aviso] Nenhum aluno encontrado com o nome \"" + nome + "\".\n");
        } else {
            System.out.println("─".repeat(80));
            encontrados.forEach(System.out::println);
            System.out.println("─".repeat(80));
            System.out.println(encontrados.size() + " resultado(s)\n");
        }
    }

    private static void removerAluno() {
        System.out.println("\n[ Remoção de Aluno ]");
        String nome = lerString("Nome para remover: ");

        boolean removeu = alunos.removeIf(a -> a.getNome().equalsIgnoreCase(nome));

        if (removeu) {
            Persistencia.salvar(alunos);
            System.out.println("[OK] Aluno(s) com nome \"" + nome + "\" removido(s).\n");
        } else {
            System.out.println("[Aviso] Nenhum aluno encontrado com o nome \"" + nome + "\".\n");
        }
    }


    private static String lerString(String prompt) {
        System.out.print(prompt);
        return sc.nextLine().trim();
    }

    private static int lerInt(String prompt) {
        System.out.print(prompt);
        String linha = sc.nextLine().trim();
        try {
            return Integer.parseInt(linha);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static double lerDouble(String prompt) {
        while (true) {
            System.out.print(prompt);
            String linha = sc.nextLine().trim().replace(",", ".");
            try {
                return Double.parseDouble(linha);
            } catch (NumberFormatException e) {
                System.out.println("[Erro] Digite um número válido.");
            }
        }
    }

    private static boolean notaValida(double nota) {
        return nota >= 0.0 && nota <= 10.0;
    }
}
