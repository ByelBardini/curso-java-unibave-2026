package aula_06.parte_4.parte_4_1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    void main() {
        // Monta uma lista de contas em memória
        List<Conta> contas = new ArrayList<>();
        contas.add(new Conta("Ana", 1200.00));
        contas.add(new Conta("Bruno", 850.50));
        contas.add(new Conta("Carla", 3000.00));

        // Grava todas em 'contas.txt', uma conta por linha
        try (FileWriter writer = new FileWriter("contas.txt")) {
            for (Conta conta : contas) {
                writer.write(conta.paraLinha() + "\n");
            }
            IO.println("Foram salvas " + contas.size() + " contas em 'contas.txt'.");
        } catch (IOException e) {
            IO.println("Erro ao salvar: " + e.getMessage());
        }
    }
}
