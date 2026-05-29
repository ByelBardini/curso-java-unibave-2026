import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {

    void main() {
        // Para testar esta parte, edite 'contas.txt' manualmente
        // e adicione algumas linhas estranhas, por exemplo:
        //
        // Ana;1200.0
        // linha sem ponto e vírgula
        // Bruno;abc
        // ;500.0
        // Carla;3000.0
        //

        List<Conta> contas = new ArrayList<>();
        int linhasIgnoradas = 0;

        try {
            List<String> linhas = Files.readAllLines(Path.of("contas.txt"));

            for (String linha : linhas) {
                // 1) ignora linhas vazias
                if (linha.isBlank()) {
                    linhasIgnoradas++;
                    continue;
                }

                // 2) valida que tem exatamente duas partes
                String[] partes = linha.split(";");
                if (partes.length != 2) {
                    IO.println("Linha inválida (formato): " + linha);
                    linhasIgnoradas++;
                    continue;
                }

                // 3) tenta converter o saldo. Se falhar, ignora a linha.
                try {
                    String titular = partes[0];
                    double saldo = Double.parseDouble(partes[1]);
                    contas.add(new Conta(titular, saldo));
                } catch (NumberFormatException e) {
                    IO.println("Linha inválida (saldo não é número): " + linha);
                    linhasIgnoradas++;
                }
            }
        } catch (IOException e) {
            IO.println("Erro ao ler o arquivo: " + e.getMessage());
            IO.println("Dica: rode primeiro a parte4_1 para gerar 'contas.txt'.");
            return;
        }

        IO.println("");
        IO.println("Contas válidas carregadas: " + contas.size());
        IO.println("Linhas ignoradas:          " + linhasIgnoradas);
        for (Conta conta : contas) {
            IO.println("- " + conta.getTitular() + " | R$ " + conta.getSaldo());
        }
    }
}
