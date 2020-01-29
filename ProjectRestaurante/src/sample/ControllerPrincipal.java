package sample;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
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
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.rmi.server.ExportException;
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
    private ComboBox<Mesa> comboBoxOcupadas = new ComboBox<>();
    //  private List<Mesa> mesasOcupadas = new ArrayList<>();
    //    ObservableList<Mesa> obsMesasOcupadas;

    @FXML
    private ComboBox<Funcionario> comboBoxGarçom = new ComboBox<Funcionario>();
    private List<Funcionario> funcionarios = new ArrayList<>();
    ObservableList<Funcionario> obsFuncionario;

    @FXML
    private ComboBox<Prato> comboBoxPedido = new ComboBox<Prato>();
    private List<Prato> pratos = new ArrayList<>();
    ObservableList<Prato> obsPedido;

    @FXML
    private Button buttonAbrirMesa;

    @FXML
    private Button buttonReservarMesa;

    @FXML
    private Button buttonDesocuparMesa;


    public ControllerPrincipal() {
        mesas = new ArrayList<>();


    }

    private List<Mesa> mesas = new ArrayList<>();
    private List<Mesa> mesasOcupadas = new ArrayList<>();
    private List<Mesa> mesasReservadas = new ArrayList<>();

    private ObservableList<Mesa> obsMesas;
    private ObservableList<Mesa> obsMesasOcupadas;
    private ObservableList<Mesa> obsMesasReservadas;

    public void carregandoMesas() {

        Mesa mesa1 = new Mesa(1, 4);
        Mesa mesa2 = new Mesa(2, 4);
        Mesa mesa3 = new Mesa(3, 4);
        Mesa mesa4 = new Mesa(4, 4);
        Mesa mesa5 = new Mesa(6, 4);

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
    public void initialize() {

        carregandoMesas();

        Funcionario func1 = new Funcionario("Thiago", 18, "4002-8922");
        Funcionario func2 = new Funcionario("Liryel", 33, "99558877");
        Funcionario func3 = new Funcionario("Neto", 21, "99559877");
        Funcionario func4 = new Funcionario("Jorge", 34, "99553877");
        Funcionario func5 = new Funcionario("Maria", 60, "99557817");
        Funcionario func6 = new Funcionario("Karol", 18, "98768877");
        Funcionario func7 = new Funcionario("Toto", 19, "99928708");

        funcionarios.add(func1);
        funcionarios.add(func2);
        funcionarios.add(func3);
        funcionarios.add(func4);
        funcionarios.add(func5);
        funcionarios.add(func6);
        funcionarios.add(func7);

        Prato ped1 = new Prato("Camarão", 12.00);
        Prato ped2 = new Prato("Cachorro Quente", 3.00);
        Prato ped3 = new Prato("Macarrão", 8.00);

        pratos.add(ped1);
        pratos.add(ped2);
        pratos.add(ped3);

        obsPedido = FXCollections.observableArrayList((pratos));
        obsFuncionario = FXCollections.observableArrayList((funcionarios));
        comboBoxPedido.setItems(obsPedido);
        comboBoxGarçom.setItems(obsFuncionario);

    }


    public void abrirMesa(javafx.event.ActionEvent actionEvent) throws IOException {
        Stage stage1 = (Stage) buttonAbrirMesa.getScene().getWindow();
        stage1.close();

        listViewLivres.getItems().add(listViewLivres.getSelectionModel().getSelectedItem());
        listViewLivres.getItems().remove(listViewLivres.getSelectionModel().getSelectedItem());
        listViewLivres.getSelectionModel().getSelectedItem().setEstaLivre(false);

        FXMLLoader load = new FXMLLoader(this.getClass().getResource("Comandas.fxml"));
        Parent root = load.load();
        ControllerComanda control = load.getController();


        Mesa mesa = listViewLivres.getSelectionModel().getSelectedItem();

        mesa.abrirMesa(comboBoxPedido.getSelectionModel().getSelectedItem(), comboBoxGarçom.getSelectionModel().getSelectedItem());
        control.recebeMesa(mesa);
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();


    }


    public void reservarMesa2(javafx.event.ActionEvent actionEvent) throws IOException {
        listViewLivres.getSelectionModel().getSelectedItem().ocuparMesa(4);
        listViewReservado.getItems().add(listViewLivres.getSelectionModel().getSelectedItem());
        listViewLivres.getItems().remove(listViewLivres.getSelectionModel().getSelectedItem());
        listViewLivres.getSelectionModel().getSelectedItem().setEstaLivre(false);

    }

  //  public void receberMesa(Mesa mesa){
     //   listViewOcupadas.getItems().add(mesa);    }

}
