public class ContaBancaria {
    public String titular;
    public double saldo;

    public void depositar(double valor) {
        saldo = saldo + valor;
        System.out.println("Depósito de R$" + valor + " realizado. Saldo atual: R$" + saldo);
    }

    public void sacar(double valor) {
        if (valor > saldo) {
            System.out.println("Saldo insuficiente! Saldo atual: R$" + saldo);
        } else {
            saldo = saldo - valor;
            System.out.println("Saque de R$" + valor + " realizado. Saldo atual: R$" + saldo);
        }
    }

    public void exibirSaldo() {
        System.out.println("Titular: " + titular + " | Saldo: R$" + saldo);
    }
}
