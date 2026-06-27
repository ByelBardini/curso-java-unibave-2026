public class Main {
    public static void main(String[] args) {

        try{
            Alunos a1 = new Alunos("Alerrandro", 1640);
            Alunos a2 = new Alunos("João", 1641);
            Alunos a3 = new Alunos("Maria", 1642);

            a1.somarNotas(8, 7);
            separar();

            a2.somarNotas(8, 8);
            separar();

            a3.somarNotas(5.2, 9);
            separar();
        }catch (Exception e){
            System.out.println("Usuário não encontrado (erro)! ");
        }
    }

    public static void separar(){
        System.out.println("----------------------------");
    }
}
