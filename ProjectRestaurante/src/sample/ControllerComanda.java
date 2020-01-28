package sample;


import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import java.io.IOException;

public class ControllerComanda {

    @FXML
    private TableView<Pedido> tableViewComanda;

    @FXML
    private Button buttonLiberarMesa;

    @FXML
    private Button buttonAplicarDesconto;

    @FXML
    private Button buttonFinalizarPedido;

    @FXML
    private TextField textFieldTotal;

    @FXML
    private TextField textFieldDesconto;

    @FXML
    private TableColumn<?, ?> tableColumnGarçom;

    @FXML
    private TableColumn<?, ?> tableColumnPedido;

    @FXML
    private TableColumn<?, ?> tableColumnValor;

    private Mesa mesa;

    @FXML
    public void initialize(){
        tableColumnGarçom.setCellValueFactory(new PropertyValueFactory<>("nomeGarcom")); // TODO
        tableColumnPedido.setCellValueFactory(new PropertyValueFactory<>("nomePrato")); //TODO
        tableColumnValor.setCellValueFactory(new PropertyValueFactory<>("valor")); //TODO
    }


    public void liberarMesa(javafx.event.ActionEvent actionEvent) throws IOException{

    }
    public void finalizarPedido(javafx.event.ActionEvent actionEvent) throws IOException{

    }
    public void aplicarDesconto(javafx.event.ActionEvent actionEvent) throws IOException{

    }

    public void recebeMesa(Mesa mesa) {
        this.mesa = mesa;
        tableViewComanda.setItems(FXCollections.observableArrayList(mesa.getComanda().getPedidos()));
    }
}
