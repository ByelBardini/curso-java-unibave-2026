void main() {
    var pato = new Pato("Donald");
    var peixe = new Peixe("Nemo");

    IO.println("=== Pato ===");
    pato.nadar();
    pato.voar();

    IO.println("---");

    IO.println("=== Peixe ===");
    peixe.nadar();
}
