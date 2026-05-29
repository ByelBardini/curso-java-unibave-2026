public class Banco {
    private String nome;
    private ContaBancaria conta1;
    private ContaBancaria conta2;
    private ContaBancaria conta3;

    public Banco(String nome) {
        this.nome = nome;
    }

    public void abrirConta1(String numero, String titular, double saldoInicial) {
        try {
            conta1 = new ContaBancaria(numero, titular, saldoInicial);
            IO.println("Conta " + numero + " aberta para " + titular + " com R$ " + saldoInicial);
        } catch (ValorInvalidoException e) {
            IO.println("Erro ao abrir conta de " + titular + ": " + e.getMessage());
        }
    }

    public void abrirConta2(String numero, String titular, double saldoInicial) {
        try {
            conta2 = new ContaBancaria(numero, titular, saldoInicial);
            IO.println("Conta " + numero + " aberta para " + titular + " com R$ " + saldoInicial);
        } catch (ValorInvalidoException e) {
            IO.println("Erro ao abrir conta de " + titular + ": " + e.getMessage());
        }
    }

    public void abrirConta3(String numero, String titular, double saldoInicial) {
        try {
            conta3 = new ContaBancaria(numero, titular, saldoInicial);
            IO.println("Conta " + numero + " aberta para " + titular + " com R$ " + saldoInicial);
        } catch (ValorInvalidoException e) {
            IO.println("Erro ao abrir conta de " + titular + ": " + e.getMessage());
        }
    }

    public void transferir(String numeroOrigem, String numeroDestino, double valor) {
        IO.println("\nTransferência: " + numeroOrigem + " → " + numeroDestino + " | R$ " + valor);

        ContaBancaria origem = null;
        ContaBancaria destino = null;

        if (conta1 != null && conta1.getNumero().equals(numeroOrigem)) origem = conta1;
        else if (conta2 != null && conta2.getNumero().equals(numeroOrigem)) origem = conta2;
        else if (conta3 != null && conta3.getNumero().equals(numeroOrigem)) origem = conta3;

        if (conta1 != null && conta1.getNumero().equals(numeroDestino)) destino = conta1;
        else if (conta2 != null && conta2.getNumero().equals(numeroDestino)) destino = conta2;
        else if (conta3 != null && conta3.getNumero().equals(numeroDestino)) destino = conta3;

        if (origem == null || destino == null) {
            IO.println("Erro: conta não encontrada.");
            return;
        }

        try {
            origem.sacar(valor);
            destino.depositar(valor);
            IO.println("Transferência realizada com sucesso!");
        } catch (SaldoInsuficienteException e) {
            IO.println("Falha: " + e.getMessage());
            IO.println("Faltam R$ " + e.getDiferenca() + " para completar a operação.");
        } catch (ValorInvalidoException e) {
            IO.println("Falha: " + e.getMessage());
        } finally {
            IO.println("Saldos após a operação:");
            if (origem != null) origem.exibirDados();
            if (destino != null) destino.exibirDados();
        }
    }

    public void exibirContas() {
        IO.println("\n=== " + nome + " — Contas ===");
        if (conta1 != null) conta1.exibirDados();
        if (conta2 != null) conta2.exibirDados();
        if (conta3 != null) conta3.exibirDados();
    }
}
