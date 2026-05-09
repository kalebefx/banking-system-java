public class Movimentacao {
    private String tipo;
    private double valor;

    public Movimentacao(String tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return tipo + " | R$ " + String.format("%.2f", valor);
    }
}
