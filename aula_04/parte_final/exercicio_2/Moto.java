package aula_04.parte_final.exercicio_2;

public class Moto extends Veiculo {

    public Moto(String marca, int velocidadeMaxima) {
        super(marca, velocidadeMaxima);
    }

    public void empinar() {
        IO.println(marca + " empinando!");
    }
}
