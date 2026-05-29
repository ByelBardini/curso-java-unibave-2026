public class Produto {
    public String nome;
    public double preco;
    public int estoque;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
        this.estoque = 0;
    }

    public Produto(String nome, double preco, int estoque) {
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }

    public void exibir() {
        IO.println("Produto: " + nome + " | Preço: R$ " + String.format("%.2f", preco) + " | Estoque: " + estoque);
    }
}
