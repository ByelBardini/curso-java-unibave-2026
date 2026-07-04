import java.io.Serializable;

public abstract class ItemBiblioteca implements Emprestavel, Serializable {
    private String titulo;
    private boolean emprestado;
    private String responsavel;
    private int vezesEmprestado;

    public ItemBiblioteca(String titulo) {
    }

    public void itemBiblioteca(String titulo) {
        this.titulo = titulo;
        this.emprestado = false;
        this.responsavel = "";
        this.vezesEmprestado = 0;
    }

    public String getTitulo() {
        return titulo;
    }

    public boolean estaEmprestado() {
        return emprestado;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public int getVezesEmprestado() {
        return vezesEmprestado;
    }

    @Override
    public void emprestar(String pessoa) {
        emprestado = true;
        responsavel = pessoa;
        vezesEmprestado++;
    }

    @Override
    public void devolver() {
    emprestado = false;
    responsavel = "";
    }

    public String getStatus() {
        return emprestado ? "Emprestado" : "Disponível";
    }

    public abstract String getTipo();
}
