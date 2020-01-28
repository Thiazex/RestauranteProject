package sample;

public class Prato {
    private String nome;
    private String[] ingredientes;
    private Double valorPrato;



public Prato(String nome, Double valorPrato){

    this.nome = nome;
    this.valorPrato = valorPrato;
}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String[] getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String[] ingredientes) {
        this.ingredientes = ingredientes;
    }

    public Double getValorPrato() {
        return valorPrato;
    }

    public void setValorPrato(Double valorPrato) {
        this.valorPrato = valorPrato;
    }

    public String getTipoPrato() {
        return tipoPrato;
    }

    public void setTipoPrato(String tipoPrato) {
        this.tipoPrato = tipoPrato;
    }

    private String tipoPrato;

    public Double getValor() {
        return this.valorPrato;
    }



}
