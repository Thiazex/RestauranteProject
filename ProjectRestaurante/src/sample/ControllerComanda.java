package sample;


import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
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

      //  textFieldTotal.setText(mesa.getPrato().getValor().toString());
        tableColumnGarçom.setCellValueFactory(new PropertyValueFactory<>("nomeGarçom")); // TODO
        tableColumnPedido.setCellValueFactory(new PropertyValueFactory<>("nomePrato")); //TODO
        tableColumnValor.setCellValueFactory(new PropertyValueFactory<>("valor")); //TODO
    }


    public void liberarMesa(javafx.event.ActionEvent actionEvent) throws IOException{
        Stage stage1 = (Stage) buttonLiberarMesa.getScene().getWindow();
        stage1.close();


        FXMLLoader load = new FXMLLoader(this.getClass().getResource("sample.fxml"));
        Parent root = load.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.show();
    }
    public void finalizarPedido(javafx.event.ActionEvent actionEvent) throws IOException{

    }
    public void aplicarDesconto(javafx.event.ActionEvent actionEvent) throws IOException{
        Double d = Double.parseDouble(textFieldTotal.getText());
        d*=0.1;
        textFieldTotal.setText(d.toString());
    }


    public void recebeMesa(Mesa mesa) {

        this.mesa = mesa;
        tableViewComanda.setItems(FXCollections.observableArrayList(mesa.getComanda().getPedidos()));
    }
}
