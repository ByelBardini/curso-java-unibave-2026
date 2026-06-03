package aula_05.parte_final.parte_1.parte_1_2;

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
