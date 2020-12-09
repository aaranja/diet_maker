package sample.lista;

import sample.buscador.Alimento;
/* Dato que se almacena en la lista de alimentos seleccionandos
*  Recibe un dato Alimento y un String gramos.
*  - Alimentos contiene los datos del alimento seleccionando.
*  - Gramos contiene la cantidad de gramos seleccionados.
* */
public class AlimentoItem {
    private Alimento alimento;
    private String gramos;
    
    public AlimentoItem(Alimento alimento, String gramos){
        this.alimento = alimento;
        this.gramos = gramos;
    }

    public Alimento getAlimento(){ return alimento; }

    public String getGramos(){ return gramos; }

    public void setGramos(String nuevogramos) { this.gramos = nuevogramos; }

    public String toString(){ return alimento.getNombre(); }
    
}