package simulado.src;

public class Alunos extends Pessoa  {
    public Alunos(String nome, int matricula) {
        super(nome, matricula);
    }
    public void somarNotas(double n1, double n2 ){
        double media = (n1 + n2) / 2;
        if (media >= 7){
            System.out.println(getNome() + ": Aprovado " + media + " " + getMatricula());
        }else {
            System.out.println(getNome() + ": Reprovado " + media + " " + getMatricula());
        }
    }
}