public class Livro extends ItemBiblioteca {

    private String autor;
    private String isbn;

    public Livro(String titulo, String autor, String isbn, int ano) {
        super(titulo, ano);
        this.autor = autor;
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

    @Override
    public String getTipo() {
        return "Livro";
    }

    @Override
    public String toString() {
        return "Tipo: Livro" +
                "\nTítulo: " + getTitulo() +
                "\nAutor: " + autor +
                "\nISBN: " + isbn +
                "\nAno: " + getAno() +
                "\nStatus: " + (isEmprestado() ? "Emprestado" : "Disponível") +
                (isEmprestado() ? "\nResponsável: " + getResponsavel() : "");
    }
}