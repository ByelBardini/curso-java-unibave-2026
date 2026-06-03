package aula_04.parte_final.exercicio_2;

public class Carro extends Veiculo {

    public Carro(String marca, int velocidadeMaxima) {
        super(marca, velocidadeMaxima);
    }

    public void ligarArCondicionado() {
        IO.println("Ar-condicionado ligado!");
    }
}
