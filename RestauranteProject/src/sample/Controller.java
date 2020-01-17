package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

public class Controller {

    @FXML
    private ListView<?> listViewReservado;

    @FXML
    private ListView<?> listViewLivres;

    @FXML
    private ListView<?> listViewOcupadas;

    @FXML
    private ComboBox<?> comboBoxOcupadas;

    @FXML
    private ComboBox<?> comboBoxGarçom;

    @FXML
    private ComboBox<?> comboBoxPedido;

    @FXML
    private Button buttonAbrirMesa;

    @FXML
    private Button buttonReservarMesa;

    @FXML
    private Button buttonDesocuparMesa;
}
