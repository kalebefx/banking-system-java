import java.util.ArrayList;

public class ContaService {
    private ArrayList<Movimentacao> movimentacoes = new ArrayList<>();
    private double totalSacadoHoje;


    public boolean sacar(double valor, ContaCliente conta) {
        if (valor > conta.getSaldo()) {
            System.out.println("Saldo insuficiente!!");
            return false;
        }
        if(this.totalSacadoHoje + valor > 1000){
            System.out.println("Limite diario atingido!");
            return false;
        }
        double novoSaldo = conta.getSaldo() - valor;
        conta.setSaldo(novoSaldo);
        movimentacoes.add(new Movimentacao("SAQUE", valor));
        totalSacadoHoje += valor;
        return true;
    }


    public void depositar(double valor, ContaCliente conta) {
        double novoSaldo = conta.getSaldo() + valor;
        conta.setSaldo(novoSaldo);
        movimentacoes.add(new Movimentacao("DEPOSITO", valor));
    }


    public void puxarExtrato(){
        for (Movimentacao m : movimentacoes) {
            System.out.println(m);
        }
    }


    public void transferir(double valor, ContaCliente origem, ContaCliente destino){
        sacar(valor,origem);
        depositar(valor,destino);
    }
}
