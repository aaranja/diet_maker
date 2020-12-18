package sample;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import sample.buscador.Alimento;
import sample.seleccionado.AlimentoItem;
import sample.user.CrearDieta;
import sample.user.DataUser;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicReference;

public class Controller implements Initializable {
    public TableColumn<AlimentoItem, String> a_nombre;
    public TableColumn<AlimentoItem, String> a_tipo;
    public TableColumn<AlimentoItem, Number> a_calorias;
    public TableColumn<AlimentoItem, Number> a_carbohidratos;
    public TableColumn<AlimentoItem, Number> a_proteinas;
    public TableColumn<AlimentoItem, Number> a_lipidos;
    public TableColumn<AlimentoItem, String> a_gramos;
    public TableColumn<AlimentoItem, Number> a_cantidad;
    public TableColumn<AlimentoItem, String> a_unidad;
    public TableColumn<AlimentoItem, Number> a_peso_neto;
    public TabPane tab_total_alimentos;
    /* Tabla de selección de alimentos*/
    @FXML private TableView <Alimento>tabla_buscador;

    /* Tabla de alimentos seleccionados */
    @FXML private TableView <AlimentoItem> tabla_seleccionado;

    /* Datos de entrada del usuario */
    @FXML private TextField nombreInput;
    @FXML private TextField tallaInput;
    @FXML private Label alert_talla;
    @FXML private TextField alturaInput;
    @FXML private TextField edadInput;
    @FXML private TextField pesoInput;
    @FXML private ChoiceBox<String> generoSelected;
    private ObservableList<String> lista_genero = FXCollections.observableArrayList();

    /* Columnas de selección de alimento */
    @FXML private TableColumn<Alimento,String>c_nombre;
    @FXML private TableColumn<Alimento,String>c_tipo;
    @FXML private TableColumn<Alimento,Number>c_calorias;
    @FXML private TableColumn<Alimento,String>c_accion;
    @FXML private TableColumn<Alimento,Number>c_carbohidratos;
    @FXML private TableColumn<Alimento,Number>c_lipidos;
    @FXML private TableColumn<Alimento,Number>c_proteinas;
    public TableColumn<Alimento, Number> c_cantidad;
    public TableColumn<Alimento, String> c_unidad;
    public TableColumn<Alimento, Number> c_peso_neto;

    //Lista Alimento
    private ObservableList<Alimento>lista_buscador;
    //Textfield buscador
    @FXML private TextField buscadorInput;
    //json
    String ruta_json="resources\\alimentos.json";
    JsonReader rdr;
    private JsonObject obj;

    //@FXML private ListView<AlimentoItem> lista_alimentos;
    @FXML private Button add_alimento;
    private ObservableList<AlimentoItem> alimentoObservableList;

    public Controller(){
        alimentoObservableList = FXCollections.observableArrayList();
    }

    /* Método para añadir un nuevo alimento a la lista de alimentos seleccionados*/
    public Float updateGramos(Alimento alimento, Float gramos) {
        TextInputDialog dialog = new TextInputDialog(gramos.toString());
        dialog.setHeaderText("Introduce los gramos de "+alimento.getNombre());
        dialog.setTitle("Alimento: "+alimento.getNombre());
        dialog.setContentText("Gramos: ");

        Optional<String> result = dialog.showAndWait();

        String s = result.map(r -> {
            try {
                return "valid";
            } catch (NumberFormatException ex) {
                return "error";
            }
        }).orElse("cancel");
        // cambio

        if (s.equals("valid")) return Float.parseFloat(result.get());
        else return null;
    }

    public String getSelectedTab(){
        return "";
    }

    public boolean crearDieta(ActionEvent e) throws Exception {
        /* Verificar si se han seleccionado alimentos */
        if(!alimentoObservableList.isEmpty()){
            /* Crear datos del usuario */
            DataUser usuario = new DataUser();
            usuario.setNombre(estaVacio(nombreInput) ? nombreInput.getText() : null);
            usuario.setEdad(estaVacio(edadInput) ? Integer.parseInt(edadInput.getText()) : 0 );
            usuario.setAltura(estaVacio(alturaInput) ? Float.parseFloat(alturaInput.getText()) : 0);
            usuario.setPeso(estaVacio(pesoInput) ? Float.parseFloat(pesoInput.getText()) : 0 );
            usuario.setGenero(generoSelected.getValue()!=null ? generoSelected.getValue() : null);
            CrearDieta crearDieta = new CrearDieta(usuario,alimentoObservableList);
            crearDieta.calcularDieta(false);


            //alert_talla.setText("");
            /*else showAlert("Error", "", "Por favor, introduzca todos los datos requeridos!");*/
        }else showAlert("Error", "", "Por favor, seleccione al menos un alimento!");

        return true;
    }


