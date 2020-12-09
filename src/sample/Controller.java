package sample;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import sample.buscador.Buscador;
import sample.buscador.Alimento;
import sample.lista.AlimentoItem;
import sample.lista.AlimentoListViewCell;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.text.MessageFormat;
import java.util.Optional;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    //Tabla buscador
    @FXML private TableView <Buscador>tabla_buscador;
    //Columnas buscador
    @FXML private TableColumn<Buscador,String>c_nombre;
    @FXML private TableColumn<Buscador,String>c_tipo;
    @FXML private TableColumn<Buscador,Number>c_calorias;
    @FXML private TableColumn<Buscador, String> c_accion;
    //Lista buscador
    private ObservableList<Buscador>lista_buscador;
    //Textfield buscador
    @FXML private TextField buscadorInput;
    //json
    String ruta_json="resources\\alimentos.json";
    JsonReader rdr;
    private JsonObject obj;

    @FXML private ListView<AlimentoItem> lista_alimentos;
    @FXML private Button add_alimento;
    private ObservableList<AlimentoItem> alimentoObservableList;

    public Controller(){
        alimentoObservableList = FXCollections.observableArrayList();
    }

    /* Método para añadir un nuevo alimento a la lista de alimentos seleccionados*/
    public boolean addAlimento(Alimento alimento) {
        TextInputDialog dialog = new TextInputDialog("0");
        dialog.setHeaderText("Introduce los gramos de "+alimento.getNombre());
        dialog.setTitle("Alimento: "+alimento.getNombre());
        dialog.setContentText("Gramos: ");

        Optional<String> result = dialog.showAndWait();

        String s = result.map(r -> {
            try {
                Float n = Float.valueOf(r);
                alimentoObservableList.add(new AlimentoItem(alimento, (r+"gr")));
                return "valid";
            } catch (NumberFormatException ex) {
                return "error";
            }
        }).orElse("cancel");

        if (s.equals("valid")) return true;
        else return false;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        /* Añadir alimentos a la lista*/
        lista_alimentos.setItems(alimentoObservableList);

        /*Buscar alimentos en el json*/
        buscadorInput.setOnKeyTyped(event -> {
            buscarAlimento();
        });

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
        /*Añadir alimentos al buscador*/
        llenarTablaBuscador();
    }

    public void llenarTablaBuscador() {
        lista_buscador=FXCollections.observableArrayList();
        try {
            rdr = Json.createReader(new FileReader(ruta_json));
            obj = rdr.readObject();
            JsonObject platillo;

            //Iterar cada tipo de alimento consiguiendo todos las llaves del json/
            for(String tipo_plato: obj.keySet()){
                platillo = (JsonObject) obj.get(tipo_plato);
                // Iterar sobre cada alimento consiguiente todas la llaves/
                for(String alimento2 : platillo.keySet() ){
                    // Conseguir cada valor de alimento
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
                        if (empty) {
                            setGraphic(null);
                            setText(null);
                        }
                        else{
                            final Button entregar= new Button(" + ");
                            entregar.setOnAction(event -> {

                                Buscador b=getTableView().getItems().get(getIndex());
                                try {
                                    //Accion del boton
                                    Alimento alimento = new Alimento(b.getNombre(),b.getCalorias(),b.getTipo());
                                    if(addAlimento(alimento)){
                                        // Eliminar si se ha agregado a la lista
                                        getTableView().getItems().remove(getIndex());
                                    } else {
                                        System.out.println("Cancelado");
                                    }
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
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /* Método que filtra los alimentos disponibles de acuerdo a
    las letras tipeadas en el buscador */
    public void buscarAlimento() {
        tabla_buscador.getItems().clear();
        lista_buscador.removeAll();
        String textInput = buscadorInput.getText().toLowerCase();
        JsonObject platillo;
        Boolean ok = true;
        //Iterar cada tipo de alimento consiguiendo todos las llaves del json/
        for(String tipo_plato: obj.keySet()){
            platillo = (JsonObject) obj.get(tipo_plato);
            // Iterar sobre cada alimento consiguiente todas la llaves/
            for(String alimento2 : platillo.keySet() ){
                // Conseguir caada valor de alimento
                String alimento3 = alimento2.toLowerCase();
                ok=true;
                int i = 0;
                int size = textInput.length();
                while (i<size){
                    char letra_al = alimento3.charAt(i);
                    char letra_in = textInput.charAt(i);
                    if(letra_al != letra_in){
                        ok=false;
                        break;
                    }
                    i++;
                }

                // Si las letras de la búsqueda coinciden, se añade el alimento
                // a la lista
                if (ok)
                {
                    Buscador buscador = new Buscador(
                            alimento2,tipo_plato,
                            Float.parseFloat(String.valueOf(platillo.get(alimento2))));
                    lista_buscador.add(buscador);
                    tabla_buscador.setItems(lista_buscador);
                }
            }
        }
    }
}


