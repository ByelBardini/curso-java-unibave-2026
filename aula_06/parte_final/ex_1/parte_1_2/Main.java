package aula_06.parte_final.ex_1.parte_1_2;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    void main() {
        Path arquivo = Path.of("texto.txt");

        // Se o arquivo não existir, cria automaticamente com conteúdo de exemplo
        if (!Files.exists(arquivo)) {
            try (FileWriter writer = new FileWriter(arquivo.toFile())) {
                writer.write("Java é uma linguagem de programação orientada a objetos.\n");
                writer.write("Com Java é possível criar aplicações robustas e portáveis.\n");
                writer.write("A plataforma Java oferece uma vasta biblioteca padrão.\n");
                writer.write("Programar em Java é aprender a pensar de forma estruturada.\n");
                writer.write("Java continua sendo uma das linguagens mais usadas no mundo.\n");
            } catch (IOException e) {
                IO.println("Erro ao criar texto.txt: " + e.getMessage());
                return;
            }
            IO.println("Arquivo texto.txt criado com conteúdo de exemplo.\n");
        }

        try {
            List<String> linhas = Files.readAllLines(arquivo);

            int totalLinhas = 0;
            int totalPalavras = 0;
            int totalCaracteres = 0;
            String maisLonga = "";
            // Mapa para contar a frequência de cada palavra
            Map<String, Integer> frequencia = new HashMap<>();

            for (String linha : linhas) {
                // isBlank() retorna true para linhas vazias ou só com espaços
                if (linha.isBlank()) continue;

                totalLinhas++;

                // Compara o tamanho para encontrar a linha mais longa
                if (linha.length() > maisLonga.length()) maisLonga = linha;

                // split(" ") quebra a linha em palavras pelo espaço
                for (String palavra : linha.split(" ")) {
                    if (palavra.isBlank()) continue;
                    totalPalavras++;
                    totalCaracteres += palavra.length();

                    // Normaliza a palavra: minúsculas e remove pontuação
                    String chave = palavra.toLowerCase().replaceAll("[^a-záéíóúàãõâêôç]", "");
                    if (!chave.isBlank()) {
                        // getOrDefault retorna 0 se a palavra ainda não foi contada
                        frequencia.put(chave, frequencia.getOrDefault(chave, 0) + 1);
                    }
                }
            }

            // Percorre o mapa para encontrar a palavra com maior contagem
            String palavraFrequente = "";
            int maxFreq = 0;
            for (Map.Entry<String, Integer> entry : frequencia.entrySet()) {
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
