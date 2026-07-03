package Projeto.src;

public class Alunos {

    private String nome;
    private double nota1;
    private double nota2;

    public Alunos(String nome, double n1, double n2) {
        this.nome = nome;
        this.nota1 = n1;
        this.nota2 = n2;
    }

    public void exibirDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Notas: " + nota1 + " - " + nota2);
        double media = (nota1 + nota2) / 2;
        System.out.println("Média: " + media);
        if (media >= 7) {
            System.out.println("Situação: aprovado");
        } else {
            System.out.println("Situação: reprovado");
        }
        System.out.println("--------------------");
    }
}
