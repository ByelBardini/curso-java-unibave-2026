public class Main {
    public static void main(String[] args) {
        Produto p = new Produto();

        // Usando setters para definir os valores
        p.setNome("Notebook");
        p.setPreco(3500.00);

        // Usando getters para ler os valores
        System.out.println("Produto: " + p.getNome());
        System.out.println("Preço: R$" + p.getPreco());

        // Alterando com setter
        p.setPreco(2999.90);
        System.out.println("Novo preço: R$" + p.getPreco());
    }
}
