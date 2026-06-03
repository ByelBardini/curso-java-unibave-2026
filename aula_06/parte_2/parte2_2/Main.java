package aula_06.parte_2.parte2_2;

import java.io.FileWriter;
import java.io.IOException;

public class Main {

    void main() {
        // FileWriter com o segundo parâmetro 'true' => MODO APPEND.
        // O conteúdo anterior é mantido e as novas linhas vão no final.
        try (FileWriter writer = new FileWriter("log.txt", true)) {
            writer.write("Linha adicionada no final\n");
            writer.write("Mais uma linha no final\n");

            IO.println("Linhas adicionadas em 'log.txt' (append).");
            IO.println("O conteúdo anterior foi preservado.");
        } catch (IOException e) {
            IO.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }
}
