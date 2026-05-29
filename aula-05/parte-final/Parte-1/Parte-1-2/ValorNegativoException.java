public class ValorNegativoException extends Exception {
    private double valor;

    public ValorNegativoException(double valor) {
        super("Operação não permitida para valor negativo: " + valor);
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }
}
