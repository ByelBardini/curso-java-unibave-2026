public class DivisaoPorZeroException extends Exception {
    private double dividendo;

    public DivisaoPorZeroException(double dividendo) {
        super("Não é possível dividir " + dividendo + " por zero.");
        this.dividendo = dividendo;
    }

    public double getDividendo() {
        return dividendo;
    }
}
