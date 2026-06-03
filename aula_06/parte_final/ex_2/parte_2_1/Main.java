package aula_06.parte_final.ex_2.parte_2_1;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Main {

    // Lê o arquivo e converte cada linha em um objeto Contato
    List<Contato> carregar(Path arquivo) {
        List<Contato> contatos = new ArrayList<>();
        // Se o arquivo não existir, retorna lista vazia (primeira execução)
        if (!Files.exists(arquivo)) return contatos;

        try {
            for (String linha : Files.readAllLines(arquivo)) {
                if (linha.isBlank()) continue;
                String[] partes = linha.split(";");
                // Ignora linhas com formato inválido (não têm exatamente 3 partes)
                if (partes.length != 3) continue;
                contatos.add(new Contato(partes[0], partes[1], partes[2]));
            }
        } catch (IOException e) {
            IO.println("Erro ao carregar agenda: " + e.getMessage());
        }
        return contatos;
    }

    // Grava a lista inteira no arquivo, sobrescrevendo o conteúdo anterior
    void salvar(Path arquivo, List<Contato> contatos) {
        try (FileWriter writer = new FileWriter(arquivo.toFile())) {
            for (Contato c : contatos) {
                writer.write(c.paraLinha() + "\n");
            }
        } catch (IOException e) {
            IO.println("Erro ao salvar agenda: " + e.getMessage());
        }
    }

    // Busca por nome ignorando maiúsculas/minúsculas; retorna null se não encontrar
    Contato buscar(List<Contato> contatos, String nome) {
        for (Contato c : contatos) {
            if (c.getNome().equalsIgnoreCase(nome)) return c;
        }
        return null;
    }

    // removeIf percorre a lista e remove todos os elementos que satisfazem a condição
    void remover(List<Contato> contatos, String nome) {
        contatos.removeIf(c -> c.getNome().equalsIgnoreCase(nome));
    }

    void main() {
        Path arquivo = Path.of("agenda.txt");

        // 1. Carrega a agenda do arquivo (começa vazia se não existir)
        List<Contato> agenda = carregar(arquivo);
        IO.println("Agenda carregada: " + agenda.size() + " contato(s).\n");

        // 2. Cadastra 3 novos contatos na lista em memória
        agenda.add(new Contato("Ana Silva", "(48) 99999-1111", "ana@email.com"));
        agenda.add(new Contato("Bruno Costa", "(48) 98888-2222", "bruno@email.com"));
        agenda.add(new Contato("Carla Souza", "(48) 97777-3333", "carla@email.com"));

        // 3. Lista todos os contatos
        IO.println("=== Contatos ===");
        for (Contato c : agenda) {
            IO.println(c.getNome() + " | " + c.getTelefone() + " | " + c.getEmail());
        }

        // 4. Busca um contato pelo nome (case-insensitive)
        IO.println("\nBuscando 'bruno costa'...");
        Contato encontrado = buscar(agenda, "bruno costa");
        if (encontrado != null) {
            IO.println("Encontrado: " + encontrado.getNome() + " | " + encontrado.getTelefone() + " | " + encontrado.getEmail());
        } else {
            IO.println("Contato não encontrado.");
        }

        // 5. Remove um contato da lista em memória
        IO.println("\nRemovendo 'Ana Silva'...");
        remover(agenda, "Ana Silva");

        // 6. Salva a lista atualizada no arquivo
        salvar(arquivo, agenda);
        IO.println("Agenda salva com " + agenda.size() + " contato(s).");
    }
}
