package revisao;

import java.util.*;

public class MainRevisao {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        AlunoRepository repo = new AlunoRepository("aula-01\\alunos.csv");
        while (true) {
            System.out.println("\n=== Gestão de Alunos ===");
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Listar alunos (por média desc)");
            System.out.println("3 - Buscar por nome");
            System.out.println("4 - Remover por nome");
            System.out.println("5 - Estatísticas");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            String opt = sc.nextLine().trim();
            switch (opt) {
                case "1":
                    cadastrar(repo);
                    break;
                case "2":
                    listar(repo);
                    break;
                case "3":
                    buscar(repo);
                    break;
                case "4":
                    remover(repo);
                    break;
                case "5":
                    estatisticas(repo);
                    break;
                case "0":
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void cadastrar(AlunoRepository repo) {
        System.out.print("Nome: ");
        String nome = sc.nextLine().trim();
        if (nome.isEmpty()) {
            System.out.println("Nome não pode ser vazio.");
            return;
        }
        System.out.print("Matrícula: ");
        String mat = sc.nextLine().trim();
        if (mat.isEmpty()) {
            System.out.println("Matrícula não pode ser vazia.");
            return;
        }
        if (repo.list().stream().anyMatch(a -> a.getMatricula().equals(mat))) {
            System.out.println("Matrícula já existe.");
            return;
        }
        double n1 = lerNota("Nota 1: ");
        if (Double.isNaN(n1)) return;
        double n2 = lerNota("Nota 2: ");
        if (Double.isNaN(n2)) return;
        Aluno a = new Aluno(nome, mat, n1, n2);
        if (repo.add(a)) System.out.println("Aluno cadastrado.");
        else System.out.println("Erro ao cadastrar aluno.");
    }

    private static double lerNota(String prompt) {
        System.out.print(prompt);
        String s = sc.nextLine().trim();
        try {
            double v = Double.parseDouble(s.replace(',', '.'));
            if (v < 0 || v > 10) {
                System.out.println("Nota fora do intervalo 0–10.");
                return Double.NaN;
            }
            return v;
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida para nota.");
            return Double.NaN;
        }
    }

    private static void listar(AlunoRepository repo) {
        List<Aluno> list = repo.list();
        list.sort(Comparator.comparingDouble(Aluno::media).reversed());
        if (list.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }
        for (Aluno a : list) System.out.println(a);
    }

    private static void buscar(AlunoRepository repo) {
        System.out.print("Nome para buscar: ");
        String nome = sc.nextLine().trim();
        Aluno a = repo.findByName(nome);
        if (a == null) System.out.println("Aluno não encontrado.");
        else System.out.println(a);
    }

    private static void remover(AlunoRepository repo) {
        System.out.print("Nome para remover: ");
        String nome = sc.nextLine().trim();
        if (repo.removeByName(nome)) System.out.println("Aluno removido.");
        else System.out.println("Aluno não encontrado.");
    }

    private static void estatisticas(AlunoRepository repo) {
        List<Aluno> list = repo.list();
        if (list.isEmpty()) {
            System.out.println("Nenhum aluno cadastrado.");
            return;
        }
        long total = list.size();
        long aprov = list.stream().filter(a -> a.media() >= 7.0).count();
        long repro = total - aprov;
        double max = list.stream().mapToDouble(Aluno::media).max().orElse(0);
        double min = list.stream().mapToDouble(Aluno::media).min().orElse(0);
        System.out.printf("Total: %d | Aprovados: %d | Reprovados: %d | Maior média: %.2f | Menor média: %.2f%n", total, aprov, repro, max, min);
    }
}
