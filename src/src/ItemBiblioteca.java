public abstract class ItemBiblioteca implements Emprestavel {

    private String titulo;
    private int ano;
    private boolean emprestado;
    private String responsavel;
    private int totalEmprestimos;

    public ItemBiblioteca(String titulo, int ano) {
        this.titulo = titulo;
        this.ano = ano;
    }

    public String getTitulo() { return titulo; }
    public int getAno() { return ano; }
    public boolean isEmprestado() { return emprestado; }
    public String getResponsavel() { return responsavel; }
    public int getTotalEmprestimos() { return totalEmprestimos; }

    public void setTotalEmprestimos(int totalEmprestimos) {
        this.totalEmprestimos = totalEmprestimos;
    }

    @Override
    public void emprestar(String responsavel) throws ItemIndisponivelException {

        if (emprestado) {
            throw new ItemIndisponivelException("ja emprestado");
        }

        this.emprestado = true;
        this.responsavel = responsavel;
        this.totalEmprestimos++;
    }

    @Override
    public void devolver() throws ItemIndisponivelException {

        if (!emprestado) {
            throw new ItemIndisponivelException("nao esta emprestado");
        }

        this.emprestado = false;
        this.responsavel = null;
    }

    public abstract String getTipo();
}