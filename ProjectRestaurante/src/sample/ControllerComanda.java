package sample;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.PropertyPermission;

public class ControllerComanda {

    @FXML
    private TableView<?> tableViewComanda;

    @FXML
    private TableColumn tableColumnGarçom = new TableColumn<>("GarçomHERE");

    @FXML
    private TableColumn tableColumnPedido = new TableColumn<>("PedidoHERE");

    @FXML
    private TableColumn tableColumnValor = new TableColumn<>("ValorHERE");

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
    public void initialize(){
        List pessoas = Arrays.asList(
                new Pessoa("Jorge", 12, "200-333"),
                new Pessoa("Caca", 22, "200-444")
        );
        tableColumnGarçom.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tableColumnPedido.setCellValueFactory(new PropertyValueFactory<>("contato"));
        tableColumnValor.setCellValueFactory(new PropertyValueFactory<>("contato"));
        tableViewComanda.setItems(FXCollections.observableArrayList(pessoas));

    }
}
