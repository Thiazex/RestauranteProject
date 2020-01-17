package sample;


import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ControllerComanda {

    @FXML
    private TableView<?> tableViewComanda;

    @FXML
    private TableColumn<?, ?> tableColumnGarçom;

    @FXML
    private TableColumn<?, ?> tableColumnPedido;

    @FXML
    private TableColumn<?, ?> tableColumnValor;

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
}
