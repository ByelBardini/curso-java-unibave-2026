package aula_06.parte_6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {

    void main() {
        List<Conta> contas = new ArrayList<>();

        // 1) Carrega a lista do arquivo
        try {
            for (String linha : Files.readAllLines(Path.of("contas.txt"))) {
                String[] partes = linha.split(";");
                contas.add(new Conta(partes[0], Double.parseDouble(partes[1])));
            }
        } catch (IOException e) {
            IO.println("Erro ao carregar: " + e.getMessage());
            IO.println("Dica: rode primeiro a parte4_1 para gerar 'contas.txt'.");
            return;
        }

        // 2) Busca pelo nome do titular
        String alvo = "Ana";
        Conta encontrada = null;

        for (Conta conta : contas) {
            if (conta.getTitular().equalsIgnoreCase(alvo)) {
                encontrada = conta;
                break;
            }
        }

        // 3) Exibe o resultado
        if (encontrada != null) {
            IO.println("Conta encontrada!");
            IO.println("Titular: " + encontrada.getTitular());
            IO.println("Saldo:   R$ " + encontrada.getSaldo());
        } else {
            IO.println("Nenhuma conta encontrada com o titular '" + alvo + "'.");
        }
    }
}
