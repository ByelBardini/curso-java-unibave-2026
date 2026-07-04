import java.io.*;
import java.util.*;

public class Persistencia {

    private static final String ARQUIVO = "biblioteca.txt";

    public static void salvar(List<ItemBiblioteca> acervo) {

        try (BufferedWriter w = new BufferedWriter(new FileWriter(ARQUIVO))) {

            for (ItemBiblioteca i : acervo) {

                if (i instanceof Livro l) {
                    w.write("LIVRO;" + l.getTitulo() + ";" + l.getAutor() + ";" +
                            l.getIsbn() + ";" + l.getAno() + ";" +
                            l.isEmprestado() + ";" +
                            safe(l.getResponsavel()) + ";" +
                            l.getTotalEmprestimos());

                } else if (i instanceof Revista r) {
                    w.write("REVISTA;" + r.getTitulo() + ";" + r.getEditora() + ";" +
                            r.getNumeroEdicao() + ";" + r.getAno() + ";" +
                            r.isEmprestado() + ";" +
                            safe(r.getResponsavel()) + ";" +
                            r.getTotalEmprestimos());
                }

                w.newLine();
            }

        } catch (IOException e) {
            System.out.println("Erro ao salvar.");
        }
    }

    public static List<ItemBiblioteca> carregar() {

        List<ItemBiblioteca> acervo = new ArrayList<>();

        File f = new File(ARQUIVO);
        if (!f.exists()) return acervo;

        try (BufferedReader r = new BufferedReader(new FileReader(f))) {

            String linha;

            while ((linha = r.readLine()) != null) {

                String[] p = linha.split(";");

                if (p.length < 5) continue;

                ItemBiblioteca item;

                if (p[0].equals("LIVRO")) {
                    item = new Livro(p[1], p[2], p[3], Integer.parseInt(p[4]));
                } else {
                    item = new Revista(p[1], p[2], Integer.parseInt(p[3]), Integer.parseInt(p[4]));
                }

                boolean emp = p.length > 5 && Boolean.parseBoolean(p[5]);
                String resp = (p.length > 6 && !p[6].isBlank()) ? p[6] : null;
                int total = (p.length > 7) ? Integer.parseInt(p[7]) : 0;

                if (emp) {
                    item.emprestar(resp != null ? resp : "Sistema");
                }

                item.setTotalEmprestimos(total);

                acervo.add(item);
            }

        } catch (Exception e) {
            System.out.println("Erro ao carregar.");
        }

        return acervo;
    }

    private static String safe(String s) {
        return (s == null) ? "" : s;
    }
}