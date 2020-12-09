package sample.buscador;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Buscador{
    private StringProperty nombre;
    private StringProperty tipo;
    private FloatProperty calorias;

    public Buscador(String nombre, String tipo, float calorias) {
        this.nombre = new SimpleStringProperty(nombre);
        this.tipo = new SimpleStringProperty(tipo);
        this.calorias = new SimpleFloatProperty(calorias);
    }

    //Metodos atributo: nombre
    public String getNombre() {
        return nombre.get();
    }
    public void setNombre(String nombre) {
        this.nombre = new SimpleStringProperty(nombre);
    }
    public StringProperty NombreProperty() {
        return nombre;
    }
    //Metodos atributo: tipo
    public String getTipo() {
        return tipo.get();
    }
    public void setTipo(String tipo) {
        this.tipo = new SimpleStringProperty(tipo);
    }
    public StringProperty TipoProperty() {
        return tipo;
    }
    //Metodos atributo: calorias
    public float getCalorias() {
        return calorias.get();
    }
    public void setCalorias(float calorias) {
        this.calorias = new SimpleFloatProperty(calorias);
    }
    public FloatProperty CaloriasProperty() {
        return calorias;
    }
}