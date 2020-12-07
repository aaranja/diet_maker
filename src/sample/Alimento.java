package sample;

public class Alimento {
    private Integer index = 0;
    private String nombre;
    private String gramos;

    public Alimento(String nombre, String gramos) {
        this.index++;
        this.nombre = nombre;
        this.gramos = gramos;
    }

    public String getNombre(){
        return nombre;
    }

    public String getGramos(){
        return gramos;
    }

    public int getIndex(){ return index; }

    public void setGramos(String nuevoGramos){
        this.gramos = nuevoGramos;
    }

    public String toString(){ return nombre; }
}
