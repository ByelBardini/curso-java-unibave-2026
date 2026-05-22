void tentarMudarPaginas(int paginas) {
    paginas = paginas * 2;
    IO.println("Dentro do método, páginas dobradas: " + paginas);
    // A alteração existe só aqui — int é passado por valor (cópia)
}

void main() {
    Livro l1 = new Livro();
    l1.titulo = "Dom Casmurro";
    l1.autor = "Machado de Assis";
    l1.numeroDePaginas = 256;

    IO.println("Páginas antes: " + l1.numeroDePaginas);
    tentarMudarPaginas(l1.numeroDePaginas);
    IO.println("Páginas depois: " + l1.numeroDePaginas); // continua 256 — primitivo não é alterado fora
}
