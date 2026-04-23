public class Funcionario {
    private String nome;
    private double salario;
    private int idade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            System.out.println("Erro: nome não pode ser vazio.");
            return;
        }
        this.nome = nome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        if (salario < 0) {
            System.out.println("Erro: salário não pode ser negativo.");
            return;
        }
        this.salario = salario;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        if (idade < 16 || idade > 100) {
            System.out.println("Erro: idade inválida (" + idade + ").");
            return;
        }
        this.idade = idade;
    }

    public void aplicarAumento(double percentual) {
        if (percentual <= 0) {
            System.out.println("Percentual de aumento deve ser positivo.");
            return;
        }
        salario = salario + (salario * percentual / 100);
        System.out.println(nome + " recebeu aumento de " + percentual + "%. Novo salário: R$" + salario);
    }

    public void exibir() {
        System.out.println("Funcionário: " + nome + " | Idade: " + idade + " | Salário: R$" + salario);
    }
}
