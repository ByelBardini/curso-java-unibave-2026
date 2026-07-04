import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<ItemBiblioteca> acervo;

    public Biblioteca() {
        acervo = Persistencia.carregar();
    }

    public void salvar() {
        Persistencia.salvar(acervo);
    }

    public void cadastrarLivro(String titulo, String autor, String isbn, int ano) {
        if (titulo.isBlank() || autor.isBlank() || isbn.isBlank()) {
            throw new IllegalArgumentException("Campos inválidos. ");
        }

        acervo.add(new Livro(titulo, autor, isbn, ano));
        salvar();
    }

    public void cadastrarRevista(String titulo, String editora, int numero, int ano) {
        if (titulo.isBlank() || editora.isBlank()) {
            throw new IllegalArgumentException("Campos inválidos. ");
        }

        acervo.add(new Revista(titulo, editora, numero, ano));
        salvar();
    }

    public String listarItens() {
        if (acervo.isEmpty()) {
            return "Acervo vazio. ";
        }

        StringBuilder sb = new StringBuilder();

        for (ItemBiblioteca item : acervo) {
            sb.append(item.getTipo())
                    .append(" - ")
                    .append(item.getTitulo())
                    .append(" - ")
                    .append(item.getStatus());

            if (item.estaEmprestado()) {
                sb.append(" (")
                        .append(item.getResponsavel())
                        .append(") ");
            }

            sb.append("\n");
        }

        return  sb.toString();
    }

    private ItemBiblioteca buscar(String titulo) throws ItemNaoEncontradoException {
        for (ItemBiblioteca item : acervo) {
            if (item.getTitulo().equalsIgnoreCase(titulo)) {
                return item;
            }
        }

        throw new ItemNaoEncontradoException("Item não encontrado. ");
    }

    private int quantidadeEmprestimosPessoa(String pessoa) {
        int contador = 0;
        for (ItemBiblioteca item : acervo) {
            if (item.estaEmprestado() && item.getResponsavel().equalsIgnoreCase(pessoa)) {
                contador++;
            }
        }

        return contador;
    }

    public void emprestar(String titulo, String pessoa) throws ItemNaoEncontradoException, ItemEmprestadoException, LimiteEmprestimosException {
            ItemBiblioteca item = buscar(titulo);

            if (item.estaEmprestado()) {
                throw new ItemEmprestadoException("Item já emprestado. ");
            }

            if (quantidadeEmprestimosPessoa(pessoa) >= 2) {
                throw new LimiteEmprestimosException("Essa pessa já possui 2 empréstimos. ");
            }

            item.emprestar(pessoa);
            salvar();
        }

        public void devolver(String titulo) throws ItemNaoEncontradoException {
            ItemBiblioteca item = buscar(titulo);
            item.devolver();
            salvar();
        }

        public void remover(String titulo) throws ItemNaoEncontradoException {
            ItemBiblioteca item = buscar(titulo);
            acervo.remove(item);
            salvar();
        }

        public int totalItens() {
            return acervo.size();
        }

        public int livros() {
            int cont = 0;
            for (ItemBiblioteca item : acervo) {
                if (item instanceof Livro) {
                    cont++;
                }
            }

            return cont;
        }

        public int revistas() {
            int cont = 0;
            for (ItemBiblioteca item : acervo) {
                if (item instanceof Revista) {
                    cont++;
                }
            }

            return cont;
        }

        public int emprestados() {
        int cont = 0;
        for (ItemBiblioteca item : acervo) {
            if (item.estaEmprestado()) {
                cont++;
            }
        }

        return cont;
        }

        public int disponiveis() {
            return totalItens() - emprestados();
        }

        public String listarLivros() {
        StringBuilder sb = new StringBuilder();
        for (ItemBiblioteca item : acervo) {
            if (item instanceof Livro) {
                sb.append(item).append("\n");
            }
        }

        return sb.toString();
        }

        public String listarRevistas() {
        StringBuilder sb = new StringBuilder();
        for (ItemBiblioteca item : acervo) {
            if (item instanceof Revista) {
                sb.append(item).append("\n");
            }
        }

        return sb.toString();
        }

        public String buscarAutor(String autor) {
            StringBuilder sb = new StringBuilder();
            for (ItemBiblioteca item : acervo) {
                if (item instanceof Livro) {
                    Livro livro = (Livro) item;
                    if (livro.getAutor().equalsIgnoreCase(autor)) {
                        sb.append(livro).append("\n");
                    }
                }
            }

            return sb.toString();
        }

        public String buscarEditora(String editora) {
            StringBuilder sb = new StringBuilder();
            for (ItemBiblioteca item : acervo) {
                if (item instanceof Revista) {
                    Revista revista = (Revista) item;
                    if (revista.getEditora().equalsIgnoreCase(editora)) {
                        sb.append(revista).append("\n");
                    }
                }
            }

            return sb.toString();
        }

        public String historicoEmprestimos() {
        StringBuilder sb = new StringBuilder();
        for (ItemBiblioteca item : acervo) {
            sb.append(item.getTitulo())
                    .append(" -> ")
                    .append(item.getVezesEmprestado())
                    .append(" empréstimos \n");
        }

        return sb.toString();
        }
    }
