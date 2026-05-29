import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {

    void main() {
        Path arquivo = Path.of("conta.txt");

        try {
            // Lê todo o conteúdo do arquivo em uma única String
            String linha = Files.readString(arquivo).trim();

            // Quebra a linha pelo separador ";"
            String[] partes = linha.split(";");

            String titular = partes[0];
            double saldo = Double.parseDouble(partes[1]);

            // Reconstrói o objeto a partir do texto
            Conta conta = new Conta(titular, saldo);

            IO.println("Conta reconstruída a partir do arquivo:");
            IO.println("Titular: " + conta.getTitular());
            IO.println("Saldo:   R$ " + conta.getSaldo());
        } catch (IOException e) {
            IO.println("Erro ao ler o arquivo: " + e.getMessage());
            IO.println("Dica: rode primeiro a parte3_1 para gerar 'conta.txt'.");
        }
    }
}
