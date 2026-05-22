public class Estoque {
    private String produto;
    private int quantidade;
    private double precoUnitario;

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        if (produto == null || produto.isBlank()) {
            IO.println("Erro: nome do produto não pode ser vazio.");
            return;
        }
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        if (quantidade < 0) {
            IO.println("Erro: quantidade não pode ser negativa.");
            return;
        }
        this.quantidade = quantidade;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        if (precoUnitario < 0) {
            IO.println("Erro: preço não pode ser negativo.");
            return;
        }
        this.precoUnitario = precoUnitario;
    }

    public void vender(int quantidade) {
        if (quantidade > this.quantidade) {
            IO.println("Erro: estoque insuficiente. Disponível: " + this.quantidade);
            return;
        }
        double total = quantidade * precoUnitario;
        this.quantidade = this.quantidade - quantidade;
        IO.println("Venda de " + quantidade + " unidade(s) realizada. Total: R$" + total + ". Estoque restante: " + this.quantidade);
    }

    public void reporEstoque(int quantidade) {
        this.quantidade = this.quantidade + quantidade;
        IO.println("Estoque reposto em " + quantidade + " unidade(s). Total agora: " + this.quantidade);
    }

    public void exibir() {
        IO.println("Produto: " + produto + " | Quantidade: " + quantidade + " | Preço unitário: R$" + precoUnitario);
    }
}
