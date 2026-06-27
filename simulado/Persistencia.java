import java.io.*;
import java.util.ArrayList;
public class Persistencia {

    private static final String ARQUIVO = "alunos.txt";

    public static void salvar(ArrayList<Aluno> alunos) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ARQUIVO))) {
            alunos.sort((a1, a2) ->
                    Double.compare(a2.getMedia(), a1.getMedia()));
            for (Aluno aluno : alunos) {
                writer.write(
                        aluno.getNome() + ";" +
                                aluno.getMatricula() + ";" +
                                aluno.getNota1() + ";" +
                                aluno.getNota2()
                );
                writer.newLine();
            }
    } catch (IOException e) {
        System.out.println("Erro ao salvar os dados.");
        }
    }

    public static ArrayList<Aluno> carregar() {

        ArrayList<Aluno> alunos = new ArrayList<>();

        File arquivo = new File(ARQUIVO);

        if (!arquivo.exists()) {
            return alunos;
        }

        try (BufferedReader reader =
                     new BufferedReader(
                             new FileReader(ARQUIVO))) {

            String linha;

            while ((linha = reader.readLine()) != null) {

                String[] dados = linha.split(";");

                String nome = dados[0];
                String matricula = dados[1];

                double nota1 =
                        Double.parseDouble(dados[2]);

                double nota2 =
                        Double.parseDouble(dados[3]);

                alunos.add(
                        new Aluno(
                                nome,
                                matricula,
                                nota1,
                                nota2
                        )
                );
            }

        } catch (IOException e) {
            System.out.println("Erro ao carregar os dados.");
        }

        return alunos;
    }
}


