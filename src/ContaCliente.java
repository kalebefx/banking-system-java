public class ContaCliente {
    private String nome;
    private String cpf;
    private double saldo;

    public void exibirDados(){
        System.out.println("NOME  :  " + nome + "\n" + "CPF  :  " + cpf + "\n" + "SALDO  :  " + saldo + "\n");
    }

    public ContaCliente(String nome, String cpf, double saldo) {
        this.nome = nome;
        this.cpf = cpf;
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Conta do Cliente " + nome + '\'' +
                ", cpf=" + cpf +
                ", saldo=" + saldo +
                '}';
    }
}
