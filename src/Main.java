import javax.swing.*;

public class Main {
    static void main() {

        Biblioteca biblioteca = new Biblioteca();

        while (true) {
            String opcao = JOptionPane.showInputDialog(null, """
                    ===== BIBLIOTECA =====
                    
                    ----- FUNÇÕES BÁSICAS -----
                    
                    1 - Cadastrar Livro
                    2 - Cadastrar Revista
                    3 - Listar Acervo
                    4 - Emprestar Item
                    5 - Devolver Item
                    6 - Remover Item
                    
                    ----- FUNÇÕES EXTRAS -----
                    
                    7 - Resumo do Acervo
                    8 - Listar Livros
                    9 - Listar Revistas
                    10 - Buscar Livro por Autor
                    11 - Buscar Revista por Editora
                    12 - Histórico de Empréstimos
                    
                    0 - Sair
                    """);

            if (opcao == null || opcao.equals("0")) {
                break;
            }

            try {
                switch (opcao) {
                    case "1" -> {
                        String titulo = JOptionPane.showInputDialog(null, "Título: ");
                        String autor = JOptionPane.showInputDialog(null, "Autor: ");
                        String isbn = JOptionPane.showInputDialog(null, "ISBN: ");
                        int ano = Integer.parseInt(JOptionPane.showInputDialog(null, "Ano: "));

                        biblioteca.cadastrarLivro(titulo, autor, isbn, ano);
                        JOptionPane.showMessageDialog(null, "Livro cadastrado! ");
                    }

                    case "2" -> {
                        String titulo = JOptionPane.showInputDialog(null, "Título: ");
                        String editora = JOptionPane.showInputDialog(null, "Editora: ");
                        int numero = Integer.parseInt(JOptionPane.showInputDialog(null, "Número da edição: "));
                        int ano = Integer.parseInt(JOptionPane.showInputDialog(null, "Número da edição: "));

                        biblioteca.cadastrarRevista(titulo, editora, numero, ano);
                        JOptionPane.showMessageDialog(null, "Revista cadastrada! ");
                    }

                    case "3" -> {
                        JOptionPane.showMessageDialog(null, biblioteca.listarItens());
                    }

                    case "4" -> {
                        String titulo = JOptionPane.showInputDialog(null, "Título: ");
                        String pessoa = JOptionPane.showInputDialog(null, "Nome: ");

                        biblioteca.emprestar(titulo, pessoa);
                        JOptionPane.showMessageDialog(null, "Empréstimo realizado! ");
                    }

                    case "5" -> {
                        String titulo = JOptionPane.showInputDialog(null, "Título: ");

                        biblioteca.devolver(titulo);
                        JOptionPane.showMessageDialog(null, "Item devolvido! ");
                    }

                    case "6" -> {
                        String titulo = JOptionPane.showInputDialog(null, "Título: ");

                        biblioteca.remover(titulo);
                        JOptionPane.showMessageDialog(null, "Item removido! ");
                    }

                    case "7" -> {
                        String resumo = "Total :"
                                + biblioteca.totalItens()
                                + "\n\nLivros: "
                                + biblioteca.livros()
                                + "\nRevistas: "
                                + biblioteca.revistas()
                                + "\n\nDisponíveis: "
                                + biblioteca.disponiveis()
                                + "\nEmprestados: "
                                + biblioteca.emprestados();
                        JOptionPane.showMessageDialog(null, resumo);
                    }

                    case "8" -> JOptionPane.showMessageDialog(null, biblioteca.listarLivros());

                    case "9" -> JOptionPane.showMessageDialog(null, biblioteca.listarRevistas());

                    case "10" -> {
                        String autor = JOptionPane.showInputDialog(null, "Autor: ");
                        JOptionPane.showMessageDialog(null, biblioteca.buscarAutor(autor));
                    }

                    case "11" -> {
                        String editora = JOptionPane.showInputDialog(null, "Editora: ");
                        JOptionPane.showMessageDialog(null, biblioteca.buscarAutor(editora));
                    }

                    case "12" -> JOptionPane.showMessageDialog(null, biblioteca.historicoEmprestimos());

                    default -> JOptionPane.showMessageDialog(null, "Opção inválida. ");
                }
            } catch (ItemNaoEncontradoException | ItemEmprestadoException | LimiteEmprestimosException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Digite um número válido. ");
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }
    }
}
