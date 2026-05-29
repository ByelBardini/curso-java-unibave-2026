public class ContaBancaria {
    private String numero;
    private String titular;
    private double saldo;

    public ContaBancaria(String numero, String titular, double saldoInicial) throws ValorInvalidoException {
        if (saldoInicial < 0) {
            throw new ValorInvalidoException("saldo inicial", saldoInicial);
        }
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldoInicial;
    }

    public void depositar(double valor) throws ValorInvalidoException {
        if (valor <= 0) {
            throw new ValorInvalidoException("depósito", valor);
        }
        saldo += valor;
    }

    public void sacar(double valor) throws ValorInvalidoException, SaldoInsuficienteException {
        if (valor <= 0) {
            throw new ValorInvalidoException("saque", valor);
        }
        if (valor > saldo) {
            throw new SaldoInsuficienteException(saldo, valor);
        }
        saldo -= valor;
    }

    public String getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void exibirDados() {
        IO.println("Conta: " + numero + " | Titular: " + titular + " | Saldo: R$ " + saldo);
    }
}
