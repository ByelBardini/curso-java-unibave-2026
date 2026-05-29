import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {

    void main() {
        Path arquivo = Path.of("contas.txt");
        List<Conta> contas = new ArrayList<>();

        // 1) Carrega a lista de contas
        try {
            for (String linha : Files.readAllLines(arquivo)) {
                String[] partes = linha.split(";");
                contas.add(new Conta(partes[0], Double.parseDouble(partes[1])));
            }
        } catch (IOException e) {
            IO.println("Erro ao carregar: " + e.getMessage());
            IO.println("Dica: rode primeiro a parte4_1 para gerar 'contas.txt'.");
            return;
        }

        // 2) Busca pelo titular e altera o saldo
        String alvo = "Bruno";
        double novoSaldo = 9999.99;
        boolean editado = false;

        for (Conta conta : contas) {
            if (conta.getTitular().equalsIgnoreCase(alvo)) {
                conta.setSaldo(novoSaldo);
                editado = true;
                break;
            }
        }

        if (!editado) {
            IO.println("Conta '" + alvo + "' não encontrada. Nada a fazer.");
            return;
        }

        // 3) Salva a lista INTEIRA de volta no arquivo
        try (FileWriter writer = new FileWriter(arquivo.toFile())) {
            for (Conta conta : contas) {
                writer.write(conta.paraLinha() + "\n");
            }
            IO.println("Saldo de '" + alvo + "' atualizado para R$ " + novoSaldo);
            IO.println("Arquivo salvo com a lista inteira.");
        } catch (IOException e) {
            IO.println("Erro ao salvar: " + e.getMessage());
        }
    }
}
