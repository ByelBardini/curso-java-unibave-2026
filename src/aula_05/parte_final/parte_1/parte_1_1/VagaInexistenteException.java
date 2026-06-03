package aula_05.parte_final.parte_1.parte_1_1;

public class VagaInexistenteException extends Exception {
    private int vaga;

    public VagaInexistenteException(int vaga) {
        super("A vaga " + vaga + " não existe no estacionamento.");
        this.vaga = vaga;
    }

    public int getVaga() {
        return vaga;
    }
}
