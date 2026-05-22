void main() {
    var cachorro = new Cachorro("Rex", "Labrador");
    var gato = new Gato("Mimi", "Siamês");

    cachorro.apresentar();
    cachorro.dormir();
    cachorro.latir();

    IO.println("---");

    gato.apresentar();
    gato.dormir();
    gato.miar();
}
