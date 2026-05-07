import java.util.Scanner;
import java.util.InputMismatchException;


public class Principal {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Digite seu nome completo:  ");
        String nome = input.next();
        System.out.println("Digite seu CPF: ");
        String cpf = input.next();
        System.out.println("Digite seu Saldo: ");
        double saldo = input.nextDouble();

        ContaCliente conta = new ContaCliente(nome, cpf, saldo);
        System.out.println(conta);

        ContaService acao = new ContaService();

        System.out.println("Seja Bem vindo " + nome);
        boolean rodando = true;
        while (rodando){
            int escolha;
            System.out.println("--------------------------");
            System.out.println("""
                    1 : DEPOSITAR
                    2 : SAQUE
                    3 : EXTRATO
                    4 : SAIR
                    """);
            System.out.println("--------------------------");
            System.out.println("ESCOLHA UMA OPÇÃO");
            escolha = input.nextInt();
            double saldoAtual;
            while (escolha < 1 || escolha > 4) {
                System.out.println("Opção inválida! Digite de 1 a 4: ");
                escolha = input.nextInt();
            }
            switch (escolha) {
                case 1:
                        System.out.println("Digite o valor que você quer depositar: ");
                        double b = input.nextDouble();
                         saldo = acao.depositar(b, saldo);
                        System.out.println("Valor " + b + "retidado de seu saque. "+ "Saldo atual: " + saldo );
                    break;
                case 2:
                        System.out.println("Digite o valor que você quer sacar: ");
                        double a = input.nextDouble();
                        saldo = acao.sacar(a, saldo);
                        System.out.println("Depósito de R$ " + a + " realizado! Saldo atual: " + saldo);
                    break;
                case 3:
                    System.out.println("---SEU EXTRATO---");
                    acao.puxarExtrato();
                    break;
                case 4:
                    rodando = false;
                    break;
            }




        }







    }
}