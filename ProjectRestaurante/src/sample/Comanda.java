package sample;

import javafx.collections.ObservableList;

import java.util.ArrayList;
import java.util.List;

public class Comanda {
    private List<Pedido> pedidos;
    private Funcionario funcionario;
    private String comentario;

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }



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

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getComentario() {
        return this.comentario;
    }
}
