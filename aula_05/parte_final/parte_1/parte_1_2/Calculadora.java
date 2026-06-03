package aula_05.parte_final.parte_1.parte_1_2;

public class Calculadora {

    public double dividir(double a, double b) throws DivisaoPorZeroException {
        if (b == 0) {
            throw new DivisaoPorZeroException(a);
        }
        return a / b;
    }

    public double raizQuadrada(double n) throws ValorNegativoException {
        if (n < 0) {
            throw new ValorNegativoException(n);
        }
        return Math.sqrt(n);
    }

    public double calcular(String operacao, double a, double b) throws DivisaoPorZeroException {
        return switch (operacao) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> dividir(a, b);
            default -> throw new IllegalArgumentException("Operação inválida: " + operacao);
        };
    }
}
