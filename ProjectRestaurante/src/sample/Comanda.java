package sample;

public class Comanda {
    private Pedido[] pedidos;

    public Double calculaPreco() {
        Double total = Double.valueOf(0);

        for (int i=0; i<pedidos.length; i++) {
            Pedido um = pedidos[i];
            total+=um.calculaPreco();
        }

        return total;
    }
}
