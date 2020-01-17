package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

public class ControllerPedidos {
    @FXML
    private TableView<?> tableViewPedido;

    @FXML
    private TableColumn<?, ?> tableColumnMesa;

    @FXML
    private TableColumn<?, ?> tableColumnPedido;

    @FXML
    private TableColumn<?, ?> tableColumnGarçom;

    @FXML
    private TableColumn<?, ?> tableColumnHorario;

    @FXML
    private ComboBox<?> comboBoxPedidoAtual;

    @FXML
    private ComboBox<?> comboBoxGarçom;

    @FXML
    private Button buttonEliminar;

    @FXML
    private Button buttonAdicionar;

    @FXML
    private TextArea textAreaComentarios;

    @FXML
    private Button buttonEditarPedido;

    @FXML
    private Button buttonFecharMesa;

    @FXML
    private Button buttonEnviarParaCozinha;
}
