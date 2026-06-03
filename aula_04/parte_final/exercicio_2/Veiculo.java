package aula_04.parte_final.exercicio_2;

public class Veiculo {
    public String marca;
    public int velocidadeMaxima;

    public Veiculo(String marca, int velocidadeMaxima) {
        this.marca = marca;
        this.velocidadeMaxima = velocidadeMaxima;
    }

    public void apresentar() {
        IO.println("Marca: " + marca + " | Velocidade máxima: " + velocidadeMaxima + " km/h");
    }
}
