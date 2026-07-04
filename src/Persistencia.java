import java.io.*;
import java.util.ArrayList;

public class Persistencia {
    private static final String ARQUIVO = "biblioteca.dat";

    public static void salvar(ArrayList<ItemBiblioteca> lista) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(ARQUIVO));
            out.writeObject(lista);
            out.close();
        } catch (IOException e) {
            System.out.println("Erro ao salvar. ");
        }
    }

    @SuppressWarnings("unchecked")
    public static ArrayList<ItemBiblioteca> carregar() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(ARQUIVO));
            ArrayList<ItemBiblioteca> lista = (ArrayList<ItemBiblioteca>) in.readObject();
            in.close();
            return lista;
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
