package sample;

public class Pedido {
    private Prato prato;
    private Integer quantidade;


    public Pedido(String nomePrato) {
        prato = new Prato();
        prato.setNome(nomePrato);
    }

    public Double calculaPreco() {
        return this.prato.getValor() * this.quantidade;
    }


    public String toString() {
        return prato.getNome().toString();
    }
}