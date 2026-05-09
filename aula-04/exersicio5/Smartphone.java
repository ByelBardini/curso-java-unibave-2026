public class Smartphone implements ICarregavel, IReproduzivel{
    @Override
    public void carregar(){
        System.out.println("Carregando Smartphone...");
    }
    @Override
    public void reproduzir(){
        System.out.println("Reproduzindo mídia no smartphone");
    }
}
