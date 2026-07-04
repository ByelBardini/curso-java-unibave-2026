package src.src;

class Livro extends livrosDisponiveis {

    private String autor;
    private String isbn;
    private int anoPublicacao;

    public Livro(String titulo,
                 String autor,
                 String isbn,
                 int anoPublicacao) {

        super(titulo);

        this.autor = autor;
        this.isbn = isbn;
        this.anoPublicacao = anoPublicacao;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    @Override
    public String getTipo() {
        return "Livro";
    }

    @Override
    public String toString() {

        return super.toString()
                + "\nAutor: " + autor
                + "\nISBN: " + isbn
                + "\nAno: " + anoPublicacao;
    }

}