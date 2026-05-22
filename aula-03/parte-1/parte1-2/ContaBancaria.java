public class ContaBancaria {
    public String titular;
    public double saldo;

    public void depositar(double valor) {
        saldo = saldo + valor;
        IO.println("Depósito de R$" + valor + " realizado. Saldo atual: R$" + saldo);
    }

    public void sacar(double valor) {
        if (valor > saldo) {
            IO.println("Saldo insuficiente! Saldo atual: R$" + saldo);
        } else {
            saldo = saldo - valor;
            IO.println("Saque de R$" + valor + " realizado. Saldo atual: R$" + saldo);
        }
    }

    public void exibirSaldo() {
        IO.println("Titular: " + titular + " | Saldo: R$" + saldo);
    }
}
