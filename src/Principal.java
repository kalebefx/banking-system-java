import java.util.Scanner;
import java.util.InputMismatchException;


public class Principal {

    public static void main(String[] args) throws Exception{
        Scanner input = new Scanner(System.in);
        System.out.println("CADASTRE SUA PRIMEIRA CONTA");
        System.out.println("Digite seu nome completo:  ");
        String nome = input.nextLine();
        while (!nome.matches("[a-zA-ZÀ-ú\\s]+")){
            System.out.println("Erro: não pode ter numeros. Digite novamente: ");
            nome = input.nextLine();
        }

        System.out.println("Digite seu CPF: ");
        String cpf = input.next();
        while (!cpf.matches("\\d{11}")){
            System.out.println("Erro: CPF so poder ter numeros. Digite novamente: ");
            cpf = input.next();
        }

        System.out.println("Digite seu Saldo: ");
        String saldoStr = input.next();
        while (!saldoStr.matches("\\d+(\\.\\d{1,2})?")) {
            System.out.println("Formato de saldo inválido! Use apenas números (ex: 1500.50). Digite novamente: ");
            saldoStr = input.next();
        }
        double saldo = Double.parseDouble(saldoStr);
        input.nextLine();
        ContaCliente conta = new ContaCliente(nome, cpf, saldo);

        System.out.println("CADASTRE SUA SEGUNDA CONTA");
        System.out.println("Digite seu nome completo:  ");
        String nome2 = input.nextLine();
        while (!nome2.matches("[a-zA-ZÀ-ú\\s]+")){
        System.out.println("Erro: não pode ter numeros. Digite novamente: ");
        nome2= input.nextLine();
        }

        System.out.println("Digite seu CPF: ");
        String cpf2 = input.next();
        while (!cpf2.matches("\\d{11}")){
        System.out.println("Erro: CPF so poder ter numeros. Digite novamente: ");
        cpf2 = input.next();
        }

        System.out.println("Digite seu Saldo: ");
        String saldoStr2 = input.next();
        while (!saldoStr2.matches("\\d+(\\.\\d{1,2})?")) {
        System.out.println("Formato de saldo inválido! Use apenas números (ex: 1500.50). Digite novamente: ");
        saldoStr2 = input.next();
        }

        double saldo2 = Double.parseDouble(saldoStr2);

        input.nextLine();
        ContaCliente conta02 = new ContaCliente(nome2,cpf2,saldo2);
        ContaService acao = new ContaService();
        CotacaoService cotService = new CotacaoService();

        System.out.println("\nSeja Bem-vindo, " + nome + "!");
        boolean rodando = true;

        while (rodando){
            int escolha;
            System.out.println("--------------------------");
            System.out.println("""
                    1 : DEPOSITAR
                    2 : SAQUE
                    3 : TRANSFERÊNCIA
                    4 : EXTRATO
                    5 : EXIBIR DADOS
                    6 : COTAÇÃO DO DÓLAR
                    7 : SAIR
                    """);
            System.out.println("--------------------------");
            System.out.println("ESCOLHA UMA OPÇÃO");

            escolha = input.nextInt();

            while (escolha < 1 || escolha > 7) {
                System.out.println("Opção inválida! Digite de 1 a 7: ");
                escolha = input.nextInt();
            }

            switch (escolha) {
                case 1:
                    try {
                        System.out.println("Digite o valor que você quer depositar: ");
                        double b = input.nextDouble();
                        acao.depositar(b, conta);
                        System.out.println("Depósito de R$ " + b + " realizado! Saldo atual: " + conta.getSaldo());
                    } catch (InputMismatchException ss){
                        System.out.println("Erro: Entrada inválida. Por favor, use números (e vírgula para decimais).");
                        input.nextLine();
                    }
                    break;
                case 2:
                    try {
                        System.out.println("Digite o valor que você quer sacar: ");
                        double a = input.nextDouble();
                        boolean sacou = acao.sacar(a, conta);
                        if (sacou) {
                            System.out.println("Valor R$ " + a + " retirado. Saldo atual: " + conta.getSaldo());
                        }
                    } catch (InputMismatchException ss){
                        System.out.println("Erro: Entrada inválida. Por favor, use números (e vírgula para decimais).");
                        input.nextLine();
                    }
                    break;
                case 3:
                    System.out.println("Digite o valor para transferir: ");
                    double valorTransferencia = input.nextDouble();
                    acao.transferir(valorTransferencia,conta,conta02);
                    break;
                case 4:
                    System.out.println("---SEU EXTRATO---");
                    acao.puxarExtrato();
                    break;
                case 5:
                    conta.exibirDados();
                    conta02.exibirDados();
                    break;
                case 6:
                    cotService.buscarCotacao();
                    break;
                case 7:
                    System.out.println("Encerrando programa...");
                    rodando = false;
                    break;
            }
        }
        input.close();
    }
}


