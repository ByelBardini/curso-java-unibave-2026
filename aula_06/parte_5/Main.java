package aula_06.parte_5;

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

        // 1) Ao iniciar, tenta carregar o arquivo
        if (Files.exists(arquivo)) {
            IO.println("Arquivo encontrado. Carregando contas...");
            try {
                for (String linha : Files.readAllLines(arquivo)) {
                    String[] partes = linha.split(";");
                    String titular = partes[0];
                    double saldo = Double.parseDouble(partes[1]);
                    contas.add(new Conta(titular, saldo));
                }
            } catch (IOException e) {
                IO.println("Erro ao carregar: " + e.getMessage());
            }
        } else {
            IO.println("Arquivo não existe. Começando com lista vazia.");
        }

        IO.println("Contas carregadas: " + contas.size());

        // 2) Cadastra uma nova conta
        Conta nova = new Conta("Diego", 500.00);
        contas.add(nova);
        IO.println("Nova conta cadastrada: " + nova.getTitular());

        // 3) Salva a lista inteira novamente
        try (FileWriter writer = new FileWriter(arquivo.toFile())) {
            for (Conta conta : contas) {
                writer.write(conta.paraLinha() + "\n");
            }
            IO.println("Arquivo salvo. Total de contas agora: " + contas.size());
        } catch (IOException e) {
            IO.println("Erro ao salvar: " + e.getMessage());
        }
    }
}
