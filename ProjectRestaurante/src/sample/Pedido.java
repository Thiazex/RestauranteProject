package sample;

public class Pedido {
    private Prato prato;
    private Integer quantidade;
    private Funcionario garcom;

    public String nomeGarcom;
    public String nomePrato;
    public String valor;

    public Pedido(Prato prato, Funcionario garcom) {
        this.prato = prato;
        this.garcom = garcom;

        nomeGarcom = garcom.getNome();
        nomePrato = prato.getNome();
        valor = "0";
    }

    public Double calculaPreco() {
        return this.prato.getValor() * this.quantidade;
    }


    public String toString() {
        return prato.getNome();
    }



}