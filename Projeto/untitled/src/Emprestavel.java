public interface Emprestavel {

    void emprestar(String responsavel) throws Exception;

    void devolver();

    boolean estaEmprestado();
}