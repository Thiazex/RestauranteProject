package sample;

public class Pedido {
    private Prato prato;
    private Integer quantidade;

    public Double calculaPreco() {
        return this.prato.getValor() * this.quantidade;
    }
}
