package revisao;

import java.io.*;
import java.util.*;

public class AlunoRepository {
    private LinkedHashMap<String, Aluno> alunos = new LinkedHashMap<>();
    private File file;

    public AlunoRepository(String path) {
        file = new File(path);
        load();
    }

    public synchronized boolean add(Aluno a) {
        if (alunos.values().stream().anyMatch(x -> x.getMatricula().equals(a.getMatricula()))) return false;
        alunos.put(a.getMatricula(), a);
        save();
        return true;
    }

    public synchronized Aluno findByName(String nome) {
        return alunos.values().stream().filter(a -> a.getNome().equalsIgnoreCase(nome)).findFirst().orElse(null);
    }

    public synchronized boolean removeByName(String nome) {
        String key = alunos.values().stream().filter(a -> a.getNome().equalsIgnoreCase(nome)).map(Aluno::getMatricula).findFirst().orElse(null);
        if (key == null) return false;
        alunos.remove(key);
        save();
        return true;
    }

    public synchronized List<Aluno> list() {
        return new ArrayList<>(alunos.values());
    }

    public synchronized void save() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(file))) {
            for (Aluno a : alunos.values()) {
                pw.println(a.toCSV());
            }
        } catch (IOException e) {
            System.err.println("Erro ao salvar alunos: " + e.getMessage());
        }
    }

    public synchronized void load() {
        if (!file.exists()) return;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                Aluno a = Aluno.fromCSV(line);
                if (a != null) alunos.put(a.getMatricula(), a);
            }
        } catch (IOException e) {
            System.err.println("Erro ao carregar alunos: " + e.getMessage());
        }
    }
}
