import java.util.ArrayList;

public class Biblioteca implements Emprestimo {
    private String titulo;
    private int anoEdicaoPublicacao;

    public Biblioteca (String titulo, int anoEdicaoPublicacao){
        this.titulo = titulo;
        this.anoEdicaoPublicacao = anoEdicaoPublicacao;
    }

    ArrayList<Livro> livro = new ArrayList<>();
    ArrayList<Revista> revistas = new ArrayList<>();


}
