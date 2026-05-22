void main() {
    var cachorro = new Cachorro("Rex", "Labrador");
    var gato = new Gato("Mimi", "Siamês");

    cachorro.apresentar();
    cachorro.emitirSom();

    IO.println("---");

    gato.apresentar();
    gato.emitirSom();
}
