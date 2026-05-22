void main() {
    Carro c = new Carro();
    c.setModelo("Fusca");

    IO.println("=== Testando ano válido ===");
    c.setAno(1972);
    IO.println("Ano: " + c.getAno());

    IO.println("\n=== Testando anos inválidos ===");
    c.setAno(1800); // menor que 1886
    c.setAno(2100); // maior que 2026
    IO.println("Ano continua: " + c.getAno()); // permanece 1972
}
