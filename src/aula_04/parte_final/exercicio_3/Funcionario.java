package aula_04.parte_final.exercicio_3;

public class Funcionario {
    public String nome;
    public double salarioBase;

    public Funcionario(String nome, double salarioBase) {
        this.nome = nome;
        this.salarioBase = salarioBase;
    }

    public double calcularSalario() {
        return salarioBase;
    }
}
