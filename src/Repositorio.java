import java.io.*;
import java.util.*;

public class Repositorio {
    private List<Aluno> alunos;
    private final File file;

    public Repositorio() {
        this.file = new File("alunos.dat");
        load();
    }

    @SuppressWarnings("unchecked")
    private void load() {
        if (!file.exists()) {
            alunos = new ArrayList<>();
            return;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            Object obj = ois.readObject();
            if (obj instanceof List) {
                alunos = (List<Aluno>) obj;
            } else {
                alunos = new ArrayList<>();
            }
        } catch (Exception e) {
            System.err.println("Aviso: não foi possível carregar os dados, iniciando repositório vazio.");
            alunos = new ArrayList<>();
        }
    }

    private void save() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(alunos);
        } catch (IOException e) {
            System.err.println("Erro ao salvar dados: " + e.getMessage());
        }
    }

    public synchronized List<Aluno> listar() {
        return new ArrayList<>(alunos);
    }

    public synchronized List<Aluno> listarOrdenadoPorMediaDesc() {
        List<Aluno> copy = new ArrayList<>(alunos);
        copy.sort(Comparator.comparingDouble(Aluno::getMedia).reversed());
        return copy;
    }

    public synchronized boolean adicionar(Aluno a) {
        for (Aluno existing : alunos) {
            if (existing.getMatricula().equalsIgnoreCase(a.getMatricula())) {
                return false; // matrícula duplicada
            }
        }
        alunos.add(a);
        save();
        return true;
    }

    public synchronized List<Aluno> buscarPorNome(String nome) {
        List<Aluno> result = new ArrayList<>();
        for (Aluno a : alunos) {
            if (a.getNome().toLowerCase().contains(nome.toLowerCase())) {
                result.add(a);
            }
        }
        return result;
    }

    public synchronized boolean removerPorNome(String nome) {
        Iterator<Aluno> it = alunos.iterator();
        while (it.hasNext()) {
            Aluno a = it.next();
            if (a.getNome().equalsIgnoreCase(nome)) {
                it.remove();
                save();
                return true;
            }
        }
        return false;
    }

    // Estatísticas simples
    public synchronized int totalAlunos() {
        return alunos.size();
    }

    public synchronized long countAprovados() {
        return alunos.stream().filter(Aluno::isAprovado).count();
    }

    public synchronized long countReprovados() {
        return alunos.stream().filter(a -> !a.isAprovado()).count();
    }

    public synchronized OptionalDouble maiorMedia() {
        return alunos.stream().mapToDouble(Aluno::getMedia).max();
    }

    public synchronized OptionalDouble menorMedia() {
        return alunos.stream().mapToDouble(Aluno::getMedia).min();
    }
}
