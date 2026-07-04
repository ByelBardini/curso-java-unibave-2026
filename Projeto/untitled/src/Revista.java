public class Revista extends ItemBiblioteca {

    private String editora;
    private int numeroEdicao;
    private int anoEdicao;

    public Revista(String titulo,
                   String editora,
                   int numeroEdicao,
                   int anoEdicao) {

        super(titulo);

        this.editora = editora;
        this.numeroEdicao = numeroEdicao;
        this.anoEdicao = anoEdicao;
    }

    public String getEditora() {
        return editora;
    }

    @Override
    public String getTipo() {
        return "Revista";
    }
}