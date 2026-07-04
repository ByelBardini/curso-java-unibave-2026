public class Revista extends ItemBiblioteca {

    private String editora;
    private int numeroEdicao;

    public Revista(String titulo, String editora, int numeroEdicao, int ano) {
        super(titulo, ano);
        this.editora = editora;
        this.numeroEdicao = numeroEdicao;
    }

    public String getEditora() { return editora; }
    public int getNumeroEdicao() { return numeroEdicao; }

    @Override
    public String getTipo() {
        return "Revista";
    }

    @Override
    public String toString() {
        return "Revista: " + getTitulo() +
                " | editora: " + editora +
                " | edicao: " + numeroEdicao +
                " | ano: " + getAno() +
                " | status: " + (isEmprestado() ? "emprestado" : "livre") +
                " | emprestimos: " + getTotalEmprestimos();
    }
}