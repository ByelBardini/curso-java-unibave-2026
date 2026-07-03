package src;

import javax.swing.*;
import java.io.*;
import java.util.ArrayList;

public class Biblioteca {

    private ArrayList<ItemBiblioteca> acervo = new ArrayList<>();

    public void adicionarLivro() {

        try {

            String titulo = JOptionPane.showInputDialog("Título:");
            String autor = JOptionPane.showInputDialog("Autor:");
            String isbn = JOptionPane.showInputDialog("ISBN:");
            int ano = Integer.parseInt(JOptionPane.showInputDialog("Ano:"));

            acervo.add(new Livro(titulo, autor, isbn, ano));

            salvarArquivo();

            JOptionPane.showMessageDialog(null, "Livro cadastrado!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Dados inválidos.");
        }

    }

    public void adicionarRevista() {

        try {

            String titulo = JOptionPane.showInputDialog("Título:");
            String editora = JOptionPane.showInputDialog("Editora:");
            int edicao = Integer.parseInt(JOptionPane.showInputDialog("Número da edição:"));
            int ano = Integer.parseInt(JOptionPane.showInputDialog("Ano:"));

            acervo.add(new Revista(titulo, editora, edicao, ano));

            salvarArquivo();

            JOptionPane.showMessageDialog(null, "Revista cadastrada!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Dados inválidos.");
        }

    }

    public void listarItens() {

        if (acervo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Acervo vazio.");
            return;
        }

        String lista = "";

        for (ItemBiblioteca item : acervo) {
            lista += item + "\n\n";
        }

        JOptionPane.showMessageDialog(null, lista);

    }

    public void emprestarItem() {

        String titulo = JOptionPane.showInputDialog("Título do item:");
        String pessoa = JOptionPane.showInputDialog("Nome da pessoa:");

        int contador = 0;

        for (ItemBiblioteca item : acervo) {
            if (item.isEmprestado() &&
                    item.getResponsavel().equalsIgnoreCase(pessoa)) {
                contador++;
            }
        }

        if (contador >= 2) {
            JOptionPane.showMessageDialog(null,
                    "Essa pessoa já possui 2 empréstimos.");
            return;
        }

        for (ItemBiblioteca item : acervo) {

            if (item.getTitulo().equalsIgnoreCase(titulo)) {

                if (item.isEmprestado()) {
                    JOptionPane.showMessageDialog(null,
                            "Item indisponível.");
                    return;
                }

                item.emprestar(pessoa);

                salvarArquivo();

                JOptionPane.showMessageDialog(null,
                        "Empréstimo realizado!");

                return;
            }

        }

        JOptionPane.showMessageDialog(null,
                "Item não encontrado.");

    }

    public void devolverItem() {

        String titulo = JOptionPane.showInputDialog("Título do item:");

        for (ItemBiblioteca item : acervo) {

            if (item.getTitulo().equalsIgnoreCase(titulo)) {

                if (!item.isEmprestado()) {
                    JOptionPane.showMessageDialog(null,
                            "Esse item já está disponível.");
                    return;
                }

                item.devolver();
                salvarArquivo();

                JOptionPane.showMessageDialog(null,
                        "Item devolvido!");

                return;
            }
        }

        JOptionPane.showMessageDialog(null,
                "Item não encontrado.");
    }

    public void removerItem() {

        String titulo = JOptionPane.showInputDialog("Título do item:");

        for (ItemBiblioteca item : acervo) {

            if (item.getTitulo().equalsIgnoreCase(titulo)) {

                acervo.remove(item);
                salvarArquivo();

                JOptionPane.showMessageDialog(null,
                        "Item removido!");

                return;
            }
        }

        JOptionPane.showMessageDialog(null,
                "Item não encontrado.");
    }

    public void salvarArquivo() {

        try {

            BufferedWriter writer = new BufferedWriter(new FileWriter("biblioteca.txt"));

            for (ItemBiblioteca item : acervo) {
                writer.write(item.salvar());
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Erro ao salvar arquivo.");
        }
    }

    public void carregarArquivo() {

        File file = new File("biblioteca.txt");

        if (!file.exists()) return;

        try {

            BufferedReader reader = new BufferedReader(new FileReader(file));

            String linha;

            while ((linha = reader.readLine()) != null) {

                String[] dados = linha.split(";");

                if (dados[0].equals("LIVRO")) {

                    Livro livro = new Livro(
                            dados[1],
                            dados[2],
                            dados[3],
                            Integer.parseInt(dados[4])
                    );

                    if (Boolean.parseBoolean(dados[5])) {
                        livro.emprestar(dados[6]);
                    }

                    acervo.add(livro);

                } else if (dados[0].equals("REVISTA")) {

                    Revista revista = new Revista(
                            dados[1],
                            dados[2],
                            Integer.parseInt(dados[3]),
                            Integer.parseInt(dados[4])
                    );

                    if (Boolean.parseBoolean(dados[5])) {
                        revista.emprestar(dados[6]);
                    }

                    acervo.add(revista);
                }
            }

            reader.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Erro ao carregar arquivo.");
        }
    }
}