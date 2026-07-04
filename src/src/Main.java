import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();

        int op;

        do {

            System.out.println("\n1 livro");
            System.out.println("2 revista");
            System.out.println("3 listar tudo");
            System.out.println("4 listar livros");
            System.out.println("5 listar revistas");
            System.out.println("6 emprestar");
            System.out.println("7 devolver");
            System.out.println("8 remover");
            System.out.println("9 resumo");
            System.out.println("10 buscar autor");
            System.out.println("11 buscar editora");
            System.out.println("0 sair");

            op = lerInt(sc, "opcao: ");

            switch (op) {

                case 1 -> {
                    System.out.print("titulo: ");
                    String t = sc.nextLine();
                    System.out.print("autor: ");
                    String a = sc.nextLine();
                    System.out.print("isbn: ");
                    String i = sc.nextLine();
                    int an = lerInt(sc, "ano: ");

                    System.out.println(
                            biblioteca.cadastrar(new Livro(t, a, i, an))
                                    ? "cadastrado"
                                    : "ja existe"
                    );
                }

                case 2 -> {
                    System.out.print("titulo: ");
                    String t = sc.nextLine();
                    System.out.print("editora: ");
                    String e = sc.nextLine();
                    int ed = lerInt(sc, "edicao: ");
                    int an = lerInt(sc, "ano: ");

                    System.out.println(
                            biblioteca.cadastrar(new Revista(t, e, ed, an))
                                    ? "cadastrado"
                                    : "ja existe"
                    );
                }

                case 3 -> biblioteca.listar();
                case 4 -> biblioteca.listarLivros();
                case 5 -> biblioteca.listarRevistas();

                case 6 -> {
                    System.out.print("titulo: ");
                    String t = sc.nextLine();
                    System.out.print("responsavel: ");
                    String r = sc.nextLine();

                    try {
                        biblioteca.emprestar(t, r);
                        System.out.println("ok");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }

                case 7 -> {
                    System.out.print("titulo: ");
                    String t = sc.nextLine();

                    try {
                        biblioteca.devolver(t);
                        System.out.println("ok");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }

                case 8 -> {
                    System.out.print("titulo: ");
                    String t = sc.nextLine();
                    System.out.println(biblioteca.remover(t) ? "removido" : "nao achou");
                }

                case 9 -> biblioteca.resumo();

                case 10 -> {
                    System.out.print("autor: ");
                    biblioteca.buscarPorAutor(sc.nextLine());
                }

                case 11 -> {
                    System.out.print("editora: ");
                    biblioteca.buscarPorEditora(sc.nextLine());
                }
            }

        } while (op != 0);

        sc.close();
    }

    private static int lerInt(Scanner sc, String msg) {

        while (true) {
            System.out.print(msg);

            try {
                return Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("valor invalido");
            }
        }
    }
}