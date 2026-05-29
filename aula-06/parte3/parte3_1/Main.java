import java.io.FileWriter;
import java.io.IOException;

public class Main {

    void main() {
        Conta conta = new Conta("João", 1500.50);

        try (FileWriter writer = new FileWriter("conta.txt")) {
            writer.write(conta.paraLinha());

            IO.println("Conta salva em 'conta.txt' no formato titular;saldo:");
            IO.println(conta.paraLinha());
        } catch (IOException e) {
            IO.println("Erro ao salvar: " + e.getMessage());
        }
    }
}
