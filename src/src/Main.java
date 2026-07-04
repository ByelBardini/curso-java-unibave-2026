package src.src;

import javax.swing.JOptionPane;

public class Main {

    static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();

        while (true) {

            try {

                String menu = """
                        ===== BIBLIOTECA =====
                        
                        1 - Cadastrar Livro
                        2 - Cadastrar Revista
                        3 - Listar Acervo
                        4 - Emprestar Item
                        5 - Devolver Item
                        6 - Remover Item
                        7 - Sair
                        """;

                int opcao = Integer.parseInt(JOptionPane.showInputDialog(menu));

                switch (opcao) {

                    case 1 -> {

                        String titulo = JOptionPane.showInputDialog("Título:");
                        String autor = JOptionPane.showInputDialog("Autor:");
                        String isbn = JOptionPane.showInputDialog("ISBN:");
                        int ano = Integer.parseInt(JOptionPane.showInputDialog("Ano de publicação:"));

                        Livro livro = new Livro(titulo, autor, isbn, ano);

                        biblioteca.cadastrar(livro);

                        JOptionPane.showMessageDialog(null, "Livro cadastrado com sucesso!");
                    }

                    case 2 -> {

                        String titulo = JOptionPane.showInputDialog("Título:");
                        String editora = JOptionPane.showInputDialog("Editora:");
                        int numero = Integer.parseInt(JOptionPane.showInputDialog("Número da edição:"));
                        int ano = Integer.parseInt(JOptionPane.showInputDialog("Ano da edição:"));

                        Revista revista = new Revista(titulo, editora, numero, ano);

                        biblioteca.cadastrar(revista);

                        JOptionPane.showMessageDialog(null, "Revista cadastrada com sucesso!");
                    }

                    case 3 -> {

                        JOptionPane.showMessageDialog(null, biblioteca.listarItens());

                    }

                    case 4 -> {

                        String titulo = JOptionPane.showInputDialog("Título do item:");
                        String pessoa = JOptionPane.showInputDialog("Nome da pessoa:");

                        biblioteca.emprestar(titulo, pessoa);

                        JOptionPane.showMessageDialog(null, "Empréstimo realizado com sucesso!");

                    }

                    case 5 -> {

                        String titulo = JOptionPane.showInputDialog("Título do item:");

                        biblioteca.devolver(titulo);

                        JOptionPane.showMessageDialog(null, "Item devolvido com sucesso!");

                    }

                    case 6 -> {

                        String titulo = JOptionPane.showInputDialog("Título do item:");

                        biblioteca.remover(titulo);

                        JOptionPane.showMessageDialog(null, "Item removido com sucesso!");

                    }

                    case 7 -> {

                        biblioteca.salvarDados();

                        JOptionPane.showMessageDialog(null, "Sistema encerrado.");

                        System.exit(0);

                    }

                    default -> JOptionPane.showMessageDialog(null, "Opção inválida!");

                }

            } catch (NumberFormatException e) {

                JOptionPane.showMessageDialog(null, "Digite apenas números.");

            } catch (Exception e) {

                JOptionPane.showMessageDialog(null, e.getMessage());

            }

        }

    }

}