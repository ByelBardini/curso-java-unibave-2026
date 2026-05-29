public class SaldoInsuficienteException extends Exception {
    private double saldoAtual;
    private double valorSolicitado;

    public SaldoInsuficienteException(double saldoAtual, double valorSolicitado) {
        super("Saldo insuficiente. Disponível: R$ " + saldoAtual + " | Solicitado: R$ " + valorSolicitado);
        this.saldoAtual = saldoAtual;
        this.valorSolicitado = valorSolicitado;
    }

    public double getSaldoAtual() {
        return saldoAtual;
    }

    public double getValorSolicitado() {
        return valorSolicitado;
    }

    public double getDiferenca() {
        return valorSolicitado - saldoAtual;
    }
}
