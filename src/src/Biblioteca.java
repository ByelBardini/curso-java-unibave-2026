import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<ItemBiblioteca> acervo = new ArrayList<>();
    public Biblioteca() {
        acervo = Persistencia.carregar();
    }
    public boolean tituloExiste(String titulo) {
        for (ItemBiblioteca item : acervo) {
            if (item.getTitulo().equalsIgnoreCase(titulo)) {
                return true;
            }
        }
        return false;
    }
    public boolean cadastrar(ItemBiblioteca item) {
        if (tituloExiste(item.getTitulo())) {
            return false;
        }
        acervo.add(item);
        Persistencia.salvar(acervo);
        return true;
    }
    public void listar() {
        if (acervo.isEmpty()) {
            System.out.println("Acervo vazio.");
            return;
        }
        for (ItemBiblioteca item : acervo) {
            System.out.println("====================");
            System.out.println(item);
            System.out.println("====================");
        }
    }
    public ItemBiblioteca buscar(String titulo) {
        for (ItemBiblioteca item : acervo) {
            if (item.getTitulo().equalsIgnoreCase(titulo)) {
                return item;
            }
        }
        return null;
    }
    public void emprestar(String titulo, String responsavel)
            throws ItemNaoEncontradoException,
            ItemIndisponivelException,
            LimiteEmprestimosException {
        ItemBiblioteca item = buscar(titulo);
        if (item == null) {
            throw new ItemNaoEncontradoException("Item não encontrado no acervo.");
        }
        int quantidade = 0;
        for (ItemBiblioteca i : acervo) {
            if (i.isEmprestado()
                    && responsavel.equalsIgnoreCase(i.getResponsavel())) {
                quantidade++;
            }
        }
        if (quantidade >= 2) {
            throw new LimiteEmprestimosException(
                    "Essa pessoa já possui 2 itens emprestados."
            );
        }
        item.emprestar(responsavel);
        Persistencia.salvar(acervo);
    }
    public void devolver(String titulo)
            throws ItemNaoEncontradoException {
        ItemBiblioteca item = buscar(titulo);
        if (item == null) {
            throw new ItemNaoEncontradoException("Item não encontrado no acervo.");
        }
        item.devolver();
        Persistencia.salvar(acervo);
    }
    public boolean remover(String titulo) {
        ItemBiblioteca item = buscar(titulo);
        if (item == null) {
            return false;
        }
        acervo.remove(item);
        Persistencia.salvar(acervo);
        return true;
    }
    public void resumo() {

        int livros = 0;
        int revistas = 0;
        int disponiveis = 0;
        int emprestados = 0;

        for (ItemBiblioteca item : acervo) {

            if (item.getTipo().equalsIgnoreCase("Livro")) livros++;
            else revistas++;

            if (item.isEmprestado()) emprestados++;
            else disponiveis++;
        }

        System.out.println("\n===== RESUMO =====");
        System.out.println("Total: " + acervo.size());
        System.out.println("Livros: " + livros);
        System.out.println("Revistas: " + revistas);
        System.out.println("Disponíveis: " + disponiveis);
        System.out.println("Emprestados: " + emprestados);
}