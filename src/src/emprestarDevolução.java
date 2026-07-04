package src.src;

public interface emprestarDevolução {

    void emprestar (String responsavel) throws Exception;

    void devolver () throws Exception;

    boolean estaDisponivel();

}