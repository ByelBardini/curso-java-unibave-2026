void main() {
    var estacionamento = new Estacionamento(5);

    IO.println("--- Estacionando dois carros em vagas válidas ---");
    try {
        estacionamento.estacionar("ABC-1234", 1);
        IO.println("Carro ABC-1234 estacionado na vaga 1.");
        estacionamento.estacionar("DEF-5678", 3);
        IO.println("Carro DEF-5678 estacionado na vaga 3.");
    } catch (VagaInexistenteException | VagaOcupadaException e) {
        IO.println("Erro: " + e.getMessage());
    }

    estacionamento.exibirStatus();

    IO.println("\n--- Tentando estacionar em uma vaga já ocupada ---");
    try {
        estacionamento.estacionar("GHI-9012", 1);
    } catch (VagaOcupadaException e) {
        IO.println("Falha: " + e.getMessage());
        IO.println("Vaga: " + e.getVaga() + " | Placa já estacionada: " + e.getPlacaAtual());
    } catch (VagaInexistenteException e) {
        IO.println("Falha: " + e.getMessage());
    }

    IO.println("\n--- Tentando estacionar em uma vaga inexistente ---");
    try {
        estacionamento.estacionar("JKL-3456", 10);
    } catch (VagaInexistenteException e) {
        IO.println("Falha: " + e.getMessage());
        IO.println("Vaga tentada: " + e.getVaga());
    } catch (VagaOcupadaException e) {
        IO.println("Falha: " + e.getMessage());
    }

    IO.println("\n--- Liberando a vaga 1 e estacionando outro carro ---");
    try {
        estacionamento.liberar(1);
        IO.println("Vaga 1 liberada.");
        estacionamento.estacionar("MNO-7890", 1);
        IO.println("Carro MNO-7890 estacionado na vaga 1.");
    } catch (VagaInexistenteException | VagaOcupadaException e) {
        IO.println("Erro: " + e.getMessage());
    }

    IO.println();
    estacionamento.exibirStatus();
}
