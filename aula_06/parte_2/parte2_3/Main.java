package aula_06.parte_2.parte2_3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {

    void main() {
        Path arquivo = Path.of("log.txt");

        try {
            List<String> linhas = Files.readAllLines(arquivo);

            IO.println("=== Conteúdo de log.txt ===");
            for (String linha : linhas) {
                IO.println(linha);
            }
            IO.println("===========================");
            IO.println("Total de linhas: " + linhas.size());
            IO.println("");
            IO.println("Experimente:");
            IO.println("1) Rodar parte2_1 (sobrescreve) e depois esta classe.");
            IO.println("2) Rodar parte2_2 (append) e ver as linhas extras.");
            IO.println("3) Rodar parte2_1 de novo e ver tudo apagado.");
        } catch (IOException e) {
            IO.println("Erro ao ler o arquivo: " + e.getMessage());
            IO.println("Dica: rode primeiro a parte2_1 para criar o arquivo.");
        }
    }
}
