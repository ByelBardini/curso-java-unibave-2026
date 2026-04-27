void main() {
    Livro l1 = new Livro();
    l1.titulo = "O Senhor dos Anéis";
    l1.autor = "J.R.R. Tolkien";
    l1.numeroDePaginas = 1178;

    Livro l2 = new Livro();
    l2.titulo = "Dom Casmurro";
    l2.autor = "Machado de Assis";
    l2.numeroDePaginas = 256;

    IO.println("=== Livros cadastrados ===");
    IO.println("Título: " + l1.titulo + " | Autor: " + l1.autor + " | Páginas: " + l1.numeroDePaginas);
    IO.println("Título: " + l2.titulo + " | Autor: " + l2.autor + " | Páginas: " + l2.numeroDePaginas);
}
