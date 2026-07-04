import java.util.ArrayList;

public class Biblioteca {

    private ArrayList<ItemBiblioteca> acervo;

    public Biblioteca() {
        acervo = new ArrayList<>(Persistencia.carregar());
    }

    public boolean cadastrar(ItemBiblioteca item) {

        for (ItemBiblioteca i : acervo) {
            if (i.getTitulo().equalsIgnoreCase(item.getTitulo())) {
                return false;
            }
        }

        acervo.add(item);
        Persistencia.salvar(acervo);
        return true;
    }

    public ItemBiblioteca buscar(String titulo) {

        for (ItemBiblioteca i : acervo) {
            if (i.getTitulo().equalsIgnoreCase(titulo)) {
                return i;
            }
        }
        return null;
    }

    public void emprestar(String titulo, String resp)
            throws ItemNaoEncontradoException, ItemIndisponivelException, LimiteEmprestimosException {

        ItemBiblioteca item = buscar(titulo);

        if (item == null) {
            throw new ItemNaoEncontradoException("item nao encontrado");
        }

        int qtd = 0;

        for (ItemBiblioteca i : acervo) {
            if (i.isEmprestado()
                    && i.getResponsavel() != null
                    && i.getResponsavel().equalsIgnoreCase(resp)) {
                qtd++;
            }
        }

        if (qtd >= 2) {
            throw new LimiteEmprestimosException("limite de 2 itens atingido");
        }

        item.emprestar(resp);
        Persistencia.salvar(acervo);
    }

    public void devolver(String titulo)
            throws ItemNaoEncontradoException, ItemIndisponivelException {

        ItemBiblioteca item = buscar(titulo);

        if (item == null) {
            throw new ItemNaoEncontradoException("item nao encontrado");
        }

        item.devolver();
        Persistencia.salvar(acervo);
    }

    public boolean remover(String titulo) {

        ItemBiblioteca item = buscar(titulo);

        if (item == null) return false;

        acervo.remove(item);
        Persistencia.salvar(acervo);
        return true;
    }

    public void listar() {
        for (ItemBiblioteca i : acervo) {
            System.out.println(i);
            System.out.println("-----");
        }
    }

    public void listarLivros() {
        for (ItemBiblioteca i : acervo) {
            if (i instanceof Livro) {
                System.out.println(i);
                System.out.println("-----");
            }
        }
    }

    public void listarRevistas() {
        for (ItemBiblioteca i : acervo) {
            if (i instanceof Revista) {
                System.out.println(i);
                System.out.println("-----");
            }
        }
    }

    public void buscarPorAutor(String autor) {
        for (ItemBiblioteca i : acervo) {
            if (i instanceof Livro l) {
                if (l.getAutor().equalsIgnoreCase(autor)) {
                    System.out.println(l);
                }
            }
        }
    }

    public void buscarPorEditora(String editora) {
        for (ItemBiblioteca i : acervo) {
            if (i instanceof Revista r) {
                if (r.getEditora().equalsIgnoreCase(editora)) {
                    System.out.println(r);
                }
            }
        }
    }

    public void resumo() {

        int l = 0, r = 0, d = 0, e = 0;

        for (ItemBiblioteca i : acervo) {

            if (i instanceof Livro) l++;
            else r++;

            if (i.isEmprestado()) e++;
            else d++;
        }

        System.out.println("total: " + acervo.size());
        System.out.println("livros: " + l);
        System.out.println("revistas: " + r);
        System.out.println("disponiveis: " + d);
        System.out.println("emprestados: " + e);
    }
}