public class Veiculo {
    String marca;
    int velocidadeMaxima;

    public Veiculo(String marca, int velocidadeMaxima){
        this.marca = marca;
        this.velocidadeMaxima = velocidadeMaxima;
    }

    public void apresentar(){
        System.out.println("Marca: " + marca + " | " + "Velocidade Maxima: " + velocidadeMaxima);
    }
}
