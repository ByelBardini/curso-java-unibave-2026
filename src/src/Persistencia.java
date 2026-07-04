package src.src;

import java.io.*;
import java.util.ArrayList;

public class Persistencia {

    private static final String ARQUIVO = "acervo.dat";

    // Salvar o acervo
    public static void salvar(ArrayList<livrosDisponiveis> acervo) {

        try {

            ObjectOutputStream out =
                    new ObjectOutputStream(new FileOutputStream(ARQUIVO));

            out.writeObject(acervo);

            out.close();

        } catch (IOException e) {

            System.out.println("Erro ao salvar os dados.");

        }

    }

    // Carregar o acervo
    @SuppressWarnings("unchecked")
    public static ArrayList<livrosDisponiveis> carregar() {

        File arquivo = new File(ARQUIVO);

        if (!arquivo.exists()) {

            return new ArrayList<>();

        }

        try {

            ObjectInputStream in =
                    new ObjectInputStream(new FileInputStream(ARQUIVO));

            ArrayList<livrosDisponiveis> acervo =
                    (ArrayList<livrosDisponiveis>) in.readObject();

            in.close();

            return acervo;

        } catch (IOException | ClassNotFoundException e) {

            System.out.println("Erro ao carregar os dados.");

            return new ArrayList<>();

        }

    }

}