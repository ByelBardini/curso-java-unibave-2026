package src;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();
        biblioteca.carregarArquivo();

        while (true) {

            String opcao = JOptionPane.showInputDialog(
                    "===== BIBLIOTECA =====\n" +
                            "1 - Cadastrar Livro\n" +
                            "2 - Cadastrar Revista\n" +
                            "3 - Listar Acervo\n" +
                            "4 - Emprestar Item\n" +
                            "5 - Devolver Item\n" +
                            "6 - Remover Item\n" +
                            "0 - Sair\n\n" +
                            "Escolha uma opção:"
            );

            if (opcao == null) {
                break;
            }

            switch (opcao) {

                case "1":
                    biblioteca.adicionarLivro();
                    break;

                case "2":
                    biblioteca.adicionarRevista();
                    break;

                case "3":
                    biblioteca.listarItens();
                    break;

                case "4":
                    biblioteca.emprestarItem();
                    break;

                case "5":
                    biblioteca.devolverItem();
                    break;

                case "6":
                    biblioteca.removerItem();
                    break;

                case "0":
                    JOptionPane.showMessageDialog(null, "Programa encerrado!");
                    return;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        }
    }
}