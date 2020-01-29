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

    @FXML
    private Button buttonPedido;


    private List<Mesa> mesas = new ArrayList<>();
    private List<Mesa> mesasOcupadas = new ArrayList<>();
    private List<Mesa> mesasReservadas = new ArrayList<>();

    private ObservableList<Mesa> obsMesas;
    private ObservableList<Mesa> obsMesasOcupadas;
    private ObservableList<Mesa> obsMesasReservadas;

    public ControllerPrincipal() {
        mesas = new ArrayList<>();


    }

    private static ArrayList<ObsMudaTela> ouvintes = new ArrayList<ObsMudaTela>();

    public static interface ObsMudaTela {
        void mudaTela(Object objetoQualquer);
    }

    public static void addMudaTela(ObsMudaTela novoOuvinte) {
        ouvintes.add(novoOuvinte);
    }

    public static void notificaOuvintes(Object dado) {
        for (ObsMudaTela o : ouvintes) {
            o.mudaTela(dado);
        }
    }



    public void carregandoMesas() {

        Mesa mesa1 = new Mesa(1, 4);
        Mesa mesa2 = new Mesa(2, 4);
        Mesa mesa3 = new Mesa(3, 4);
        Mesa mesa4 = new Mesa(4, 4);
        Mesa mesa5 = new Mesa(5, 4);

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

    Mesa mesa = new Mesa(1,1);

    @FXML
    public void initialize() {
        carregandoMesas();
        ControllerPrincipal.addMudaTela(new ControllerPrincipal.ObsMudaTela() {
            @Override
            public void mudaTela(Object objetoQualquer) {
                mesa = ((Mesa) objetoQualquer);
                obsMesasOcupadas.add(mesa);
                System.out.println(mesa.getPrato());
                System.out.println(mesa.getComanda().getComentario());
                System.out.println(mesa.getComanda().getFuncionario());
            }

        });
    }




    public void abrirMesa(javafx.event.ActionEvent actionEvent) throws IOException {
        Stage stage1 = (Stage) buttonAbrirMesa.getScene().getWindow();
        stage1.close();

        listViewLivres.getItems().add(listViewLivres.getSelectionModel().getSelectedItem());
        listViewLivres.getItems().remove(listViewLivres.getSelectionModel().getSelectedItem());
        listViewLivres.getSelectionModel().getSelectedItem().setEstaLivre(false);

        FXMLLoader load = new FXMLLoader(this.getClass().getResource("Comandas.fxml"));
        Parent root = load.load();
       // ControllerComanda control = load.getController();


       // Mesa mesa = listViewLivres.getSelectionModel().getSelectedItem();

       // mesa.abrirMesa(comboBoxPedido.getSelectionModel().getSelectedItem(), comboBoxGarçom.getSelectionModel().getSelectedItem());
        //control.recebeMesa(mesa);
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        notificaOuvintes(listViewReservado.getSelectionModel().getSelectedItem());
        stage.show();


    }


    public void reservarMesa2(javafx.event.ActionEvent actionEvent) throws Exception {
        listViewLivres.getSelectionModel().getSelectedItem().ocuparMesa(4);
        listViewReservado.getItems().add(listViewLivres.getSelectionModel().getSelectedItem());
        listViewLivres.getItems().remove(listViewLivres.getSelectionModel().getSelectedItem());
        listViewLivres.getSelectionModel().getSelectedItem().setEstaLivre(false);

    }

    public void abrirPedido(javafx.event.ActionEvent actionEvent) throws Exception{
        Stage stage1 = (Stage) buttonPedido.getScene().getWindow();
        stage1.close();
        FXMLLoader load = new FXMLLoader(this.getClass().getResource("Pedidos.fxml"));
        Parent root = load.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        Mesa m = listViewReservado.getSelectionModel().getSelectedItem();
        notificaOuvintes(m);

        stage.show();
    }

  //  public void receberMesa(Mesa mesa){
     //   listViewOcupadas.getItems().add(mesa);    }

}
