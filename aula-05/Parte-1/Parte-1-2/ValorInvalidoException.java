public class ValorInvalidoException extends Exception {
    private String operacao;
    private double valor;

    public ValorInvalidoException(String operacao, double valor) {
        super("Valor inválido para " + operacao + ": R$ " + valor);
        this.operacao = operacao;
        this.valor = valor;
    }

    public String getOperacao() {
        return operacao;
    }

    public double getValor() {
        return valor;
    }
}
