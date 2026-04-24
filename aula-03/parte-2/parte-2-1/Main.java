void Main {
    public static void main(String[] args) {
        Produto p = new Produto();

        // Usando setters para definir os valores
        p.setNome("Notebook");
        p.setPreco(3500.00);

        // Usando getters para ler os valores
        IO.println("Produto: " + p.getNome());
        IO.println("Preço: R$" + p.getPreco());

        // Alterando com setter
        p.setPreco(2999.90);
        IO.println("Novo preço: R$" + p.getPreco());
    }
}
