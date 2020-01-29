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

     Mesa mesa = new Mesa(0,7);


    @FXML
    public void initialize(){
        ControllerPrincipal.addMudaTela(new ControllerPrincipal.ObsMudaTela() {
            @Override
            public void mudaTela(Object objetoQualquer) {
                mesa = ((Mesa) objetoQualquer);
                tableColumnGarçom.setCellValueFactory(new PropertyValueFactory<>("nomeGarçom")); // TODO
                tableColumnPedido.setCellValueFactory(new PropertyValueFactory<>("nomePrato")); //TODO
                tableColumnValor.setCellValueFactory(new PropertyValueFactory<>("valor")); //TODO
                tableViewComanda.setItems(FXCollections.observableArrayList(mesa.getComanda().getPedidos()));
            }
        });
      //  textFieldTotal.setText(mesa.getPrato().getValor().toString());



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
        if(textFieldDesconto.getText().contains("ABCDE")) {
            Double d = Double.parseDouble(textFieldTotal.getText());
            d *= 0.9;
            textFieldTotal.setText(d.toString());
        }else{
            System.out.println("vrau");
        }
    }


    public void recebeMesa(Mesa mesa) {

        this.mesa = mesa;
        tableViewComanda.setItems(FXCollections.observableArrayList(mesa.getComanda().getPedidos()));
    }
}
