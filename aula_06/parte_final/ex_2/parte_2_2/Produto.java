package aula_06.parte_final.ex_2.parte_2_2;

public class Produto {

    private String codigo;
    private String nome;
    private int quantidade;
    private double preco;

    public Produto(String codigo, String nome, int quantidade, double preco) {
        this.codigo = codigo;
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public String getCodigo() { return codigo; }
    public String getNome() { return nome; }
    public int getQuantidade() { return quantidade; }
    public double getPreco() { return preco; }

    // Retorna o valor total do produto em estoque (quantidade × preço unitário)
    public double getValorEmEstoque() {
        return quantidade * preco;
    }

    // Aplica um reajuste percentual ao preço (ex: 10 → aumenta 10%)
    public void aumentarPreco(double percentual) {
        preco = preco * (1 + percentual / 100);
    }

    // Serializa o produto em uma linha para gravar no arquivo
    public String paraLinha() {
        return codigo + ";" + nome + ";" + quantidade + ";" + preco;
    }
}
