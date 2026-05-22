void main() {
    Carro c = new Carro();
    c.setModelo("Fusca");
    c.setAno(1972);

    IO.println("Modelo: " + c.getModelo());
    IO.println("Ano: " + c.getAno());
}
