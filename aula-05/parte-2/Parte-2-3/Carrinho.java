import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private List<Produto> produtos = new ArrayList<>();

    public void adicionar(Produto produto) {
        produtos.add(produto);
    }

    public void remover(int indice) {
        produtos.remove(indice);
    }

    public void exibirProdutos() {
        for (Produto produto : produtos) {
            produto.exibirDados();
        }
    }

    public double calcularTotal() {
        double total = 0;
        for (Produto produto : produtos) {
            total += produto.getPreco();
        }
        return total;
    }

    public int tamanho() {
        return produtos.size();
    }
}
