public class Revista extends ItemBiblioteca {
    private String editora;
    private int numeroEdicao;
    private int ano;

    public Revista(String titulo, String editora, int numeroEdicao, int ano) {
        super(titulo);
        this.editora = editora;
        this.numeroEdicao = numeroEdicao;
        this.ano = ano;
    }

    public String getEditora() {
        return editora;
    }

    public int getNumeroEdicao() {
        return numeroEdicao;
    }

    public int getAno() {
        return ano;
    }

    @Override
    public String getTipo() {
        return "Revista";
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
