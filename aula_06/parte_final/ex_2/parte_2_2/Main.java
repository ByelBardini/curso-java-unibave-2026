package aula_06.parte_final.ex_2.parte_2_2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {

    // Lê o arquivo e converte cada linha em um objeto Produto
    List<Produto> carregar(Path arquivo) {
        var estoque = new ArrayList<Produto>();
        if (!Files.exists(arquivo)) return estoque;

        try {
            for (var linha : Files.readAllLines(arquivo)) {
                if (linha.isBlank()) continue;
                var partes = linha.split(";");
                // Ignora linhas com formato inválido (precisam ter exatamente 4 partes)
                if (partes.length != 4) continue;
                try {
                    var quantidade = Integer.parseInt(partes[2]);
                    var preco = Double.parseDouble(partes[3]);
                    estoque.add(new Produto(partes[0], partes[1], quantidade, preco));
                } catch (NumberFormatException e) {
                    // Ignora linhas com quantidade ou preço em formato inválido
                    IO.println("Linha ignorada (valores inválidos): " + linha);
                }
            }
        } catch (IOException e) {
            IO.println("Erro ao carregar estoque: " + e.getMessage());
        }
        return estoque;
    }

    // Grava a lista inteira no arquivo, sobrescrevendo o conteúdo anterior.
    // Files.write recebe a lista de linhas e cuida de fechar o arquivo sozinho.
    void salvar(Path arquivo, List<Produto> estoque) {
        var linhas = new ArrayList<String>();
        for (var p : estoque) {
            linhas.add(p.paraLinha());
        }
        try {
            Files.write(arquivo, linhas);
        } catch (IOException e) {
            IO.println("Erro ao salvar estoque: " + e.getMessage());
        }
    }

    void main() {
        var arquivo = Path.of("estoque.txt");

        // 1. Carrega o estoque do arquivo
        var estoque = carregar(arquivo);

        // 2. Se a lista estiver vazia (primeira execução), cadastra produtos de exemplo
        if (estoque.isEmpty()) {
            estoque.add(new Produto("P001", "Caderno", 10, 12.90));
            estoque.add(new Produto("P002", "Caneta Azul", 3, 2.50));
            estoque.add(new Produto("P003", "Borracha", 2, 1.80));
            estoque.add(new Produto("P004", "Régua 30cm", 8, 5.00));
            IO.println("Estoque vazio. 4 produtos de exemplo cadastrados.\n");
        }

        // 3. Lista todos os produtos em formato tabular.
        // String::formatted é a forma moderna e encadeável de String.format.
        IO.println("=== Estoque ===");
        IO.println("%-6s %-15s %5s %10s %15s".formatted(
                "Cod.", "Nome", "Qtd.", "Preço", "Val. Estoque"));
        IO.println("-".repeat(55));

        var totalEstoque = 0.0;
        for (var p : estoque) {
            IO.println("%-6s %-15s %5d %10.2f %15.2f".formatted(
                    p.getCodigo(), p.getNome(), p.getQuantidade(),
                    p.getPreco(), p.getValorEmEstoque()));
            totalEstoque += p.getValorEmEstoque();
        }

        // 4. Exibe o valor total somando o valor em estoque de cada produto
        IO.println("-".repeat(55));
        IO.println("Valor total do estoque: R$ %.2f".formatted(totalEstoque));

        // 5. Alerta para produtos com quantidade abaixo de 5
        IO.println("\n=== Estoque baixo (qtd < 5) ===");
        var temBaixo = false;
        for (var p : estoque) {
            if (p.getQuantidade() < 5) {
                IO.println("ALERTA: " + p.getNome() + " — apenas " + p.getQuantidade() + " unidade(s).");
                temBaixo = true;
            }
        }
        if (!temBaixo) IO.println("Nenhum produto com estoque baixo.");

        // Desafio extra: aplica reajuste de 10% em todos os produtos e salva
        for (var p : estoque) {
            p.aumentarPreco(10);
        }
        IO.println("\nPreços reajustados em 10%.");

        // 6. Salva o estoque atualizado no arquivo
        salvar(arquivo, estoque);
        IO.println("Estoque salvo em estoque.txt.");
    }
}
