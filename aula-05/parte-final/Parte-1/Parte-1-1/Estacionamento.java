public class Estacionamento {
    private String[] vagas;

    public Estacionamento(int totalVagas) {
        this.vagas = new String[totalVagas];
    }

    public void estacionar(String placa, int vaga) throws VagaInexistenteException, VagaOcupadaException {
        int indice = vaga - 1;
        if (indice < 0 || indice >= vagas.length) {
            throw new VagaInexistenteException(vaga);
        }
        if (vagas[indice] != null) {
            throw new VagaOcupadaException(vaga, vagas[indice]);
        }
        vagas[indice] = placa;
    }

    public void liberar(int vaga) throws VagaInexistenteException {
        int indice = vaga - 1;
        if (indice < 0 || indice >= vagas.length) {
            throw new VagaInexistenteException(vaga);
        }
        vagas[indice] = null;
    }

    public void exibirStatus() {
        IO.println("=== Status do estacionamento ===");
        for (int i = 0; i < vagas.length; i++) {
            int numero = i + 1;
            if (vagas[i] == null) {
                IO.println("Vaga " + numero + ": livre");
            } else {
                IO.println("Vaga " + numero + ": " + vagas[i]);
            }
        }
    }
}
