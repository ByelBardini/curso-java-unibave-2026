void main() {
    var funcionario = new Funcionario("João", 3000.00);
    var gerente = new Gerente("Maria", 3000.00);
    var estagiario = new Estagiario("Pedro", 3000.00);

    IO.println(funcionario.nome + " (Funcionário): R$ " + String.format("%.2f", funcionario.calcularSalario()));
    IO.println(gerente.nome + " (Gerente): R$ " + String.format("%.2f", gerente.calcularSalario()));
    IO.println(estagiario.nome + " (Estagiário): R$ " + String.format("%.2f", estagiario.calcularSalario()));
}
