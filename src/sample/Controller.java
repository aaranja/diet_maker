package sample;
import javafx.beans.binding.Binding;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import sample.buscador.Alimento;
import sample.lista.AlimentoItem;
import sample.lista.AlimentoListViewCell;

import java.net.URL;
import java.text.MessageFormat;
import java.util.Optional;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML private ListView<AlimentoItem> lista_alimentos;
    @FXML private Button add_alimento;
    private ObservableList<AlimentoItem> alimentoObservableList;

    public Controller(){
        alimentoObservableList = FXCollections.observableArrayList();
        alimentoObservableList.addAll(new AlimentoItem(new Alimento("Papas", 200, "Tuberculo"), "500gr"));
    }

    /* Método para añadir un nuevo alimento a la lista de alimentos seleccionados*/
    public void addAlimento(ActionEvent e) {
        Alimento alimento = new Alimento("Papas", 200, "Tuberculo");

        alimentoObservableList.add(new AlimentoItem(alimento, "500gr"));
        TextInputDialog dialog = new TextInputDialog("0");
        dialog.setHeaderText("Introduce los gramos de "+alimento.getNombre());
        dialog.setTitle("Alimento: "+alimento.getNombre());
        dialog.setContentText("Gramos: ");

        Optional<String> result = dialog.showAndWait();

        String s = result.map(r -> {
            try {
                Integer n = Integer.valueOf(r);
                return MessageFormat.format("Nice! I like {0} too!", n);
            } catch (NumberFormatException ex) {
                return MessageFormat.format("Unfortunately \"{0}\" is not a int!", r);
            }
        }).orElse("You really don't want to tell me, huh?");

        System.out.println(s);

    }

    /* Método para inicializar el controlador una vez cargado los componentes */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        /* Añadir alimentos a la lista*/

        lista_alimentos.setItems(alimentoObservableList);
        /* Darle propiedades a cada fila de la lista*/
        lista_alimentos.setCellFactory(alimentoListView -> {
            ListCell<AlimentoItem> cell = new AlimentoListViewCell();

            /* Crear menu de alimento */
            ContextMenu contextMenu = new ContextMenu();

            /* Opción de menu editar gramos de alimento */
            MenuItem editGramos = new MenuItem();
            editGramos.textProperty().bind(Bindings.format("Editar gramos"));
            editGramos.setOnAction(event -> {
                System.out.println("Editar gramos");
            });

            /* Opción de menu eliminar alimento de la lista*/
            MenuItem eliminarAlimento = new MenuItem();
            eliminarAlimento.textProperty().bind(Bindings.format("Eliminar \"%s\"", cell.itemProperty()));
            eliminarAlimento.setOnAction(event -> lista_alimentos.getItems().remove(cell.getItem()));

            /* Añadir el menú a cada fila*/
            contextMenu.getItems().addAll(editGramos, eliminarAlimento);

            /* Quitar propiedad a una fila que se ha eliminado */
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


