void main() {
    Estoque e = new Estoque();
    e.setProduto("Notebook");
    e.setQuantidade(10);
    e.setPrecoUnitario(3500.00);

    IO.println("=== Estoque inicial ===");
    e.exibir();

    IO.println("\n=== Vendas ===");
    e.vender(3);
    e.vender(20); // bloqueado — estoque insuficiente

    IO.println("\n=== Reposição ===");
    e.reporEstoque(5);

    IO.println("\n=== Testando dados inválidos ===");
    e.setProduto("");     // bloqueado
    e.setQuantidade(-5);  // bloqueado
    e.setPrecoUnitario(-100); // bloqueado

    IO.println("\n=== Estado final ===");
    e.exibir();
}
