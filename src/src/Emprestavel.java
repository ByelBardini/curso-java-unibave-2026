public interface Emprestavel {
    void emprestar(String responsavel) throws ItemIndisponivelException;
    void devolver() throws ItemIndisponivelException;
}