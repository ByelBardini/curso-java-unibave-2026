package aula_02.parte_final.exercicios.ex2_4;

public class Metodos {

    void main() {
        Conversor conv = new Conversor();
        ImpressoraResultados imp = new ImpressoraResultados();

        imp.exibirConversao("°C", "°F", 100, conv.celsiusParaFahrenheit(100));
        imp.exibirConversao("km", "milhas", 10, conv.kmParaMilhas(10));
        imp.exibirConversao("kg", "libras", 70, conv.kgParaLibras(70));
    }
}