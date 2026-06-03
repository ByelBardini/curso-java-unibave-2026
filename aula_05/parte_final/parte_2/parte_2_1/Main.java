package aula_05.parte_final.parte_2.parte_2_1;

import java.util.List;

public class Main {

    void main() {
        var biblioteca = new Biblioteca();

        biblioteca.adicionarLivro(new Livro("Dom Casmurro", "Machado de Assis", 1899));
        biblioteca.adicionarLivro(new Livro("Memórias Póstumas de Brás Cubas", "Machado de Assis", 1881));
        biblioteca.adicionarLivro(new Livro("O Cortiço", "Aluísio Azevedo", 1890));
        biblioteca.adicionarLivro(new Livro("Vidas Secas", "Graciliano Ramos", 1938));
        biblioteca.adicionarLivro(new Livro("Capitães da Areia", "Jorge Amado", 1937));

        IO.println("=== Todos os livros ===");
        biblioteca.exibirTodos();

        IO.println("\n=== Livros de Machado de Assis ===");
        List<Livro> machado = biblioteca.buscarPorAutor("machado de assis");
        if (machado.isEmpty()) {
            IO.println("Nenhum livro encontrado para esse autor.");
        } else {
            for (Livro livro : machado) {
                livro.exibirDados();
            }
        }

        IO.println("\n=== Livro mais antigo ===");
        Livro maisAntigo = biblioteca.livroMaisAntigo();
        if (maisAntigo == null) {
            IO.println("A biblioteca está vazia.");
        } else {
            maisAntigo.exibirDados();
        }
    }
}