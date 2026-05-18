import java.util.ArrayList;
import java.util.List;

void main() {
    List<Pessoa> pessoas = new ArrayList<>();

    pessoas.add(new Pessoa("Ana", 20));
    pessoas.add(new Pessoa("Carlos", 25));
    pessoas.add(new Pessoa("Marina", 19));

    IO.println("Pessoas cadastradas:");

    for (Pessoa pessoa : pessoas) {
        pessoa.exibirDados();
    }
}
