void main() {
    var conta = new ContaBancaria("João", 500.0);

    IO.println("=== Conta criada ===");
    conta.exibirDados();

    IO.println("\n--- Depósito de R$ 200,00 ---");
    try {
        conta.depositar(200.0);
        IO.println("Depósito realizado com sucesso!");
    } catch (IllegalArgumentException e) {
        IO.println("Erro: " + e.getMessage());
    }
    conta.exibirDados();

    IO.println("\n--- Saque de R$ 900,00 (saldo insuficiente) ---");
    try {
        conta.sacar(900.0);
        IO.println("Saque realizado com sucesso!");
    } catch (IllegalArgumentException e) {
        IO.println("Erro: " + e.getMessage());
    }
    conta.exibirDados();

    IO.println("\n--- Saque com valor inválido: R$ -50,00 ---");
    try {
        conta.sacar(-50.0);
        IO.println("Saque realizado com sucesso!");
    } catch (IllegalArgumentException e) {
        IO.println("Erro: " + e.getMessage());
    }

    IO.println("\n=== Saldo final ===");
    conta.exibirDados();
}
