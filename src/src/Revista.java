package src.src;

public class Revista extends livrosDisponiveis {

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

    public int getNumeroEdicao() {
        return numeroEdicao;
    }

    public int getAnoEdicao() {
        return anoEdicao;
    }

    @Override
    public String getTipo() {
        return "Revista";
    }

    @Override
    public String toString() {

        return super.toString()
                + "\nEditora: " + editora
                + "\nEdição: " + numeroEdicao
                + "\nAno: " + anoEdicao;
    }
}