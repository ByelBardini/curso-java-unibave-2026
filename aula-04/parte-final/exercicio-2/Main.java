void main() {
    var carro = new Carro("Toyota", 200);
    var moto = new Moto("Honda", 180);

    carro.apresentar();
    carro.ligarArCondicionado();

    IO.println("---");

    moto.apresentar();
    moto.empinar();
}
