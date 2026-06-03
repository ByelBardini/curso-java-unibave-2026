package aula_05.parte_final.parte_1.parte_1_2;

public class Main {

    void main() {
        var calc = new Calculadora();

        IO.println("=== Divisão normal ===");
        try {
            double resultado = calc.dividir(10.0, 2.0);
            IO.println("10 / 2 = " + resultado);
        } catch (DivisaoPorZeroException e) {
            IO.println("Erro: " + e.getMessage());
        }

        IO.println("\n=== Divisão por zero ===");
        try {
            double resultado = calc.dividir(7.0, 0.0);
            IO.println("7 / 0 = " + resultado);
        } catch (DivisaoPorZeroException e) {
            IO.println("Falha: " + e.getMessage());
            IO.println("Dividendo informado: " + e.getDividendo());
        }

        IO.println("\n=== Raiz quadrada de número positivo ===");
        try {
            double resultado = calc.raizQuadrada(81.0);
            IO.println("√81 = " + resultado);
        } catch (ValorNegativoException e) {
            IO.println("Erro: " + e.getMessage());
        }

        IO.println("\n=== Raiz quadrada de número negativo ===");
        try {
            double resultado = calc.raizQuadrada(-25.0);
            IO.println("√-25 = " + resultado);
        } catch (ValorNegativoException e) {
            IO.println("Falha: " + e.getMessage());
            IO.println("Valor inválido: " + e.getValor());
        }

        IO.println("\n=== Método calcular com cada operação ===");
        try {
            IO.println("5 + 3 = " + calc.calcular("+", 5, 3));
            IO.println("10 - 4 = " + calc.calcular("-", 10, 4));
            IO.println("6 * 7 = " + calc.calcular("*", 6, 7));
            IO.println("20 / 4 = " + calc.calcular("/", 20, 4));
            IO.println("8 / 0 = " + calc.calcular("/", 8, 0));
        } catch (DivisaoPorZeroException e) {
            IO.println("Falha no calcular: " + e.getMessage());
        }
    }
}