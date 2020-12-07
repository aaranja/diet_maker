package sample;
import javafx.beans.binding.Binding;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;


import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML private ListView<Alimento> lista_alimentos;
    @FXML private Button add_alimento;
    private ObservableList<Alimento> alimentoObservableList;

    public Controller(){
        alimentoObservableList = FXCollections.observableArrayList();
        alimentoObservableList.addAll(new Alimento("Papas", "500gr"));
    }

    public void addAlimento(ActionEvent e) {
        alimentoObservableList.add(new Alimento("Salchicha", "400gr"));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        lista_alimentos.setItems(alimentoObservableList);
        lista_alimentos.setCellFactory(alimentoListView -> {
            ListCell<Alimento> cell = new AlimentoListViewCell();

            ContextMenu contextMenu = new ContextMenu();

            MenuItem editGramos = new MenuItem();
            editGramos.textProperty().bind(Bindings.format("Editar gramos"));
            editGramos.setOnAction(event -> {
                System.out.println("Editar gramos");
            });

            MenuItem eliminarAlimento = new MenuItem();
            eliminarAlimento.textProperty().bind(Bindings.format("Eliminar \"%s\"", cell.itemProperty()));
            eliminarAlimento.setOnAction(event -> lista_alimentos.getItems().remove(cell.getItem()));

            contextMenu.getItems().addAll(editGramos, eliminarAlimento);

            cell.emptyProperty().addListener((obs, wasEmpty, isNowEmpty) -> {
                if (isNowEmpty){
                    cell.setContextMenu(null);
                } else {
                    cell.setContextMenu(contextMenu);
                }
            });

            return cell;
        });
    }
}


