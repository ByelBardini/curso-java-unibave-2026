import java.util.ArrayList;

public class Persistencia {

    // Nome do arquivo que armazenará os dados
    private static final String ARQUIVO = "biblioteca.txt";

    // =========================
    // SALVAR
    // =========================

    public static void salvar(
            ArrayList<ItemBiblioteca> acervo) {

    }

    // =========================
    // CARREGAR
    // =========================

    public static ArrayList<ItemBiblioteca> carregar() {

        ArrayList<ItemBiblioteca> acervo =
                new ArrayList<>();

        return acervo;
    }

    // =========================
    // CONVERSÃO PARA TEXTO
    // =========================

    private static String itemParaLinha(
            ItemBiblioteca item) {

        return "";
    }

    // =========================
    // CONVERSÃO PARA OBJETO
    // =========================

    private static ItemBiblioteca linhaParaItem(
            String linha) {

        return null;
    }
}