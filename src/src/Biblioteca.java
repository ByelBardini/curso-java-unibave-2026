package src.src;

import java.util.ArrayList;

public class Biblioteca {

    private ArrayList<livrosDisponiveis> acervo;

    public Biblioteca() {
        acervo = Persistencia.carregar();
    }

    public ArrayList<livrosDisponiveis> getAcervo() {
        return acervo;
    }

    // ==========================
    // CADASTRAR
    // ==========================

    public void cadastrar(livrosDisponiveis item) throws LivroInvalido {

        if (item == null) {
            throw new LivroInvalido("Item inválido.");
        }

        if (item.getTitulo() == null || item.getTitulo().trim().isEmpty()) {
            throw new LivroInvalido("Informe um título.");
        }

        acervo.add(item);

        salvarDados();
    }

    // ==========================
    // LISTAR
    // ==========================

    public String listarItens() {

        if (acervo.isEmpty()) {
            return "Acervo vazio.";
        }

        StringBuilder lista = new StringBuilder();

        for (livrosDisponiveis item : acervo) {

            lista.append(item.toString());
            lista.append("\n---------------------------------\n");

        }

        return lista.toString();
    }

    // ==========================
    // PROCURAR ITEM
    // ==========================

    private livrosDisponiveis procurarItem(String titulo)
            throws NãoEncontrado {

        for (livrosDisponiveis item : acervo) {

            if (item.getTitulo().equalsIgnoreCase(titulo)) {
                return item;
            }

        }

        throw new NãoEncontrado("Item não encontrado.");
    }

    // ==========================
    // EMPRESTAR
    // ==========================

    public void emprestar(String titulo, String pessoa)
            throws Exception {

        livrosDisponiveis item = procurarItem(titulo);

        if (!item.estaDisponivel()) {
            throw new Nãodisponivel("Item já está emprestado.");
        }

        if (contarEmprestimosPessoa(pessoa) >= 2) {
            throw new LimiteEmprestimo(
                    "Essa pessoa já possui 2 itens emprestados.");
        }

        item.emprestar(pessoa);

        salvarDados();
    }

    // ==========================
    // DEVOLVER
    // ==========================

    public void devolver(String titulo)
            throws Exception {

        livrosDisponiveis item = procurarItem(titulo);

        item.devolver();

        salvarDados();
    }

    // ==========================
    // REMOVER
    // ==========================

    public void remover(String titulo)
            throws NãoEncontrado {

        livrosDisponiveis item = procurarItem(titulo);

        acervo.remove(item);

        salvarDados();
    }

    // ==========================
    // CONTAR EMPRÉSTIMOS
    // ==========================

    private int contarEmprestimosPessoa(String pessoa) {

        int contador = 0;

        for (livrosDisponiveis item : acervo) {

            if (item.getEmprestado()
                    && item.getResponsavel().equalsIgnoreCase(pessoa)) {

                contador++;
            }

        }

        return contador;
    }

    // ==========================
    // SALVAR DADOS
    // ==========================

    public void salvarDados() {

        Persistencia.salvar(acervo);

    }

}