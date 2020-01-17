package sample;

public class Mesa {
    private Integer numeroMesa;
    private Integer numOcupantes;
    private boolean estaLivre = true;
    private Comanda comanda;
    private Integer capacidade;

    public Mesa(Integer numero){
        this.numeroMesa = numero;
    }

    public void ocuparMesa(int numOcupantes) {
        if (numOcupantes<=this.capacidade && estaLivre) {
            this.numOcupantes = numOcupantes;
            this.estaLivre = false;
            this.comanda = new Comanda();
        }
        else {
            return;
        }
    }

    public void desocuparMesa(double valorPago) {
        Double total = comanda.calculaPreco();
        if (valorPago>=total) {
            this.numOcupantes = 0;
            this.estaLivre = true;
            this.comanda = null;
        }
    }

    @Override
    public String toString(){
        return "Mesa "+this.numeroMesa.toString();
    }
}
