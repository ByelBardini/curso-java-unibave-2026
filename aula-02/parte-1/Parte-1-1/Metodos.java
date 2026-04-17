// Parte 1.1 - Chamando métodos da mesma classe dentro do void main()
void main() {
    saudacao();
    apresentarCurso();
    exibirDataAtual();
    exibirSeparador();
    saudacao();
}

void saudacao() {
    IO.println("Olá! Bem-vindo ao curso de Java!");
}

void apresentarCurso() {
    IO.println("Curso: Programação Java - Unibave 2026");
    IO.println("Linguagem: Java 26 (modo sem classe - Unnamed Classes)");
}

void exibirDataAtual() {
    var hoje = java.time.LocalDate.now();
    IO.println("Data de hoje: " + hoje);
}

void exibirSeparador() {
    IO.println("--------------------------------------------------");
}