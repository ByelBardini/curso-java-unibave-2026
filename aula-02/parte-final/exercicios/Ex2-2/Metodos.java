void main() {
    descrever("Olá, mundo!");
    descrever(42);
    descrever(3.14);
    descrever(true);
}

void descrever(String texto) {
    IO.println("Texto: " + texto);
}

void descrever(int numero) {
    IO.println("Número inteiro: " + numero);
}

void descrever(double numero) {
    IO.println("Número decimal: " + numero);
}

void descrever(boolean valor) {
    IO.println("Booleano: " + valor);
}
