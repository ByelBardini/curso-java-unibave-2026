package src;

public class Revista extends ItemBiblioteca {

    private String editora;
    private int edicao;
    private int ano;

    public Revista(String titulo, String editora, int edicao, int ano) {
        super(titulo);
        this.editora = editora;
        this.edicao = edicao;
        this.ano = ano;
    }

    public String getEditora() {
        return editora;
    }

    public int getEdicao() {
        return edicao;
    }

    public int getAno() {
        return ano;
    }

    @Override
    public String salvar() {
        return "REVISTA;" + titulo + ";" + editora + ";" + edicao + ";" + ano + ";" + emprestado + ";" + responsavel;
    }

    @Override
    public String toString() {
        return "Revista\n" +
                "Título: " + titulo +
                "\nEditora: " + editora +
                "\nEdição: " + edicao +
                "\nAno: " + ano +
                "\nStatus: " + (emprestado ? "Emprestado para " + responsavel : "Disponível");
    }
}