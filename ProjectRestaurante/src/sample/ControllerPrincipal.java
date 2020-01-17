package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ControllerPrincipal {

    @FXML
    private ListView<Mesa> listViewReservado;

    @FXML
    private ListView<Mesa> listViewLivres;

    @FXML
    private ListView<Mesa> listViewOcupadas;

    @FXML
    private ComboBox<Mesa> comboBoxOcupadas;

    @FXML
    private ComboBox<Funcionario> comboBoxGarçom = new ComboBox<Funcionario>();
    private List<Funcionario> funcionarios = new ArrayList<>();
    ObservableList<Funcionario> obsFuncionario;

    @FXML
    private ComboBox<?> comboBoxPedido;

    @FXML
    private Button buttonAbrirMesa;

    @FXML
    private Button buttonReservarMesa;

    @FXML
    private Button buttonDesocuparMesa;

    public ControllerPrincipal(){
        mesas = new ArrayList<>();


    }

    private List<Mesa> mesas = new ArrayList<>();
    private List<Mesa> mesasOcupadas = new ArrayList<>();

    private ObservableList<Mesa> obsMesas;
    private ObservableList<Mesa> obsMesasOcupadas;

    public void carregandoMesas(){
        Mesa mesa1 = new Mesa(1);
        Mesa mesa2 = new Mesa(2);
        Mesa mesa3 = new Mesa(3);
        Mesa mesa4 = new Mesa(4);
        Mesa mesa5 = new Mesa(10);

        mesas.add(mesa1);
        mesas.add(mesa2);
        mesas.add(mesa3);
        mesas.add(mesa4);
        mesas.add(mesa5);

        obsMesas = FXCollections.observableArrayList(mesas);
        obsMesasOcupadas = FXCollections.observableArrayList(mesasOcupadas);

        listViewLivres.setItems(obsMesas);
        listViewOcupadas.setItems(obsMesasOcupadas);
    }

    @FXML
    public void initialize(){
        carregandoMesas();
        Funcionario func1 = new Funcionario("João",12, "003-000");

        funcionarios.add(func1);
        obsFuncionario = FXCollections.observableArrayList((funcionarios));
        comboBoxGarçom.setItems(obsFuncionario);

    }



    public void abrirMesa(javafx.event.ActionEvent actionEvent) throws IOException {
        Stage stage1 = (Stage) buttonAbrirMesa.getScene().getWindow();
        stage1.close();

        FXMLLoader load = new FXMLLoader(this.getClass().getResource("Comandas.fxml"));
        Parent root = load.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
}
