package aula_06.parte_4.parte_4_2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {

    void main() {
        List<Conta> contas = new ArrayList<>();

        try {
            // Lê o arquivo inteiro, uma String por linha
            List<String> linhas = Files.readAllLines(Path.of("contas.txt"));

            // Para cada linha, reconstrói uma Conta
            for (String linha : linhas) {
                String[] partes = linha.split(";");
                String titular = partes[0];
                double saldo = Double.parseDouble(partes[1]);
                contas.add(new Conta(titular, saldo));
            }
        } catch (IOException e) {
            IO.println("Erro ao ler o arquivo: " + e.getMessage());
            IO.println("Dica: rode primeiro a parte4_1 para gerar 'contas.txt'.");
            return;
        }

        IO.println("=== Contas carregadas de contas.txt ===");
        for (Conta conta : contas) {
            IO.println("- " + conta.getTitular() + " | R$ " + conta.getSaldo());
        }
        IO.println("Total: " + contas.size() + " contas.");
    }
}
