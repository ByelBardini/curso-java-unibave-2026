import java.io.FileWriter;
import java.io.IOException;

public class GerenciadorArquivo {

    public static void salvar(Turma turma) {

        try {

            FileWriter writer = new FileWriter("alunos.txt");

            for (Aluno aluno : turma.getAlunos()) {

                writer.write(
                        aluno.getNome() + ";" +
                                aluno.getMatricula() + ";" +
                                aluno.getNota1() + ";" +
                                aluno.getNota2() + "\n"
                );

            }

            writer.close();

        } catch (IOException e) {
            System.out.println("Erro ao salvar.");
        }

    }
}