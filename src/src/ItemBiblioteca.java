public abstract class ItemBiblioteca implements Emprestavel {

    private String titulo;
    private int ano;
    private boolean emprestado;
    private String responsavel;
    private int totalEmprestimos;
    public ItemBiblioteca(String titulo, int ano) {
        this.titulo = titulo;
        this.ano = ano;
        this.emprestado = false;
        this.responsavel = null;
        this.totalEmprestimos = 0;
    }
    public String getTitulo() {
        return titulo;
    }
    public int getAno() {
        return ano;
    }
    public boolean isEmprestado() {
        return emprestado;
    }
    public String getResponsavel() {
        return responsavel;
    }
    public int getTotalEmprestimos() {
        return totalEmprestimos;
    }
    protected void setEmprestado(boolean emprestado) {
        this.emprestado = emprestado;
    }
    protected void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }
    protected void setTotalEmprestimos(int totalEmprestimos) {
        this.totalEmprestimos = totalEmprestimos;
    }
    @Override
    public void emprestar(String responsavel)
            throws ItemIndisponivelException {

        if (isEmprestado()) {
            throw new ItemIndisponivelException(
                    "Este item já está emprestado."
            );
        }

        emprestado = true;
        this.responsavel = responsavel;
        totalEmprestimos++;
    }
    @Override
    public void devolver() throws ItemIndisponivelException {

        if (!isEmprestado()) {
            throw new ItemIndisponivelException("Este item não está emprestado.");
        }

        emprestado = false;
        responsavel = null;
    }
    public abstract String getTipo();

}