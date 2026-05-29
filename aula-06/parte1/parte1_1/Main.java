import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {

    void main() {
        // Cria (ou sobrescreve) o arquivo mensagem.txt na pasta desta parte.
        Path arquivo = Path.of("mensagem.txt");

        try {
            Files.write(arquivo, List.of(
                "Olá, mundo!",
                "Este é um arquivo criado em Java.",
                "Cada item da lista vira uma linha no arquivo."
            ));
            IO.println("Arquivo 'mensagem.txt' criado com sucesso!");
        } catch (IOException e) {
            IO.println("Erro ao escrever no arquivo: " + e.getMessage());
        }
    }
}
