public class Livro extends Biblioteca {
    private String autor;
    private double ISBN;

    public Livro(String titulo, int anoEdicaoPublicacao, String autor, double ISBN){
        super(titulo, anoEdicaoPublicacao);
        this.autor = autor;
        this.ISBN = ISBN;
    }
}
