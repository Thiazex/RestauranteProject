package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static sample.ControllerPrincipal.notificaOuvintes;

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
    private ComboBox<Prato> comboBoxPedidoAtual = new ComboBox<Prato>();
    private List<Prato> pratos = new ArrayList<>();
    ObservableList<Prato> obsPedido;

    @FXML
    private ComboBox<Funcionario> comboBoxGarçom = new ComboBox<Funcionario>();
    private List<Funcionario> garcons = new ArrayList<Funcionario>();
    ObservableList<Funcionario> obsGarcons;

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

    Mesa mesa = new Mesa(1,1);


    @FXML
    public void initialize(){

        ControllerPrincipal.addMudaTela(new ControllerPrincipal.ObsMudaTela() {
            @Override
            public void mudaTela(Object objetoQualquer) {
                mesa = ((Mesa) objetoQualquer);
            }


        });

        carregarPratos();
        carregarGargons();



    }

    public void carregarGargons(){
        Funcionario func1 = new Funcionario("Thiago", 18, "4002-8922");
        Funcionario func2 = new Funcionario("Liryel", 33, "99558877");
        Funcionario func3 = new Funcionario("Neto", 21, "99559877");
        Funcionario func4 = new Funcionario("Jorge", 34, "99553877");
        Funcionario func5 = new Funcionario("Maria", 60, "99557817");
        Funcionario func6 = new Funcionario("Karol", 18, "98768877");
        Funcionario func7 = new Funcionario("Toto", 19, "99928708");

        garcons.add(func1);
        garcons.add(func2);
        garcons.add(func3);
        garcons.add(func4);
        garcons.add(func5);
        garcons.add(func6);
        garcons.add(func7);

        obsGarcons = FXCollections.observableArrayList((garcons));

        comboBoxGarçom.setItems(obsGarcons);
    }
    public void carregarPratos(){
        Prato prato1 = new Prato("Macarrão com carne muída", 19.00);
        Prato prato2 = new Prato("Macarrão com carne suína", 23.00);
        Prato prato3 = new Prato("Macarrão com camarão", 27.00);
        Prato prato4 = new Prato("Macarrão com frango desfiado", 20.00);
        Prato prato5 = new Prato("Macarronada", 15.00);
        Prato prato6 = new Prato("Lasanha", 17.00);

        pratos.add(prato1);
        pratos.add(prato2);
        pratos.add(prato3);
        pratos.add(prato4);
        pratos.add(prato5);
        pratos.add(prato6);

        obsPedido = FXCollections.observableArrayList((pratos));
        comboBoxPedidoAtual.setItems(obsPedido);
    }

    public void setButtonAdicionar(javafx.event.ActionEvent actionEvent) throws Exception {
        mesa.getComanda().getPedidos().add(comboBoxPedidoAtual.getSelectionModel().getSelectedItem());
        mesa.getComanda().setFuncionario(comboBoxGarçom.getSelectionModel().getSelectedItem());
        mesa.abrirMesa(comboBoxPedidoAtual.getSelectionModel().getSelectedItem(), comboBoxGarçom.getSelectionModel().getSelectedItem());
        buttonAdicionar.setText("Adicionado!");
        buttonAdicionar.setStyle("-fx-background-color: rgba(0, 255, 0, 0.5);");
    }

    public void setButtonEliminar(javafx.event.ActionEvent actionEvent) throws Exception{
        mesa.getComanda().getPedidos().remove(comboBoxPedidoAtual.getSelectionModel().getSelectedItem());
        buttonEliminar.setText("Eliminado!");
        buttonEliminar.setStyle("-fx-background-color: rgba(255, 0, 0, 0.5);");
    }

    public void setButtonEditarPedido(javafx.event.ActionEvent actionEvent) throws Exception{
        mesa.getComanda().setComentario(textAreaComentarios.getText());
        buttonEditarPedido.setText("Texto Editado!");
        buttonEditarPedido.setStyle("-fx-background-color: rgba(0, 255, 0, 0.5);");
    }

    public void setButtonFecharMesa(javafx.event.ActionEvent actionEvent) throws Exception{
        Stage stage1 = (Stage) buttonFecharMesa.getScene().getWindow();
        stage1.close();
        FXMLLoader load = new FXMLLoader(this.getClass().getResource("sample.fxml"));
        Parent root = load.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        notificaOuvintes(mesa);
        stage.show();
    }

    public void setButtonEnviarParaCozinha(javafx.event.ActionEvent actionEvent) throws Exception{
        buttonEnviarParaCozinha.setText("Enviado para cozinha!");
        buttonEditarPedido.setStyle("-fx-background-color: rgba(0, 255, 0, 0.5);");
    }


}
