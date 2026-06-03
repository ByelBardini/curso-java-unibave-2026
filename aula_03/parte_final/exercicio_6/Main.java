package aula_03.parte_final.exercicio_6;

public class Main {

    void main() {
        Carro c = new Carro();
        c.setModelo("Fusca");
        c.setAno(1972);

        IO.println("Modelo: " + c.getModelo());
        IO.println("Ano: " + c.getAno());
    }
}