public class Carro extends Veiculo{
    public Carro(String nome, int velocidadeMaxima){
        super(nome, velocidadeMaxima);
    }

    public void ligarArConticionado(){
        System.out.println("Ligando Ar-condicionado ligado!");
    }
}
