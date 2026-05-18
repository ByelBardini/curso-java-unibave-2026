public class Smartphone implements Carregavel, Reproduzivel {

    @Override
    public void carregar() {
        IO.println("Carregando smartphone...");
    }

    @Override
    public void reproduzir() {
        IO.println("Reproduzindo mídia no smartphone");
    }
}
