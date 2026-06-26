import java.util.Scanner;
public class Main {
    void main(){
        Scanner sc = new Scanner(System.in);

        int opcao;

        do {

            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Buscar");
            System.out.println("4 - Remover");
            System.out.println("0 - Sair");

            opcao = sc.nextInt();

        } while(opcao != 0);
    }
}