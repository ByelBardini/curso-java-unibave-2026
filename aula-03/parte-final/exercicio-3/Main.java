void exibirLivro(Livro l) {
    IO.println("Título: " + l.titulo + " | Autor: " + l.autor + " | Páginas: " + l.numeroDePaginas);
}

void adicionarPaginas(Livro l, int quantidade) {
    l.numeroDePaginas = l.numeroDePaginas + quantidade;
    IO.println("Páginas adicionadas. Total agora: " + l.numeroDePaginas);
}

void main() {
    Livro l1 = new Livro();
    l1.titulo = "O Senhor dos Anéis";
    l1.autor = "J.R.R. Tolkien";
    l1.numeroDePaginas = 1178;

    IO.println("=== Antes de adicionar páginas ===");
    exibirLivro(l1);
    IO.println("Páginas antes: " + l1.numeroDePaginas);

    adicionarPaginas(l1, 50);

    IO.println("Páginas depois: " + l1.numeroDePaginas); // foi alterado — objeto é referência
}
