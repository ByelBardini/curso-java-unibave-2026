import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();

        int opcao;

        do {
            System.out.println("\n===== BIBLIOTECA =====");
            System.out.println("1 - Cadastrar Livro");
            System.out.println("2 - Cadastrar Revista");
            System.out.println("3 - Listar acervo");
            System.out.println("4 - Emprestar item");
            System.out.println("5 - Devolver item");
            System.out.println("6 - Remover item");
            System.out.println("7 - Resumo do acervo");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            if (!sc.hasNextInt()) {
                System.out.println("Opção inválida.");
                sc.nextLine();
                continue;
            }

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1 -> {

                    System.out.println("\n=== CADASTRAR LIVRO ===");

                    System.out.print("Título: ");
                    String titulo = sc.nextLine().trim();

                    if (titulo.isBlank()) {
                        System.out.println("Erro: título não pode ser vazio.");
                        break;
                    }

                    System.out.print("Autor: ");
                    String autor = sc.nextLine().trim();

                    if (autor.isBlank()) {
                        System.out.println("Erro: autor não pode ser vazio.");
                        break;
                    }

                    System.out.print("ISBN: ");
                    String isbn = sc.nextLine().trim();

                    if (isbn.isBlank()) {
                        System.out.println("Erro: ISBN não pode ser vazio.");
                        break;
                    }

                    System.out.print("Ano: ");

                    if (!sc.hasNextInt()) {
                        System.out.println("Erro: ano inválido.");
                        sc.nextLine();
                        break;
                    }

                    int ano = sc.nextInt();
                    sc.nextLine();

                    Livro livro = new Livro(titulo, autor, isbn, ano);

                    boolean sucesso = biblioteca.cadastrar(livro);

                    if (sucesso) {
                        System.out.println("Livro cadastrado com sucesso!");
                    } else {
                        System.out.println("Já existe um item com esse título.");
                    }
                }

                case 2 -> {

                    System.out.println("\n=== CADASTRAR REVISTA ===");

                    System.out.print("Título: ");
                    String titulo = sc.nextLine().trim();

                    if (titulo.isBlank()) {
                        System.out.println("Erro: título não pode ser vazio.");
                        break;
                    }

                    System.out.print("Editora: ");
                    String editora = sc.nextLine().trim();

                    if (editora.isBlank()) {
                        System.out.println("Erro: editora não pode ser vazia.");
                        break;
                    }

                    System.out.print("Número da edição: ");

                    if (!sc.hasNextInt()) {
                        System.out.println("Erro: número da edição inválido.");
                        sc.nextLine();
                        break;
                    }

                    int numeroEdicao = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Ano: ");

                    if (!sc.hasNextInt()) {
                        System.out.println("Erro: ano inválido.");
                        sc.nextLine();
                        break;
                    }

                    int ano = sc.nextInt();
                    sc.nextLine();

                    Revista revista = new Revista(titulo, editora, numeroEdicao, ano);

                    boolean sucesso = biblioteca.cadastrar(revista);

                    if (sucesso) {
                        System.out.println("Revista cadastrada com sucesso!");
                    } else {
                        System.out.println("Já existe um item com esse título.");
                    }
                }

                case 3 -> biblioteca.listar();

                case 4 -> {

                    System.out.println("\n=== EMPRESTAR ITEM ===");

                    System.out.print("Título do item: ");
                    String titulo = sc.nextLine().trim();

                    if (titulo.isBlank()) {
                        System.out.println("Erro: título não pode ser vazio.");
                        break;
                    }

                    System.out.print("Nome do responsável: ");
                    String responsavel = sc.nextLine().trim();

                    if (responsavel.isBlank()) {
                        System.out.println("Erro: nome do responsável não pode ser vazio.");
                        break;
                    }

                    try {
                        biblioteca.emprestar(titulo, responsavel);
                        System.out.println("Empréstimo realizado com sucesso!");
                    }
                    catch (ItemNaoEncontradoException e) {
                        System.out.println(e.getMessage());
                    }
                    catch (ItemIndisponivelException e) {
                        System.out.println(e.getMessage());
                    }
                    catch (LimiteEmprestimosException e) {
                        System.out.println(e.getMessage());
                    }
                }

                case 5 -> {

                    System.out.println("\n=== DEVOLVER ITEM ===");

                    System.out.print("Título do item: ");
                    String titulo = sc.nextLine().trim();

                    if (titulo.isBlank()) {
                        System.out.println("Erro: título não pode ser vazio.");
                        break;
                    }

                    try {
                        biblioteca.devolver(titulo);
                        System.out.println("Devolução realizada com sucesso!");
                    }
                    catch (ItemNaoEncontradoException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 6 -> {

                    System.out.println("\n=== REMOVER ITEM ===");

                    System.out.print("Título do item: ");
                    String titulo = sc.nextLine().trim();

                    if (titulo.isBlank()) {
                        System.out.println("Erro: título não pode ser vazio.");
                        break;
                    }

                    boolean removido = biblioteca.remover(titulo);

                    if (removido) {
                        System.out.println("Item removido com sucesso!");
                    } else {
                        System.out.println("Item não encontrado.");
                    }
                }
                case 7 -> biblioteca.resumo();
                case 0 -> System.out.println("Encerrando...");

                default -> System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        sc.close();
    }
}