void Main {

    // Recebe uma conta e um valor, chama o método depositar do objeto
    static void processarDeposito(ContaBancaria conta, double valor) {
        IO.println("Processando depósito para: " + conta.titular);
        conta.depositar(valor);
    }

    // Recebe duas contas e transfere valor de uma para outra
    static void transferir(ContaBancaria origem, ContaBancaria destino, double valor) {
        IO.println("\nTransferindo R$" + valor + " de " + origem.titular + " para " + destino.titular);
        origem.sacar(valor);
        destino.depositar(valor);
    }

    // Recebe um array de contas e exibe o saldo de todas
    static void exibirResumo(ContaBancaria[] contas) {
        IO.println("\n=== Resumo das contas ===");
        for (ContaBancaria c : contas) {
            c.exibirSaldo();
        }
    }

    public static void main(String[] args) {
        ContaBancaria contaAna = new ContaBancaria();
        contaAna.titular = "Ana";
        contaAna.saldo = 1000.0;

        ContaBancaria contaCarlos = new ContaBancaria();
        contaCarlos.titular = "Carlos";
        contaCarlos.saldo = 500.0;

        IO.println("=== Depósitos ===");
        processarDeposito(contaAna, 200.0);
        processarDeposito(contaCarlos, 300.0);

        IO.println("\n=== Saques ===");
        contaAna.sacar(100.0);
        contaCarlos.sacar(900.0); // saldo insuficiente

        transferir(contaAna, contaCarlos, 400.0);

        ContaBancaria[] todasAsContas = { contaAna, contaCarlos };
        exibirResumo(todasAsContas);
    }
}
