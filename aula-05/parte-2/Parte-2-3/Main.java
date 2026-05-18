void main() {
    var carrinho = new Carrinho();

    carrinho.adicionar(new Produto("Notebook", 3500.00));
    carrinho.adicionar(new Produto("Mouse", 89.90));
    carrinho.adicionar(new Produto("Teclado", 159.90));
    carrinho.adicionar(new Produto("Monitor", 1200.00));

    IO.println("=== Produtos no carrinho ===");
    carrinho.exibirProdutos();

    IO.println("\nTotal: R$ " + carrinho.calcularTotal());

    carrinho.remover(0);
    IO.println("\nApós remover o primeiro produto:");
    carrinho.exibirProdutos();

    IO.println("\nTotal de itens no carrinho: " + carrinho.tamanho());
}
