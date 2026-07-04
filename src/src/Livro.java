public class Livro extends ItemBiblioteca {

    private String autor;
    private String isbn;

    public Livro(String titulo, String autor, String isbn, int ano) {
        super(titulo, ano);
        this.autor = autor;
        this.isbn = isbn;
    }

    public String getAutor() { return autor; }
    public String getIsbn() { return isbn; }

    @Override
    public String getTipo() {
        return "Livro";
    }

    @Override
    public String toString() {
        return "Livro: " + getTitulo() +
                " | autor: " + autor +
                " | ano: " + getAno() +
                " | status: " + (isEmprestado() ? "emprestado" : "livre") +
                " | emprestimos: " + getTotalEmprestimos();
    }
}