    private void showAlert(String title, String header, String text){
        Alert a = new Alert(Alert.AlertType.WARNING);
        a.setTitle(title);
        a.setHeaderText(header);
        a.setContentText(text);
        a.show();
    }

    private boolean estaVacio(TextField x){
        if(x.getText().equals("")) return false;
        return true;
    }

    private void onlyFloat(TextField x){
        x.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("(\\d{0,7})([\\.]\\d{0,4})?")) {
                    if(oldValue.equals(".")){
                        x.setText("");
                        //alert_talla.setText("Mensaje: Numero primero");
                    }else{
                        x.setText(oldValue);
                        //alert_talla.setText("Mensaje: Solo números");
                    }
                } else{
                    //alert_talla.setText("");
                }
            }
        });
    }

    private void onlyInt(TextField x){
        x.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("(\\d{0,7})")) {
                        x.setText(oldValue);
                        //alert_talla.setText("Mensaje: Solo números");
                } else{
                    //alert_talla.setText("");
                }
            }
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        /* Cargar lista de género */
        cargarGenero();
        /* Asignar propiedad de solo flotantes  */
        onlyFloat(alturaInput);
        onlyFloat(pesoInput);
        onlyInt(edadInput);

        /* Darle propiedades a la tabla de alimentos seleccionados */
        setPropertiesToSelectedTable();

        /*Buscar alimentos en el json*/
        buscadorInput.setOnKeyTyped(event -> {
            buscarAlimento();
        });

        /*Añadir alimentos al buscador*/
        llenarTablaBuscador();
    }

    private void setPropertiesToSelectedTable(){
        /* Añadir alimentos a la lista*/
        tabla_seleccionado.setItems(alimentoObservableList);

        a_nombre.setCellValueFactory(new PropertyValueFactory<AlimentoItem,String>("nombre"));
        a_gramos.setCellValueFactory(new PropertyValueFactory<AlimentoItem,String>("gramos"));
        a_tipo.setCellValueFactory(new PropertyValueFactory<AlimentoItem,String>("tipo"));
        a_cantidad.setCellValueFactory(new PropertyValueFactory<AlimentoItem,Number>("cantidad"));
        a_unidad.setCellValueFactory(new PropertyValueFactory<AlimentoItem,String>("unidad"));
        a_peso_neto.setCellValueFactory(new PropertyValueFactory<AlimentoItem,Number>("pesoNeto"));
        a_calorias.setCellValueFactory(new PropertyValueFactory<AlimentoItem,Number>("calorias"));
        a_carbohidratos.setCellValueFactory(new PropertyValueFactory<AlimentoItem,Number>("carbohidratos"));
        a_proteinas.setCellValueFactory(new PropertyValueFactory<AlimentoItem,Number>("proteinas"));
        a_lipidos.setCellValueFactory(new PropertyValueFactory<AlimentoItem,Number>("lipidos"));

        tabla_seleccionado.setRowFactory(alimentoTableView -> {
            TableRow<AlimentoItem> row = new TableRow<>();
            //* Crear menu de alimento *//
            ContextMenu contextMenu = new ContextMenu();

            //* Opción de menu editar gramos de alimento *//
            MenuItem editGramos = new MenuItem();
            editGramos.textProperty().bind(Bindings.format("Editar gramos"));
            editGramos.setOnAction(event -> {
               /* Llamar ventana para editar gramos */
                Float new_gramos = updateGramos(row.getItem().getAlimento(),row.getItem().getFloatGramos());

                /* Poner nuevos gramos al alimento*/
                if(new_gramos!= null){
                    alimentoObservableList.get(row.getIndex()).setGramos(new_gramos);
                    row.getTableView().refresh();
                }


            });

            /* Opción de menu eliminar alimento de la lista*/
            MenuItem eliminarAlimento = new MenuItem();
            eliminarAlimento.textProperty().bind(Bindings.format("Eliminar \"%s\"", row.itemProperty()));
            eliminarAlimento.setOnAction(event -> tabla_seleccionado.getItems().remove(row.getItem()));

            /* Añadir el menú a cada fila*/
            contextMenu.getItems().addAll(editGramos, eliminarAlimento);

            /* Quitar propiedad a una fila que se ha eliminado */
            row.emptyProperty().addListener((obs, wasEmpty, isNowEmpty) -> {
                if (isNowEmpty){
                    row.setContextMenu(null);
                } else {
                    row.setContextMenu(contextMenu);
                }
            });

            return row;
        });
    }

    private void cargarGenero(){
        lista_genero.removeAll();
        String a="Hombre";
        String b="Mujer";
        lista_genero.addAll(a,b);
        generoSelected.getItems().addAll(lista_genero);
    }

    //Identifica los valores null en json
    private float getValueFromJson(JsonValue x){
        String value = x.toString();
        if(value.equals("null")){
            return (float) 0;
        } else{
            return Float.parseFloat(value);
        }
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
                    JsonObject platillo_base = (JsonObject) platillo.get(alimento2);
                    float calorias = getValueFromJson(platillo_base.get("calorias"));
                    float carbohidratos = getValueFromJson(platillo_base.get("carbohidratos"));
                    float proteinas = getValueFromJson(platillo_base.get("carbohidratos"));
                    float lipidos = getValueFromJson(platillo_base.get("lipidos"));
                    String unidad = platillo_base.get("unidad").toString();
                    unidad = unidad.substring(1, unidad.length()-1);
                    float peso_neto = getValueFromJson(platillo_base.get("peso neto"));
                    float cantidad = getValueFromJson(platillo_base.get("cantidad"));
                    tipo_plato = tipo_plato.toLowerCase();
                    tipo_plato = tipo_plato.substring(0,1).toUpperCase() + tipo_plato.substring(1,tipo_plato.length());

                    Alimento buscador = new Alimento(alimento2,tipo_plato, calorias, carbohidratos, proteinas, lipidos,peso_neto, unidad, cantidad );
                    lista_buscador.add(buscador);
                }
            }
            c_nombre.setCellValueFactory(new PropertyValueFactory<Alimento,String>("nombre"));
            c_tipo.setCellValueFactory(new PropertyValueFactory<Alimento,String>("tipo"));
            c_cantidad.setCellValueFactory(new PropertyValueFactory<Alimento,Number>("cantidad"));
            c_unidad.setCellValueFactory(new PropertyValueFactory<Alimento,String>("unidad"));
            c_peso_neto.setCellValueFactory(new PropertyValueFactory<Alimento,Number>("pesoNeto"));
            c_calorias.setCellValueFactory(new PropertyValueFactory<Alimento,Number>("calorias"));
            c_carbohidratos.setCellValueFactory(new PropertyValueFactory<Alimento,Number>("carbohidratos"));
            c_proteinas.setCellValueFactory(new PropertyValueFactory<Alimento,Number>("proteinas"));
            c_lipidos.setCellValueFactory(new PropertyValueFactory<Alimento,Number>("lipidos"));

            Callback<TableColumn<Alimento,String>, TableCell<Alimento,String>> cellFactory = (param) -> {
                return new TableCell<Alimento,String>(){
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
                                Alimento b=getTableView().getItems().get(getIndex());
                                try {
                                    //Accion del boton
                                    Alimento alimento = new Alimento(
                                            b.getNombre(),
                                            b.getTipo(),
                                            b.getCalorias(),
                                            b.getCarbohidratos(),
                                            b.getProteinas(),
                                            b.getLipidos(),
                                            b.getPesoNeto(),
                                            b.getUnidad(),
                                            b.getCantidad()
                                    );
                                    Float new_gramos = updateGramos(alimento, (float) 0);

                                    if(new_gramos!=null){
                                        alimentoObservableList.add(new AlimentoItem(alimento, new_gramos));
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

                // Si las letras de la búsqueda coinciden, se añade el alimento a la lista
                if (ok) {
                    JsonObject platillo_base = (JsonObject) platillo.get(alimento2);
                    float calorias = getValueFromJson(platillo_base.get("calorias"));
                    float carbohidratos = getValueFromJson(platillo_base.get("carbohidratos"));
                    float proteinas = getValueFromJson(platillo_base.get("carbohidratos"));
                    float lipidos = getValueFromJson(platillo_base.get("lipidos"));
                    String unidad = platillo_base.get("unidad").toString();
                    float peso_neto = getValueFromJson(platillo_base.get("peso neto"));
                    float cantidad = getValueFromJson(platillo_base.get("cantidad"));

                    Alimento buscador = new Alimento(alimento2,tipo_plato, calorias, carbohidratos, proteinas, lipidos, peso_neto, unidad, cantidad);
                    lista_buscador.add(buscador);
                    tabla_buscador.setItems(lista_buscador);
                }
            }
        }
    }
}


