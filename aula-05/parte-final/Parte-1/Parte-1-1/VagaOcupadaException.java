public class VagaOcupadaException extends Exception {
    private int vaga;
    private String placaAtual;

    public VagaOcupadaException(int vaga, String placaAtual) {
        super("A vaga " + vaga + " já está ocupada pelo carro de placa " + placaAtual + ".");
        this.vaga = vaga;
        this.placaAtual = placaAtual;
    }

    public int getVaga() {
        return vaga;
    }

    public String getPlacaAtual() {
        return placaAtual;
    }
}
