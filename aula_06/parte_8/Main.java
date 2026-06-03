package aula_06.parte_8;

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

        // 1) Carrega a lista
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

        // 2) Procura a conta a remover
        String alvo = "Carla";
        Conta paraRemover = null;

        for (Conta conta : contas) {
            if (conta.getTitular().equalsIgnoreCase(alvo)) {
                paraRemover = conta;
                break;
            }
        }

        if (paraRemover == null) {
            IO.println("Conta '" + alvo + "' não encontrada. Nada a remover.");
            return;
        }

        contas.remove(paraRemover);
        IO.println("Conta '" + alvo + "' removida da lista em memória.");

        // 3) Reescreve o arquivo SEM a conta removida.
        //    Em arquivos texto simples, não dá para "apagar uma linha":
        //    nós tiramos da lista e gravamos o arquivo de novo, do zero.
        try (FileWriter writer = new FileWriter(arquivo.toFile())) {
            for (Conta conta : contas) {
                writer.write(conta.paraLinha() + "\n");
            }
            IO.println("Arquivo reescrito sem a conta removida.");
            IO.println("Total de contas no arquivo agora: " + contas.size());
        } catch (IOException e) {
            IO.println("Erro ao salvar: " + e.getMessage());
        }
    }
}
