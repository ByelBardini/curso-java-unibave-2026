public class Livro extends ItemBiblioteca {

    private String autor;
    private String isbn;
    private int anoPublicacao;

    public Livro(String titulo, String autor,
                 String isbn, int anoPublicacao) {

        super(titulo);

        this.autor = autor;
        this.isbn = isbn;
        this.anoPublicacao = anoPublicacao;
    }

    public String getAutor() {
        return autor;
    }

    @Override
    public String getTipo() {
        return "Livro";
    }
}