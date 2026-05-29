import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {

    void main() {
        // Lê o arquivo mensagem.txt na pasta desta parte.
        Path arquivo = Path.of("mensagem.txt");

        try {
            List<String> linhas = Files.readAllLines(arquivo);

            IO.println("=== Conteúdo de mensagem.txt ===");
            for (String linha : linhas) {
                IO.println(linha);
            }
            IO.println("================================");
            IO.println("Total de linhas: " + linhas.size());
        } catch (IOException e) {
            IO.println("Erro ao ler o arquivo: " + e.getMessage());
            IO.println("Dica: rode primeiro a parte1_1 para criar o arquivo.");
        }
    }
}
