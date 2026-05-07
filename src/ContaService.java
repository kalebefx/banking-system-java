import java.util.ArrayList;

public class ContaService {
    private ArrayList<Movimentacao> movimentacoes = new ArrayList<>();

    public double sacar(double valor,  double saldo){
        if(valor > saldo ){
            System.out.println("Saldo insuficiente!!");
            return saldo;
        }
        movimentacoes.add(new Movimentacao("SAQUE", valor));
        return saldo - valor;
    }

    public double depositar(double valor, double saldo){
        movimentacoes.add(new Movimentacao("DEPOSITO",valor));
        return saldo + valor;
    }
    public void puxarExtrato(){
        for (Movimentacao m : movimentacoes) {
            System.out.println(m);
        }
    }
}
