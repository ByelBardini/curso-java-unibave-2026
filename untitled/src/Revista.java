public class Revista extends Biblioteca {
    private String auditora;
    private int numeroEdicao;

    public Revista(String auditora, int numeroEdicao){
        super(auditora, numeroEdicao);
        this.auditora = auditora;
        this.numeroEdicao = numeroEdicao;
    }
}
