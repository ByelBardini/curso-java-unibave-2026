package aula_04.parte_final.exercicio_5;

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
