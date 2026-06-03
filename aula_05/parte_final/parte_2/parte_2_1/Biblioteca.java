package aula_05.parte_final.parte_2.parte_2_1;

import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Livro> livros = new ArrayList<>();

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public List<Livro> buscarPorAutor(String autor) {
        List<Livro> encontrados = new ArrayList<>();
        for (Livro livro : livros) {
            if (livro.getAutor().equalsIgnoreCase(autor)) {
                encontrados.add(livro);
            }
        }
        return encontrados;
    }

    public Livro livroMaisAntigo() {
        if (livros.isEmpty()) {
            return null;
        }
        Livro maisAntigo = livros.get(0);
        for (Livro livro : livros) {
            if (livro.getAnoPublicacao() < maisAntigo.getAnoPublicacao()) {
                maisAntigo = livro;
            }
        }
        return maisAntigo;
    }

    public void exibirTodos() {
        for (Livro livro : livros) {
            livro.exibirDados();
        }
    }
}
