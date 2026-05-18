import java.util.ArrayList;
import java.util.List;

void main() {
    List<Produto> carrinho = new ArrayList<>();

    carrinho.add(new Produto("Notebook", 3500.00));
    carrinho.add(new Produto("Mouse", 89.90));
    carrinho.add(new Produto("Teclado", 159.90));
    carrinho.add(new Produto("Monitor", 1200.00));

    IO.println("=== Produtos no carrinho ===");
    for (Produto produto : carrinho) {
        produto.exibirDados();
    }

    // Calcula o total
    double total = 0;
    for (Produto produto : carrinho) {
        total += produto.getPreco();
    }
    IO.println("\nTotal: R$ " + total);

    // Remove o primeiro produto da lista
    carrinho.remove(0);
    IO.println("\nApós remover o primeiro produto:");
    for (Produto produto : carrinho) {
        produto.exibirDados();
    }

    IO.println("\nTotal de itens no carrinho: " + carrinho.size());
}
