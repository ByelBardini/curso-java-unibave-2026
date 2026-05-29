void main() {
    var banco = new Banco("Banco Unibave");

    IO.println("=== Abrindo contas ===");
    banco.abrirConta1("001", "Alice", 1000.0);
    banco.abrirConta2("002", "Bob", 500.0);
    banco.abrirConta3("003", "Carlos", -100.0); // saldo inicial inválido

    banco.exibirContas();

    IO.println("\n=== Realizando transferências ===");

    banco.transferir("001", "002", 300.0);   // sucesso

    banco.transferir("002", "001", 1000.0);  // saldo insuficiente

    banco.transferir("001", "002", -50.0);   // valor inválido

    banco.exibirContas();
}
