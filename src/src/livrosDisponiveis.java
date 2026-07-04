package src.src;

import java.io.Serializable;

public abstract class livrosDisponiveis implements emprestarDevolução, Serializable {

    private String titulo;
    private String responsavel;
    private boolean emprestado;

    public livrosDisponiveis(String titulo) {
        this.titulo = titulo;
        this.responsavel = "";
        this.emprestado = false;
    }

    protected livrosDisponiveis() {
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public boolean getEmprestado() {
        return emprestado;
    }

    // Compatibilidade com Biblioteca.java
    public boolean isEmprestado() {
        return emprestado;
    }

    // Compatibilidade com Biblioteca.java
    public boolean estaDisponivel() {
        return !emprestado;
    }

    @Override
    public void emprestar(String responsavel) throws Exception {

        if (emprestado) {
            throw new Exception("Item já está emprestado.");
        }

        this.emprestado = true;
        this.responsavel = responsavel;
    }

    @Override
    public void devolver() throws Exception {

        if (!emprestado) {
            throw new Exception("Este item não está emprestado.");
        }

        emprestado = false;
        responsavel = "";
    }

    public abstract String getTipo();

    @Override
    public String toString() {

        String situacao;

        if (emprestado) {
            situacao = "Emprestado para: " + responsavel;
        } else {
            situacao = "Disponível";
        }

        return "Tipo: " + getTipo()
                + "\nTítulo: " + titulo
                + "\nSituação: " + situacao;
    }
}