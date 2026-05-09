public class Produto {
    String nome;
    double preco;
    int estoque;

    public Produto (String nome, double preco){
        this.nome = nome;
        this.preco = preco;
        this.estoque = 0;
    }
    public Produto (String nome, double preco, int estoque){
        this.nome = nome;
        this.preco = preco;
        this.estoque = estoque;
    }

    public void exibir(){
        System.out.println("Produto: Caneta | Preço: R$ 2.50 | Estoque: 100");
    }
}
