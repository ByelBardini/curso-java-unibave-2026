import java.util.Scanner;

void main() {
    Scanner sc = new Scanner(System.in);

    // -- ENTRADA DE DADOS (Nome, Idade, Saldo) --

    IO.print("Digite o nome: ");
    String nome = sc.nextLine();

    IO.print("Digite a idade: ");
    int idade = sc.nextInt();

    IO.print("Digite o saldo: ");
    double saldo = sc.nextDouble();

    // -- ENTRADA DE DADOS (Preço) --

    IO.print("Digite o preço do produto: ");
    double preco = sc.nextDouble();

    // -- ENTRADA DE DADOS (Quantidade de Parcelas) --

    IO.print("Digite a quantidade de parcelas: ");
    int qtdParcelas = sc.nextInt();

    // -- ENTRADA DE DADOS (Percentual de Desconto e Idade Mínima) --

    IO.print("Digite o percentual de desconto (%): ");
    double percentualDesconto = sc.nextDouble();
    percentualDesconto = percentualDesconto / 100; // Converter para decimal

    IO.print("Digite a idade mínima para compra: ");
    int idadeMinima = sc.nextInt();

    // -- VALOR MINIMO PARA DESCONTO --
    double valorMinimoDesconto = 1000;

    // VALIDAÇÃO QUANTIDADE DE PARCELAS
    if (qtdParcelas <= 0) {
        IO.println("Quantidade de parcelas inválida!");
        return;
    }

    // TODO: calcular desconto
    double desconto;
    desconto = preco * percentualDesconto;

    // TODO: se tem idade  					 (Se a idade dele é maior que a idade mínima)
    boolean temIdade = false;
    temIdade = idade >= idadeMinima;

    // TODO: verificar se tem desconto			 (saldo > 1000 OU idade < 18)
    boolean temDesconto = false;
    temDesconto = saldo >= 1000 || idade <= 18;

    // TODO: calcular preço final
    double precoFinal = 0;
    precoFinal = preco - desconto;

    // TODO: calcular troco
    double troco = 0;
    troco = saldo - precoFinal;

    // TODO: calcular valor da parcela
    double valorParcela = 0;
    valorParcela = precoFinal / qtdParcelas;

    // TODO: verificar saldo
    boolean temSaldo = false;
    temSaldo = saldo >= precoFinal || saldo >= valorParcela;

    // TODO: verificar se pode comprar
    boolean podeComprar = false;
    podeComprar = temSaldo && temIdade;

    IO.println("\nCliente: " + nome);
    IO.println("\nIdade: " + idade);
    IO.println("\nSaldo: R$ " + saldo);
    IO.println("\nPreço original: R$ " + preco);

    // TODO: mostrar desconto
    IO.println("Desconto: R$ " + desconto);

    // TODO: mostrar preço final
    IO.println("Preço Final: R$ " + precoFinal);

    // TODO: validar compra
    if(podeComprar){
        IO.println("Compra Aprovada!");
        IO.println("Troco: R$ " + troco);
    }else{
        IO.println("Compra não Aprovada!");
    }

    // TODO: loop de parcelas
    for(int i = 1; i <= qtdParcelas; i++){
        IO.println("Parcela "+i+": R$ " + valorParcela);
    }
}