import java.io.FileWriter;
import java.io.IOException;

public class Main {

    void main() {
        // FileWriter sem o segundo parâmetro => SOBRESCREVE o arquivo.
        // Tudo que existia antes em log.txt é APAGADO.
        // Cria (ou sobrescreve) o arquivo log.txt na pasta desta parte.
        try (FileWriter writer = new FileWriter("log.txt")) {
            writer.write("Primeira linha do log\n");
            writer.write("Segunda linha do log\n");

            IO.println("Arquivo 'log.txt' sobrescrito.");
            IO.println("Se já existia conteúdo, ele foi apagado.");
        } catch (IOException e) {
            IO.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }
}
