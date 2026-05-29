void main() {
    var smartphone = new Smartphone();
    var fone = new Fone();

    IO.println("=== Smartphone ===");
    smartphone.carregar();
    smartphone.reproduzir();

    IO.println("---");

    IO.println("=== Fone ===");
    fone.reproduzir();
}
