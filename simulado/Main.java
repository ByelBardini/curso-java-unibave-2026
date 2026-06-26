import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Turma turma = new Turma();

        int opcao;
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Cadastrar aluno");
            System.out.println("2 - Listar alunos");
            System.out.println("3 - Buscar aluno");
            System.out.println("4 - Remover aluno");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    nome = nome.trim();
                    if (nome.isBlank()) {
                        System.out.println("Erro: o nome não pode estar vazio.");
                        break;
                    }

                    System.out.print("Matrícula: ");
                    String matricula = sc.nextLine();

                    System.out.print("Nota 1: ");
                    double nota1 = sc.nextDouble();

                    System.out.print("Nota 2: ");
                    double nota2 = sc.nextDouble();
                    if (nota1 < 0 || nota1 > 10 || nota2 < 0 || nota2 > 10) {
                        System.out.println("Erro: as notas devem estar entre 0 e 10.");
                        break;
                    }

                    sc.nextLine();
                    Aluno aluno = new Aluno(nome, matricula, nota1, nota2);
                    turma.cadastrar(aluno);
                    break;

                case 2:
                    turma.listar();
                    break;

                case 3:
                    System.out.print("Digite o nome: ");
                    nome = sc.nextLine();
                    Aluno encontrado = turma.buscar(nome);

                    if (encontrado != null) {
                        System.out.println(encontrado);
                    } else {
                        System.out.println("Aluno não encontrado.");
                    }
                    break;

                case 4:
                    System.out.print("Nome do aluno: ");
                    nome = sc.nextLine();

                    if (turma.remover(nome)) {
                        System.out.println("Aluno removido.");
                    } else {
                        System.out.println("Aluno não encontrado.");
                    }
                    break;

                case 0:
                    System.out.println("Encerrando...");
                    break;

                default:
                    System.out.println("Opção inválida.");

            }
        } while (opcao != 0);
    }
}