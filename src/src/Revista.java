public class Revista extends ItemBiblioteca {

    private String editora;
    private int numeroEdicao;

    public Revista(String titulo, String editora, int numeroEdicao, int ano) {
        super(titulo, ano);
        this.editora = editora;
        this.numeroEdicao = numeroEdicao;
    }

    public String getEditora() {
        return editora;
    }

    public int getNumeroEdicao() {
        return numeroEdicao;
    }

    @Override
    public String getTipo() {
        return "Revista";
    }

    @Override
    public String toString() {
        return "Tipo: Revista" +
                "\nTítulo: " + getTitulo() +
                "\nEditora: " + editora +
                "\nEdição: " + numeroEdicao +
                "\nAno: " + getAno() +
                "\nStatus: " + (isEmprestado() ? "Emprestado" : "Disponível") +
                (isEmprestado() ? "\nResponsável: " + getResponsavel() : "");
    }
}