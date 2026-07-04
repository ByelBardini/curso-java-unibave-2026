public class Livro extends ItemBiblioteca {
    private String autor;
    private String isbn;
    private int ano;

    public Livro(String titulo, String autor, String isbn, int ano) {
        super(titulo);
        this.autor = autor;
        this.isbn = isbn;
        this.ano = ano;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getAno() {
        return ano;
    }

    @Override
    public String getTipo() {
        return "Livro";
    }

    @Override
    public String toString() {
        return getTipo()
                + " | "
                + getTitulo()
                + " | "
                + getStatus();
    }
}
