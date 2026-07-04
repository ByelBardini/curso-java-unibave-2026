public interface Emprestavel {
    void emprestar(String pessoa);
    void devolver();
    boolean estaEmprestado();
}
