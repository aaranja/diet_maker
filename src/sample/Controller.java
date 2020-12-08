package sample;
import javafx.beans.binding.Binding;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Callback;
import sample.buscador.Buscador;


import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    //Tabla buscador
    @FXML private TableView <Buscador>tabla_buscador;
    //Columnas buscador
    @FXML private TableColumn<Buscador,String>c_nombre;
    @FXML private TableColumn<Buscador,String>c_tipo;
    @FXML private TableColumn<Buscador,Number>c_calorias;
    @FXML private TableColumn c_accion;
    //Lista buscador
    private ObservableList<Buscador>lista_buscador;
    //json
    String ruta_json="resources\\alimentos.json";
    JsonReader rdr;





    @FXML private ListView<Alimento> lista_alimentos;
    @FXML private Button add_alimento;
    private ObservableList<Alimento> alimentoObservableList;

    public Controller(){
        alimentoObservableList = FXCollections.observableArrayList();
        alimentoObservableList.addAll(new Alimento("Papas", "500gr"));
    }

    /* Método para añadir un nuevo alimento a la lista de alimentos seleccionados*/
    public void addAlimento(ActionEvent e) {
        alimentoObservableList.add(new Alimento("Salchicha", "400gr"));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        /* Añadir alimentos a la lista*/
        lista_alimentos.setItems(alimentoObservableList);
        /* Darle propiedades a cada fila de la lista*/
        lista_alimentos.setCellFactory(alimentoListView -> {
            ListCell<Alimento> cell = new AlimentoListViewCell();

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
        /*Añadir alimentos al buscador*/
        llenarTablaBuscador();



    }
    public void llenarTablaBuscador()
    {
        lista_buscador=FXCollections.observableArrayList();
        try {
            rdr = Json.createReader(new FileReader(ruta_json));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        JsonObject obj = rdr.readObject();
        JsonObject platillo;

        //Iterar cada tipo de alimento consiguiendo todos las llaves del json/
        for(String tipo_plato: obj.keySet()){
            platillo = (JsonObject) obj.get(tipo_plato);
            // Iterar sobre cada alimento consiguiente todas la llaves/
            for(String alimento2 : platillo.keySet() ){
                // Conseguir caada valor de alimento
                Buscador buscador = new Buscador(
                        alimento2,tipo_plato,
                        Float.parseFloat(String.valueOf(platillo.get(alimento2))));
                lista_buscador.add(buscador);
            }
        }
        c_nombre.setCellValueFactory(new PropertyValueFactory<Buscador,String>("nombre"));
        c_tipo.setCellValueFactory(new PropertyValueFactory<Buscador,String>("tipo"));
        c_calorias.setCellValueFactory(new PropertyValueFactory<Buscador,Number>("calorias"));

        Callback<TableColumn<Buscador,String>, TableCell<Buscador,String>> cellFactory = (param) -> {
            final TableCell<Buscador,String> cell = new TableCell<Buscador,String>(){
                @Override
                public void updateItem(String item,boolean empty){
                    super.updateItem(item, empty);
                    if (empty)
                    {
                        setGraphic(null);
                        setText(null);
                    }
                    else{
                        final Button entregar= new Button(" + ");
                        entregar.setOnAction(event -> {
                            Buscador r=getTableView().getItems().get(getIndex());
                            try {
                                //Accion del boton
                                //Alimento alimento = new Alimento()

                            } catch(Exception e) {
                                e.printStackTrace();
                            }

                        });
                        setGraphic(entregar);
                        setText(null);
                    }

                }


            };
            return cell;
        };
        //Agregar boton a la celda

        c_accion.setCellFactory(cellFactory);
        //Ingresar datos a la tabla
        tabla_buscador.setItems(lista_buscador);



    }
}


