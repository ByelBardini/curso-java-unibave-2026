package aula_06.parte_final.ex_1.parte_1_2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;

public class Main {

    void main() {
        var arquivo = Path.of("texto.txt");

        // Se o arquivo não existir, cria automaticamente com conteúdo de exemplo.
        // O text block (""") do Java moderno mantém as linhas legíveis no código.
        if (!Files.exists(arquivo)) {
            var exemplo = """
                    Java é uma linguagem de programação orientada a objetos.
                    Com Java é possível criar aplicações robustas e portáveis.
                    A plataforma Java oferece uma vasta biblioteca padrão.
                    Programar em Java é aprender a pensar de forma estruturada.
                    Java continua sendo uma das linguagens mais usadas no mundo.
                    """;
            try {
                Files.writeString(arquivo, exemplo);
            } catch (IOException e) {
                IO.println("Erro ao criar texto.txt: " + e.getMessage());
                return;
            }
            IO.println("Arquivo texto.txt criado com conteúdo de exemplo.\n");
        }

        try {
            var linhas = Files.readAllLines(arquivo);

            var totalLinhas = 0;
            var totalPalavras = 0;
            var totalCaracteres = 0;
            var maisLonga = "";
            // Mapa para contar a frequência de cada palavra
            var frequencia = new HashMap<String, Integer>();

            for (var linha : linhas) {
                // isBlank() retorna true para linhas vazias ou só com espaços
                if (linha.isBlank()) continue;

                totalLinhas++;

                // Compara o tamanho para encontrar a linha mais longa
                if (linha.length() > maisLonga.length()) maisLonga = linha;

                // split(" ") quebra a linha em palavras pelo espaço
                for (var palavra : linha.split(" ")) {
                    if (palavra.isBlank()) continue;
                    totalPalavras++;
                    totalCaracteres += palavra.length();

                    // Normaliza a palavra: minúsculas e remove pontuação
                    var chave = palavra.toLowerCase().replaceAll("[^a-záéíóúàãõâêôç]", "");
                    if (!chave.isBlank()) {
                        // getOrDefault retorna 0 se a palavra ainda não foi contada
                        frequencia.put(chave, frequencia.getOrDefault(chave, 0) + 1);
                    }
                }
            }

            // Percorre o mapa para encontrar a palavra com maior contagem
            var palavraFrequente = "";
            var maxFreq = 0;
            for (var entry : frequencia.entrySet()) {
                if (entry.getValue() > maxFreq) {
                    maxFreq = entry.getValue();
                    palavraFrequente = entry.getKey();
                }
            }

            IO.println("=== Estatísticas de texto.txt ===");
            IO.println("Total de linhas:     " + totalLinhas);
            IO.println("Total de palavras:   " + totalPalavras);
            IO.println("Total de caracteres: " + totalCaracteres);
            IO.println("Linha mais longa:    " + maisLonga);
            IO.println("Palavra mais freq.:  \"" + palavraFrequente + "\" (" + maxFreq + "x)");
        } catch (IOException e) {
            IO.println("Erro ao ler texto.txt: " + e.getMessage());
        }
    }
}
