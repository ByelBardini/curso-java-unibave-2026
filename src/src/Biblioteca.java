import java.util.ArrayList;

public class Biblioteca {

    private ArrayList<ItemBiblioteca> acervo;
    public Biblioteca() {
        acervo = Persistencia.carregar();
    }
    public void cadastrar(ItemBiblioteca item) {
        acervo.add(item);
        Persistencia.salvar(acervo);
    }
    public void listar() {
        if (acervo.isEmpty()) {
            System.out.println("Acervo vazio.");
            return;
        }
        for (ItemBiblioteca item : acervo) {
            System.out.println("====================");
            System.out.println(item);
            System.out.println("====================");
        }
    }
    public ItemBiblioteca buscar(String titulo) {
        for (ItemBiblioteca item : acervo) {
            if (item.getTitulo().equalsIgnoreCase(titulo)) {
                return item;
            }
        }
        return null;
    }
    public boolean remover(String titulo) {
        ItemBiblioteca item = buscar(titulo);
        if (item != null) {
            acervo.remove(item);
            Persistencia.salvar(acervo);
            return true;
        }
        return false;
    }
}