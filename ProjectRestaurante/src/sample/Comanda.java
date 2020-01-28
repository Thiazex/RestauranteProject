package sample;

import java.util.ArrayList;
import java.util.List;

public class Comanda {
    private List<Pedido> pedidos;

    public Comanda(){
        pedidos = new ArrayList<>();
    }

    public Double calculaPreco() {
        Double total = Double.valueOf(0);



        return total;
    }

    public void registrarPedido(Pedido novo) {
        pedidos.add(novo);
    }

    public List getPedidos() {
        return pedidos;
    }
}
