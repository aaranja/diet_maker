package sample.seleccionado;

import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import sample.buscador.Alimento;
/* Dato que se almacena en la lista de alimentos seleccionandos
*  Recibe un dato Alimento y un String gramos.
*  - Alimentos contiene los datos del alimento seleccionando.
*  - Gramos contiene la cantidad de gramos seleccionados.
* */
public class AlimentoItem {
    private Alimento alimento;
    private Float gramos;

    public AlimentoItem(Alimento alimento, Float gramos){
        this.alimento = alimento;
        this.gramos = gramos;
    }

    public Alimento getAlimento(){ return alimento; }

    public String getNombre(){ return alimento.getNombre(); }

    public String getTipo(){ return alimento.getTipo(); }

    public Float getCalorias(){ return alimento.getCalorias(); }

    public Float getCarbohidratos(){ return alimento.getCarbohidratos(); }

    public Float getProteinas(){ return alimento.getProteinas(); }

    public Float getLipidos(){ return alimento.getLipidos(); }

    public Float getGramos(){ return this.gramos; }

    public Float getFloatGramos(){ return this.gramos; }

    public void setGramos(Float nuevogramos) { this.gramos = nuevogramos; }

    public String toString(){ return alimento.getNombre(); }

}
