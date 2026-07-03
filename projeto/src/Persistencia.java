package projeto.src;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Persistencia {
    private static final String ARQUIVO = "alunos.dat";


    public static List<Aluno> carregar() {
        File f = new File(ARQUIVO);
        if (!f.exists()) return new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
            return (List<Aluno>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("[Aviso] Não foi possível carregar os dados: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public static void salvar(List<Aluno> alunos) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARQUIVO))) {
            oos.writeObject(alunos);
        } catch (IOException e) {
            System.out.println("[Erro] Não foi possível salvar os dados: " + e.getMessage());
        }
    }
}

