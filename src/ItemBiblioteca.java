package src;

public abstract class ItemBiblioteca implements Emprestavel {

    protected String titulo;
    protected boolean emprestado;
    protected String responsavel;

    public ItemBiblioteca(String titulo) {
        this.titulo = titulo;
        this.emprestado = false;
        this.responsavel = "";
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean isEmprestado() {
        return emprestado;
    }

    public String getResponsavel() {
        return responsavel;
    }

    @Override
    public void emprestar(String pessoa) {
        emprestado = true;
        responsavel = pessoa;
    }

    @Override
    public void devolver() {
        emprestado = false;
        responsavel = "";
    }

    public abstract String salvar();

    @Override
    public abstract String toString();
}