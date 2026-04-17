class CalculadoraParametrizada {

    int somar(int a, int b) {
        return a + b;
    }

    int subtrair(int a, int b) {
        return a - b;
    }

    double multiplicar(double a, double b) {
        return a * b;
    }

    double dividir(double a, double b) {
        if (b == 0) {
            IO.println("Erro: divisão por zero!");
            return 0;
        }
        return a / b;
    }
}
