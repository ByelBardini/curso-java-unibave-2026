import java.io.*;
import java.util.ArrayList;

public class Biblioteca {

    private ArrayList<ItemBiblioteca> itens;
    private static final String ARQUIVO = "biblioteca.dat";

    public Biblioteca() {

        carregarArquivo();

        if (itens.isEmpty()) {
            carregarItensPadrao();
            salvarArquivo();
        }
    }

    private void carregarItensPadrao() {

        itens.add(new Livro("Dom Casmurro",
                "Machado de Assis",
                "111", 1899));

        itens.add(new Livro("O Cortiço",
                "Aluísio Azevedo",
                "222", 1890));

        itens.add(new Livro("Capitães da Areia",
                "Jorge Amado",
                "333", 1937));

        itens.add(new Livro("Memórias Póstumas",
                "Machado de Assis",
                "444", 1881));

        itens.add(new Livro("1984",
                "George Orwell",
                "555", 1949));

        itens.add(new Livro("Harry Potter",
                "J.K Rowling",
                "666", 1997));

        itens.add(new Livro("O Hobbit",
                "Tolkien",
                "777", 1937));
    }

    public void cadastrarLivro(String titulo,
                               String autor,
                               String isbn,
                               int anoPublicacao) {

        itens.add(new Livro(
                titulo,
                autor,
                isbn,
                anoPublicacao));

        salvarArquivo();
    }

    public void cadastrarRevista(String titulo,
                                 String editora,
                                 int numeroEdicao,
                                 int anoEdicao) {

        itens.add(new Revista(
                titulo,
                editora,
                numeroEdicao,
                anoEdicao));

        salvarArquivo();
    }

    public void listarItens() {

        for (ItemBiblioteca item : itens) {
            System.out.println(item);
        }
    }

    public void emprestar(String titulo, String pessoa)
            throws BibliotecaException {

        ItemBiblioteca item = buscar(titulo);

        if (item.estaEmprestado()) {
            throw new ItemIndisponivelException(
                    "Item já emprestado.");
        }

        int quantidade = 0;

        for (ItemBiblioteca i : itens) {

            if (i.estaEmprestado() &&
                    i.getResponsavel().equalsIgnoreCase(pessoa)) {

                quantidade++;
            }
        }

        if (quantidade >= 2) {

            throw new LimiteEmprestimosException(
                    "Limite de 2 empréstimos atingido.");
        }

        item.emprestar(pessoa);

        salvarArquivo();
    }

    public void devolver(String titulo)
            throws ItemNaoEncontradoException {

        ItemBiblioteca item = buscar(titulo);

        item.devolver();

        salvarArquivo();
    }

    public void remover(String titulo)
            throws ItemNaoEncontradoException {

        ItemBiblioteca item = buscar(titulo);

        itens.remove(item);

        salvarArquivo();
    }

    private ItemBiblioteca buscar(String titulo)
            throws ItemNaoEncontradoException {

        for (ItemBiblioteca item : itens) {

            if (item.getTitulo().equalsIgnoreCase(titulo)) {
                return item;
            }
        }

        throw new ItemNaoEncontradoException(
                "Item não encontrado.");
    }

    public void resumo() {

        int emprestados = 0;
        int livros = 0;
        int revistas = 0;

        for (ItemBiblioteca item : itens) {

            if (item.estaEmprestado()) {
                emprestados++;
            }

            if (item instanceof Livro) {
                livros++;
            }

            if (item instanceof Revista) {
                revistas++;
            }
        }

        System.out.println("\n=== RESUMO ===");
        System.out.println("Total de itens: " + itens.size());
        System.out.println("Disponíveis: " + (itens.size() - emprestados));
        System.out.println("Emprestados: " + emprestados);
        System.out.println("Livros: " + livros);
        System.out.println("Revistas: " + revistas);
    }

    @SuppressWarnings("unchecked")
    private void carregarArquivo() {

        try {

            ObjectInputStream in =
                    new ObjectInputStream(
                            new FileInputStream(ARQUIVO));

            itens = (ArrayList<ItemBiblioteca>) in.readObject();

            in.close();

        } catch (Exception e) {

            itens = new ArrayList<>();
        }
    }

    private void salvarArquivo() {

        try {

            ObjectOutputStream out =
                    new ObjectOutputStream(
                            new FileOutputStream(ARQUIVO));

            out.writeObject(itens);

            out.close();

        } catch (IOException e) {

            System.out.println("Erro ao salvar arquivo.");
        }
    }
}