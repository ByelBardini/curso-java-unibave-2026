package aula_06.parte_final.ex_1.parte_1_1;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.util.List;

public class Main {

    void main() {
        // Path aponta para o arquivo diario.txt na raiz do projeto
        Path arquivo = Path.of("diario.txt");

        // Lê a entrada do usuário pelo terminal
        String texto = IO.readln("Entrada do dia: ");

        // Monta a linha com a data de hoje e o texto digitado
        String entrada = LocalDate.now() + " - " + texto + "\n";

        // try-with-resources garante que o FileWriter é fechado automaticamente
        // O segundo parâmetro "true" ativa o modo append (não apaga o conteúdo anterior)
        try (FileWriter writer = new FileWriter(arquivo.toFile(), true)) {
            writer.write(entrada);
        } catch (IOException e) {
            IO.println("Erro ao gravar no diário: " + e.getMessage());
            return;
        }

        // Lê todas as linhas do arquivo e exibe no terminal
        try {
            List<String> linhas = Files.readAllLines(arquivo);
            IO.println("\n=== Diário ===");
            for (String linha : linhas) {
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
