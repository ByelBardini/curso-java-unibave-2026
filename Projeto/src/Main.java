import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Turma turma = new Turma();

        int opcao;

        do {

            System.out.println("\n=== MENU ===");
            System.out.println("1 - Listar alunos");
            System.out.println("2 - Buscar aluno");
            System.out.println("3 - Remover aluno");
            System.out.println("0 - Sair");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:

                    turma.listarAlunos();
                    break;

                case 2:

                    System.out.print("Digite o nome: ");
                    String nomeBusca = scanner.nextLine();

                    Aluno aluno = turma.buscarAluno(nomeBusca);

                    if (aluno != null) {
                        System.out.println(aluno);
                    } else {
                        System.out.println("Aluno não encontrado.");
                    }

                    break;

                case 3:

                    System.out.print("Digite o nome: ");
                    String nomeRemover = scanner.nextLine();

                    if (turma.removerAluno(nomeRemover)) {
                        System.out.println("Aluno removido.");
                    } else {
                        System.out.println("Aluno não encontrado.");
                    }

                    break;

            }

        } while (opcao != 0);

        scanner.close();
    }
}