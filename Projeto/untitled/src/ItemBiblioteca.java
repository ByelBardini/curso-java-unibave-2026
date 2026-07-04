public abstract class ItemBiblioteca
        implements Emprestavel {

    private String titulo;
    private boolean emprestado;
    private String responsavel;
    private int totalEmprestimos;

    public ItemBiblioteca(String titulo) {
        this.titulo = titulo;
        this.emprestado = false;
        this.responsavel = "";
        this.totalEmprestimos = 0;
    }

    public abstract String getTipo();

    @Override
    public void emprestar(String responsavel)
            throws ItemIndisponivelException {

        // IMPLEMENTAR
    }

    @Override
    public void devolver() {

        // IMPLEMENTAR
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResponsavel() {
        return responsavel;
    }

    @Override
    public boolean isEmprestado() {
        return emprestado;
    }

    public int getTotalEmprestimos() {
        return totalEmprestimos;
    }

    // getters e setters necessários
}