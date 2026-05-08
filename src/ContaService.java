import java.util.ArrayList;

public class ContaService {
    private ArrayList<Movimentacao> movimentacoes = new ArrayList<>();
    private double totalSacadoHoje;

    
    public void sacar(double valor, ContaCliente conta) {
        if (valor > conta.getSaldo()) {
            System.out.println("Saldo insuficiente!!");
            return;
        }
        if(this.totalSacadoHoje + valor > 1000){
            System.out.println("Limite diario atingido!");
            return;
        }
        double novoSaldo = conta.getSaldo() - valor;
        conta.setSaldo(novoSaldo);
        movimentacoes.add(new Movimentacao("SAQUE", valor));
        totalSacadoHoje += valor;
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

}
