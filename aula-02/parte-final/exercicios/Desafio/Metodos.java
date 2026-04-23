void main() {
    exibirRelatorio("Ana", calcularIMC(58, 1.65), classificarIMC(calcularIMC(58, 1.65)));
    exibirRelatorio("Carlos", calcularIMC(95, 1.75), classificarIMC(calcularIMC(95, 1.75)));
    exibirRelatorio("Beatriz", calcularIMC(40, 1.60), classificarIMC(calcularIMC(40, 1.60)));
}

double calcularIMC(double peso, double altura) {
    return peso / (altura * altura);
}

String classificarIMC(double imc) {
    if (imc < 18.5) return "Abaixo do peso";
    if (imc < 25.0) return "Peso normal";
    if (imc < 30.0) return "Sobrepeso";
    return "Obesidade";
}

void exibirRelatorio(String nome, double imc, String classificacao) {
    IO.println("========================================");
    IO.println("Nome: " + nome);
    IO.println("IMC: " + String.format("%.2f", imc));
    IO.println("Classificação: " + classificacao);
}
