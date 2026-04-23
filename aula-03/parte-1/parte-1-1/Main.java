public class Main {

    // Recebe um objeto Pessoa como parâmetro
    static void apresentarPessoa(Pessoa p) {
        System.out.println("Nome: " + p.nome + ", Idade: " + p.idade + ", Cidade: " + p.cidade);
    }

    // Objetos são passados por referência — alterações refletem fora do método
    static void fazerAniversario(Pessoa p) {
        p.idade = p.idade + 1;
        System.out.println(p.nome + " fez aniversário! Nova idade: " + p.idade);
    }

    // Primitivos são passados por valor — alteração NÃO reflete fora do método
    static void tentarDobrarIdade(int idade) {
        idade = idade * 2;
        System.out.println("Dentro do método, idade dobrada: " + idade);
    }

    public static void main(String[] args) {
        Pessoa p1 = new Pessoa();
        p1.nome = "Ana";
        p1.idade = 20;
        p1.cidade = "Criciúma";

        Pessoa p2 = new Pessoa();
        p2.nome = "Carlos";
        p2.idade = 35;
        p2.cidade = "Florianópolis";

        System.out.println("=== Apresentando pessoas ===");
        apresentarPessoa(p1);
        apresentarPessoa(p2);

        System.out.println("\n=== Aniversário (objeto por referência) ===");
        System.out.println("Idade antes: " + p1.idade);
        fazerAniversario(p1);
        System.out.println("Idade depois: " + p1.idade); // foi alterada!

        System.out.println("\n=== Tentando dobrar idade (primitivo por valor) ===");
        System.out.println("Idade antes: " + p2.idade);
        tentarDobrarIdade(p2.idade);
        System.out.println("Idade depois: " + p2.idade); // NÃO foi alterada
    }
}
