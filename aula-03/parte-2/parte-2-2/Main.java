public class Main {
    public static void main(String[] args) {
        Funcionario f1 = new Funcionario();
        f1.setNome("Ana");
        f1.setIdade(28);
        f1.setSalario(3000.00);

        Funcionario f2 = new Funcionario();
        f2.setNome("Carlos");
        f2.setIdade(45);
        f2.setSalario(5500.00);

        System.out.println("=== Funcionários cadastrados ===");
        f1.exibir();
        f2.exibir();

        System.out.println("\n=== Tentando valores inválidos ===");
        f1.setSalario(-500);      // bloqueado pelo setter
        f1.setIdade(10);          // bloqueado pelo setter
        f2.setNome("");           // bloqueado pelo setter

        System.out.println("\n=== Estado após tentativas inválidas ===");
        f1.exibir(); // permanece igual
        f2.exibir(); // permanece igual

        System.out.println("\n=== Aplicando aumentos ===");
        f1.aplicarAumento(10);
        f2.aplicarAumento(5);

        System.out.println("\n=== Estado final ===");
        f1.exibir();
        f2.exibir();
    }
}
