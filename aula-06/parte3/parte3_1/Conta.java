public class Conta {

    private String titular;
    private double saldo;

    public Conta(String titular, double saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    // Converte o objeto em UMA linha de texto: "titular;saldo"
    public String paraLinha() {
        return titular + ";" + saldo;
    }
}
