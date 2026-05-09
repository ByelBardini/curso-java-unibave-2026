public class MainExer3 {
    static void main() {
        Funcionario funcionario1 = new Funcionario("Alerrandro", 1000);
        Gerente gerente1 = new Gerente("Gabriel", 2000);
        Estagiario estagiario1 = new Estagiario("João", 3000);

        System.out.println(funcionario1.calcularSalario());
        System.out.println(gerente1.calcularSalario());
        System.out.println(estagiario1.calcularSalario());
    }
}
