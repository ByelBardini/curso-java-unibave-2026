import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();

        int opcao;

        do {

            System.out.println("\n=== BIBLIOTECA ===");
            System.out.println("1 - Cadastrar Livro");
            System.out.println("2 - Cadastrar Revista");
            System.out.println("3 - Listar Acervo");
            System.out.println("4 - Emprestar");
            System.out.println("5 - Devolver");
            System.out.println("6 - Remover");
            System.out.println("7 - Resumo");
            System.out.println("0 - Sair");

            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            try {

                switch (opcao) {

                    case 1:

                        System.out.print("Título: ");
                        String tituloLivro = scanner.nextLine();

                        System.out.print("Autor: ");
                        String autor = scanner.nextLine();

                        System.out.print("ISBN: ");
                        String isbn = scanner.nextLine();

                        System.out.print("Ano de publicação: ");
                        int anoLivro = scanner.nextInt();
                        scanner.nextLine();

                        biblioteca.cadastrarLivro(
                                tituloLivro,
                                autor,
                                isbn,
                                anoLivro
                        );

                        System.out.println("Livro cadastrado com sucesso!");
                        break;

                    case 2:

                        System.out.print("Título: ");
                        String tituloRevista = scanner.nextLine();

                        System.out.print("Editora: ");
                        String editora = scanner.nextLine();

                        System.out.print("Número da edição: ");
                        int numeroEdicao = scanner.nextInt();

                        System.out.print("Ano da edição: ");
                        int anoEdicao = scanner.nextInt();
                        scanner.nextLine();

                        biblioteca.cadastrarRevista(
                                tituloRevista,
                                editora,
                                numeroEdicao,
                                anoEdicao
                        );

                        System.out.println("Revista cadastrada com sucesso!");
                        break;

                    case 3:

                        biblioteca.listarItens();
                        break;

                    case 4:

                        System.out.print("Título do item: ");
                        String tituloEmprestimo = scanner.nextLine();

                        System.out.print("Nome do responsável: ");
                        String responsavel = scanner.nextLine();

                        biblioteca.emprestar(
                                tituloEmprestimo,
                                responsavel
                        );

                        System.out.println("Empréstimo realizado com sucesso!");
                        break;

                    case 5:

                        System.out.print("Título do item: ");
                        String tituloDevolucao = scanner.nextLine();

                        biblioteca.devolver(tituloDevolucao);

                        System.out.println("Item devolvido com sucesso!");
                        break;

                    case 6:

                        System.out.print("Título do item: ");
                        String tituloRemocao = scanner.nextLine();

                        biblioteca.remover(tituloRemocao);

                        System.out.println("Item removido com sucesso!");
                        break;

                    case 7:

                        biblioteca.resumo();
                        break;

                    case 0:

                        System.out.println("Encerrando sistema...");
                        break;

                    default:

                        System.out.println("Opção inválida!");

                }

            } catch (BibliotecaException e) {

                System.out.println("Erro: " + e.getMessage());

            } catch (Exception e) {

                System.out.println("Entrada inválida!");
                scanner.nextLine();
            }

        } while (opcao != 0);

        scanner.close();
    }
}