public class ContaCorrente {
    private String titular;
    private double saldo;

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            IO.println("Erro: valor de depósito deve ser positivo.");
            return;
        }
        saldo = saldo + valor;
        IO.println("Depósito de R$" + valor + " realizado. Saldo: R$" + saldo);
    }

    public void sacar(double valor) {
        if (valor > saldo) {
            IO.println("Erro: saldo insuficiente. Saldo disponível: R$" + saldo);
            return;
        }
        saldo = saldo - valor;
        IO.println("Saque de R$" + valor + " realizado. Saldo: R$" + saldo);
    }
}
