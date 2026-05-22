void main() {
    ContaCorrente conta = new ContaCorrente();
    conta.setTitular("Carlos");

    IO.println("=== Depósitos ===");
    conta.depositar(1000.0);
    conta.depositar(500.0);
    conta.depositar(-100.0); // bloqueado

    IO.println("\n=== Saques ===");
    conta.sacar(200.0);
    conta.sacar(2000.0); // bloqueado — saldo insuficiente

    IO.println("\nSaldo final de " + conta.getTitular() + ": R$" + conta.getSaldo());
}
