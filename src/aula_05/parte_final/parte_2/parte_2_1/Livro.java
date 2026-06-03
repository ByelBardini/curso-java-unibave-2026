package aula_05.parte_final.parte_2.parte_2_1;

public class Livro {
    private String titulo;
    private String autor;
    private int anoPublicacao;

    public Livro(String titulo, String autor, int anoPublicacao) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void exibirDados() {
        IO.println("Título: " + titulo + " | Autor: " + autor + " | Ano: " + anoPublicacao);
    }
}
