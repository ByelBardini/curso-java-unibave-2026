package simulado.src;

public  class Pessoa {
    private String nome;
    private int matricula;

    public Pessoa(String nome, int matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }
    public String getNome() {
        return nome;
    }

    public int getMatricula() {
        return matricula;
    }
}
