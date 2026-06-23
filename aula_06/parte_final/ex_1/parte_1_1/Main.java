package aula_06.parte_final.ex_1.parte_1_1;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;

public class Main {

    void main() {
        // Path aponta para o arquivo diario.txt na raiz do projeto
        var arquivo = Path.of("diario.txt");

        // Lê a entrada do usuário pelo terminal (IO.readln — Java 26, JEP 512)
        var texto = IO.readln("Entrada do dia: ");

        // Monta a linha com a data de hoje e o texto digitado
        var entrada = LocalDate.now() + " - " + texto + "\n";

        // try-with-resources garante que o FileWriter é fechado automaticamente.
        // O segundo parâmetro "true" ativa o modo append (não apaga o conteúdo anterior).
        try (var writer = new FileWriter(arquivo.toFile(), true)) {
            writer.write(entrada);
        } catch (IOException e) {
            IO.println("Erro ao gravar no diário: " + e.getMessage());
            return;
        }

        // Lê todas as linhas do arquivo e exibe no terminal
        try {
            var linhas = Files.readAllLines(arquivo);
            IO.println("\n=== Diário ===");
            for (var linha : linhas) {
                IO.println(linha);
            }
            IO.println("==============");
            // .size() retorna o número total de entradas
            IO.println("Total de entradas: " + linhas.size());
        } catch (IOException e) {
            IO.println("Erro ao ler o diário: " + e.getMessage());
        }
    }
}
